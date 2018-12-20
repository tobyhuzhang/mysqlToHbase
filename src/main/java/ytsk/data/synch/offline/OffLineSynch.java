package ytsk.data.synch.offline;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ytsk.data.synch.hbase.DateUtils;
import ytsk.data.synch.hbase.HbaseUtils;
import ytsk.data.synch.model.TemperatureRecord;
import ytsk.data.synch.model.TspCompleteCondition;
import ytsk.data.synch.model.TspVehicleCondition;
import ytsk.data.synch.model.TspVehicleEvent;
import ytsk.data.synch.service.SqlDataService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 离线同步数据
 */
public class OffLineSynch {
    static final Log LOG = LogFactory.getLog(OffLineSynch.class);

    /**
     * 从关系型数据库同步数据到hbase
     */
    public void synchToHbase() {
        //加载数据
        SqlDataService sqlDataService = new SqlDataService("SqlMapConfig.xml");

        Map<String, Object> params = new HashMap<String, Object>(16);
        int offset = 0;//开始位置，从0行开始查询
        int limit = 100000;//偏移量
        List<TspCompleteCondition> tccList = null;
        List<TspVehicleCondition> tvcList = null;
        List<TemperatureRecord> trList = null;
        List<TspVehicleEvent> tveList = null;
        HbaseUtils hbaseUtils = new HbaseUtils();

        try {
            do {
                long startTime = System.currentTimeMillis();
                params.put("offset", offset);
                params.put("limit", limit);
                //tccList= sqlDataService.loadAll(TspCompleteCondition.class, params);
                tvcList = sqlDataService.loadAll(TspVehicleCondition.class, params);
//                hbaseUtils.checkAndCreateTable(TspCompleteCondition.class);
                hbaseUtils.checkAndCreateTable(TspVehicleCondition.class);
//                hbaseUtils.checkAndCreateTable(TemperatureRecord.class);
//                hbaseUtils.checkAndCreateTable(TspVehicleEvent.class);
//                hbaseUtils.putData(tccList);
                hbaseUtils.putData(tvcList);
//                hbaseUtils.putData(trList);
//                hbaseUtils.putData(tveList);
//                Scan scan = new Scan();
                offset += limit;
                long endTime = System.currentTimeMillis();
                LOG.info("每100000条导入时间：" + (endTime - startTime) / 1000 + "s");
            } while (tvcList.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hbaseUtils.close();
        }
    }

    /**
     * 从hbase同步数据到关系型数据库
     */
//    public void synchFromHbase() {
//        HbaseUtils hbaseUtils = new HbaseUtils();
//        List<Employee> employees;
//        List<EducationExperience> educations;
//        //List<TspCompleteCondition> tspCompleteCondition;
//        try {
//            //将数据添加到hbase
//            employees = hbaseUtils.scanData(new Scan(), Employee.class);
//            educations = hbaseUtils.scanData(new Scan(), EducationExperience.class);
////            tspCompleteCondition = hbaseUtils.scanData(new Scan(), TspCompleteCondition.class);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            hbaseUtils.close();
//        }
//
//        //加载数据
//        SqlDataService sqlDataService = new SqlDataService("SqlMapConfig.xml");
//        LOG.info("hbase同步mysql 综合数据");
//        sqlDataService.putEmployee(employees);
//        sqlDataService.putEducationExperience(educations);
//        //sqlDataService.putCompleteCondition(tspCompleteCondition);
//
//    }

    /**
     * 根据vin和时间段查询
     */
    public void selectByVin() {
        long start = System.currentTimeMillis() / 1000;
        HbaseUtils hbaseUtils = new HbaseUtils();
        try {
            Date fromTime = DateUtils.parse("2018-12-19 16:34:30");
            Date endTime = new Date();
            List<TspCompleteCondition> list = hbaseUtils.scanDataByTime("tspVehicleCondition", TspCompleteCondition.class, "LEFYECG28JHN55053", fromTime, endTime);
            if (list != null && list.size() > 0) {
                System.out.println("总条数：" + list.size());
//                for(TspCompleteCondition tcc:list) {
//                    System.out.println("vin----"+tcc.getVin());
//                    System.out.println("atime--"+DateUtils.format(tcc.getAcquisitionTime(), DateUtils.FORMAT_FULL_CN));
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis() / 1000;
        LOG.info("查询时间：" + (end - start) + "s");

    }
}
