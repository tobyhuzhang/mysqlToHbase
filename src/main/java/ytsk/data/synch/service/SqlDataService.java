package ytsk.data.synch.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ytsk.data.synch.model.TspCompleteCondition;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


/**
 * 加载数据数
 */
public class SqlDataService {

    private SqlSessionFactory sqlSessionFactory;


    public SqlDataService(String xmlPath) {
        this.sqlSessionFactory = getSqlSessionFactory(xmlPath);
    }

    public SqlDataService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 初始化SqlSessionFactory
     *
     * @return
     */
    public SqlSessionFactory getSqlSessionFactory(String xmlPath) {
        //加载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream(xmlPath);
            return new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 分批加载综合数据信息
     *
     * @return
     */
    public List<TspCompleteCondition> batchLoadCompleteCondition(Map<String, Object> params) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<TspCompleteCondition> list = sqlSession.selectList("ytsk.data.synch.mapper.TspCompleteConditionMapper.selectThousand", params);
        sqlSession.close();
        return list;
    }


    /**
     * 根据id查找信息
     *
     * @return
     */
    public <T> T getById(Long id, Class<T> clazz) {
        String clazzName = clazz.getSimpleName();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        T value = sqlSession.selectOne("ytsk.data.synch.mapper." + clazzName + "Mapper.selectByPrimaryKey", id);
        sqlSession.close();
        return value;
    }

    /**
     * 根据id查找信息
     *
     * @return
     */
    public <T> List<T> loadAll(Class<T> clazz,Map<String, Object> params) {
        String clazzName = clazz.getSimpleName();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<T> values = sqlSession.selectList("ytsk.data.synch.mapper." + clazzName + "Mapper.selectThousand", params);
        sqlSession.close();
        return values;
    }

    public void putCompleteCondition(List<TspCompleteCondition> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("ytsk.data.synch.mapper.TspCompleteConditionMapper.insertByBatch", list);
        /*for (Employee e:list){
            sqlSession.insert("ytsk.data.synch.mapper.EmployeeMapper.insert",e);
        }*/
        sqlSession.commit();
        sqlSession.close();
    }
}
