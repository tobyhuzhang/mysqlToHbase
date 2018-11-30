package qjm.data.synch.offline;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.ibatis.session.SqlSession;
import qjm.data.synch.hbase.HbaseUtils;
import qjm.data.synch.modle.EducationExperience;
import qjm.data.synch.modle.Employee;
import qjm.data.synch.modle.TspCompleteCondition;
import qjm.data.synch.service.SqlDataService;

import java.io.IOException;
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

        //加载员工信息
        List<Employee> employees = sqlDataService.loadEmployee();
//        //加载学历信息
//        List<EducationExperience> educations = sqlDataService.loadEducationExperience();
        HbaseUtils hbaseUtils = new HbaseUtils();
        //将数据添加到hbase
        try {

            hbaseUtils.checkAndCreateTable(Employee.class);
            hbaseUtils.putData(employees);
            LOG.info("插入HBase职工数据"+employees);
//            hbaseUtils.checkAndCreateTable(EducationExperience.class);
//            hbaseUtils.putData(educations);
//            LOG.info("插入HBase教育经历数据"+educations);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            hbaseUtils.close();
        }

//        Map<String, Object> params = new HashMap<String, Object>(16);
//        int offset = 0;//开始位置，从0行开始查询
//        int limit = 10000;//偏移量
//        List<TspCompleteCondition> tccList = null;
//        SqlSession sqlSession = sqlDataService.getSqlSessionFactory("SqlMapConfig.xml").openSession();
//        int count = 0;
//        HbaseUtils hbaseUtils = new HbaseUtils();
//        try {
//            do {
//                params.put("offset", offset);
//                params.put("limit", limit);
//                tccList = sqlSession.selectList("qjm.data.synch.mapper.TspConditionMapper.selectThousand", params);
//                LOG.info("插入HBase 综合数据" + tccList.size() + "条");
//                hbaseUtils.checkAndCreateTable(TspCompleteCondition.class);
//                hbaseUtils.putData(tccList);
////                Scan scan = new Scan();
////                List<TspCompleteCondition> list = hbaseUtils.scanData(scan, TspCompleteCondition.class);
////                    System.out.println("插入HBase"+list.size());
//                offset += limit;
//            } while (tccList.size()>0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            hbaseUtils.close();
//            sqlSession.close();
//        }
    }

    /**
     * 从hbase同步数据到关系型数据库
     */
    public void synchFromHbase() {
        HbaseUtils hbaseUtils = new HbaseUtils();
        List<Employee> employees;
        List<EducationExperience> educations;
        //List<TspCompleteCondition> tspCompleteCondition;
        try {
            //将数据添加到hbase
            employees = hbaseUtils.scanData(new Scan(), Employee.class);
            educations = hbaseUtils.scanData(new Scan(), EducationExperience.class);
//            tspCompleteCondition = hbaseUtils.scanData(new Scan(), TspCompleteCondition.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            hbaseUtils.close();
        }

        //加载数据
        SqlDataService sqlDataService = new SqlDataService("SqlMapConfig.xml");
        LOG.info("hbase同步mysql 综合数据");
        sqlDataService.putEmployee(employees);
        sqlDataService.putEducationExperience(educations);
        //sqlDataService.putCompleteCondition(tspCompleteCondition);

    }
}
