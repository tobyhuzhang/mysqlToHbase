package ytsk.data.synch.online;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.*;
import com.alibaba.otter.canal.protocol.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.util.Bytes;
import ytsk.data.synch.hbase.HbaseSerialization;
import ytsk.data.synch.hbase.HbaseUtils;
import ytsk.data.synch.model.TspCompleteCondition;
import ytsk.data.synch.model.TspVehicleCondition;
import ytsk.data.synch.service.SqlDataService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实时同步数据
 */
public class OnlineSynch {
    static final Log LOG = LogFactory.getLog(OnlineSynch.class);

    SqlDataService sqlDataService = new SqlDataService("SqlMapConfig.xml");
    HbaseUtils hbaseUtils = new HbaseUtils();

    /**
     * 从关系型数据库同步数据到hbase
     */
    public void synchToHbase() {
        // 创建链接
        CanalConnector connector = CanalConnectors.newSingleConnector(
                new InetSocketAddress("192.168.11.234", 11111), "example", "", "");

        connector.connect();
        //匹配grg_hr数据库前缀ims_t开头的那些表
        connector.subscribe("grg_hr\\.ims_t.*");
        connector.rollback();

        while (true) {
            Message message = connector.getWithoutAck(1000);
            long batchId = message.getId();
            if (batchId == -1 || message.getEntries().isEmpty()) {
                System.out.println("sleep");
                try {
                    Thread.sleep(3000);
                    continue;
                } catch (InterruptedException e) {
                    LOG.error("Error: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            handleEntry(message.getEntries());
            connector.ack(batchId);
        }
    }

    private static void printColumns(List<Column> columns) {
        String line = columns.stream()
                .map(column -> column.getName() + "=" + column.getValue())
                .collect(Collectors.joining(","));
        System.out.println(line);
    }

    /**
     * 处理
     *
     * @param entries
     */
    private void handleEntry(List<Entry> entries) {
        //循环事件
        for (Entry entry : entries) {
            if (entry.getEntryType() != EntryType.ROWDATA) {
                continue;
            }

            RowChange rowChange = null;
            int count = 0;
            try {
                rowChange = RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
            }
            Header header = entry.getHeader();
            for (RowData rowData : rowChange.getRowDatasList()) {
                switch (rowChange.getEventType()) {
                    case INSERT:
                    case UPDATE:
                        System.out.print("UPSERT ");
                        //printColumns(rowData.getAfterColumnsList());

                        if ("ims_tspvehiclecondition".equals(entry.getHeader().getTableName())) {
                            updateData(header.getTableName(), rowData.getAfterColumnsList());
                            LOG.info(rowData.getAfterColumns(10).getValue());
                            count++;
                        } else if ("ims_tsp_completecondition".equals(entry.getHeader().getTableName())) {
                            // updateData(header.getTableName(), rowData.getAfterColumnsList());
                        }
                        break;

                    case DELETE:
                        System.out.print("DELETE ");
                        //printColumns(rowData.getBeforeColumnsList());
                        break;

                    default:
                        break;
                }
            }
            //输出事件信息
//            LOG.info(String.format("\n================&gt; binlog[%s:%s] , name[%s,%s] , eventType : %s",
//                    header.getLogfileName(), header.getLogfileOffset(),
//                    header.getSchemaName(), header.getTableName(),
//                    entry.getEntryType()));
//
//            //解析事件
//            for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
//                if (eventType == EventType.DELETE) {
//                    LOG.info("\n-------&gt; delete");
//                    deleteData(header.getTableName(), rowData.getBeforeColumnsList());
//                } else if (eventType == EventType.INSERT) {
//                    LOG.info("\n-------&gt; insert");
//                    updateData(header.getTableName(), rowData.getAfterColumnsList());
//                } else if (eventType == EventType.UPDATE) {
//                    //LOG.info("\n-------&gt; before");
//                    //printColumn(rowData.getBeforeColumnsList());
//                    LOG.info("\n-------&gt; after");
//                    updateData(header.getTableName(), rowData.getAfterColumnsList());
//                }
//            }
        }
    }

    /**
     * 更新数据
     */
    private void updateData(String tableName, List<Column> columns) {
        /**
         * 1. 获取主键
         * 2. 根据主键查询
         * 3. 更新到hbase
         */
        //获取主键
        Long key = getKey(columns);

        HbaseSerialization serialization = null;
        //根据不同表做处理
        try {
            if (tableName.equals("ims_tspvehiclecondition")) {
                serialization = sqlDataService.getById(key, TspVehicleCondition.class);
                hbaseUtils.checkAndCreateTable(TspVehicleCondition.class);
            }
//            else if (tableName.equals("ims_tsp_completecondition")) {
//                serialization = sqlDataService.getById(key, TspCompleteCondition.class);
//                hbaseUtils.checkAndCreateTable(TspCompleteCondition.class);
//            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

        if (serialization != null) {
            try {

                hbaseUtils.putData(serialization);
//                Employee employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
//                LOG.info("before : \n" + employee);
//
//                hbaseUtils.putData(serialization);
//                LOG.info("putData : \n" + employee);
//
//                employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
//                LOG.info("before : \n" + employee);
//                TspCompleteCondition tcc = hbaseUtils.getData(new Get(Bytes.toBytes(key)), TspCompleteCondition.class);
//                LOG.info("before : \n" + tcc);
//
//                hbaseUtils.putData(serialization);
//                LOG.info("putData : \n" + tcc);
//
//                tcc = hbaseUtils.getData(new Get(Bytes.toBytes(key)), TspCompleteCondition.class);
//                LOG.info("before : \n" + tcc);
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
    }

    /**
     * 删除数据
     */
    private void deleteData(String tableName, List<Column> columns) {
        /**
         * 1. 获取主键
         * 2. 根据主键删除hbase数据
         */
        //获取主键
        Long key = getKey(columns);

        Class clazz = null;
        //根据不同表做处理
        if (tableName.equals("tspCompleteCondition")) {
            clazz = TspCompleteCondition.class;
        }

        try {
//            Employee employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
//            LOG.info("before : \n" + employee);
//
//            hbaseUtils.deleteData(clazz, new Delete(Bytes.toBytes(key)));
//
//            employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
//            LOG.info("after : \n" + employee);
            TspCompleteCondition tcc = hbaseUtils.getData(new Get(Bytes.toBytes(key)), TspCompleteCondition.class);
            LOG.info("before : \n" + tcc);

            hbaseUtils.deleteData(clazz, new Delete(Bytes.toBytes(key)));

            tcc = hbaseUtils.getData(new Get(Bytes.toBytes(key)), TspCompleteCondition.class);
            LOG.info("after : \n" + tcc);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

    }

    /**
     * 获取主键
     *
     * @return
     */
    private Long getKey(List<Column> columns) {
        try {
            for (Column column : columns) {
                if (column.getName().equals("id")) {
                    return Long.valueOf(column.getValue());
                } else if (column.getName().equals("Id")) {
                    return Long.valueOf(column.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not found primary key !");
        }
        throw new RuntimeException("Not found primary key !");
    }

}
