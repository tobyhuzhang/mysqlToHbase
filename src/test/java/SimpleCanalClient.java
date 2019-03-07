import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.*;
import com.alibaba.otter.canal.protocol.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.stream.Collectors;


import java.net.InetSocketAddress;
import java.util.List;

/**
 * canal测试类
 */
public class SimpleCanalClient {
    static final Log LOG = LogFactory.getLog(SimpleCanalClient.class);

    public static void main(String[] args) throws Exception {
        CanalConnector connector = CanalConnectors.newSingleConnector(
                new InetSocketAddress("192.168.11.239", 11111), "example", "", "");

        connector.connect();
        connector.subscribe("grg_hr\\ims_tsp_completecondition");
        connector.rollback();

        while (true) {
            Message message = connector.getWithoutAck(100);
            long batchId = message.getId();
            if (batchId == -1 || message.getEntries().isEmpty()) {
                System.out.println("sleep");
                Thread.sleep(3000);
                continue;
            }
            printEntries(message.getEntries());
            connector.ack(batchId);
        }
    }

    private static void printEntries(List<Entry> entries) throws Exception {
        for (Entry entry : entries) {
            if (entry.getEntryType() != EntryType.ROWDATA) {
                continue;
            }

            RowChange rowChange = RowChange.parseFrom(entry.getStoreValue());
            for (RowData rowData : rowChange.getRowDatasList()) {
                switch (rowChange.getEventType()) {
                    case INSERT:
                    case UPDATE:
                        System.out.print("UPSERT ");
                        printColumns(rowData.getAfterColumnsList());

                        if ("ims_tspvehiclecondition".equals(entry.getHeader().getTableName())) {
                            String tableName = rowData.getAfterColumns(1).getValue();
                            String pkValue = rowData.getAfterColumns(0).getValue();
                            System.out.println("SELECT * FROM " + tableName + " WHERE id = " + pkValue);
                        }
                        break;

                    case DELETE:
                        System.out.print("DELETE ");
                        printColumns(rowData.getBeforeColumnsList());
                        break;

                    default:
                        break;
                }
            }
        }
    }

    private static void printColumns(List<Column> columns) {
        String line = columns.stream()
                .map(column -> column.getName() + "=" + column.getValue())
                .collect(Collectors.joining(","));
        System.out.println(line);
    }

}
