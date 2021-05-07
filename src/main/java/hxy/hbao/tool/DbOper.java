package hxy.hbao.tool;



import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
@Slf4j
public class DbOper {
    private static ThreadLocal<SqlSession> threadLocal = new
            ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;
    /**
     * 加载位于src/mybatis.xml配置⽂件
     */
    static{
        try {
            Reader reader = Resources.getResourceAsReader("conf/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            log.info("mysql connect succeed!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 禁⽌外界通过new⽅法创建
     */
    private DbOper(){}
/**
 * 获取SqlSession
 */
    public static SqlSession getSqlSession(){
//从当前线程中获取SqlSession对象
        SqlSession sqlSession = threadLocal.get();
//如果SqlSession对象为空
        if(sqlSession == null){
//在SqlSessionFactory⾮空的情况下，获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
//将SqlSession对象与当前线程绑定在⼀起
            threadLocal.set(sqlSession);
        }
//返回SqlSession对象
        return sqlSession;
    }
    /**
     * 关闭SqlSession与当前线程分开
     */
    public static void closeSqlSession() {
//从当前线程中获取SqlSession对象
        SqlSession sqlSession = threadLocal.get();
//如果SqlSession对象⾮空
        if (sqlSession != null) {
//关闭SqlSession对象
            sqlSession.close();
//分开当前线程与SqlSession对象的关系，⽬的是让GC尽早回收
            threadLocal.remove();
        }
    }
    public static Connection getConnection(){
        Connection conn = getSqlSession().getConnection();
        log.info(conn!=null?"连接成功":"连接失败");
        return conn;
    }

}
