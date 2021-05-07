package hxy.hbao.dao;

import hxy.hbao.domain.UserInfo;
import hxy.hbao.tool.DbOper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
//@Mapper
@Repository
public class  UserInfoDao {

    /**
     * 对应节点 select id="get" resultType="com.fishpro.mybatis.domain.UserDO"
     * */
      public UserInfo get(Integer id){
          SqlSession sqlSession = DbOper.getSqlSession();
          try{
//映射⽂件的命名空间.SQL⽚段的ID，就可以调⽤对应的映射⽂件中的SQL
              return sqlSession.selectOne("UserInfoDaoID.getById",id);

          }catch(Exception e){
              e.printStackTrace();
              sqlSession.rollback();
              throw e;
          }finally {
              DbOper.closeSqlSession();
          }
      }
    /**
     * 对应节点 select id="list" resultType="com.fishpro.mybatis.domain.UserDO"
     * */
    public List<UserInfo> findAll(){
        SqlSession sqlSession = DbOper.getSqlSession();
        try{
//映射⽂件的命名空间.SQL⽚段的ID，就可以调⽤对应的映射⽂件中的SQL
            return sqlSession.selectList("UserInfoDaoID.list");

        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally {
            DbOper.closeSqlSession();
        }
    }
    /**
     * 对应节点 select id="count" resultType="int"
     * */
 //   int count(Map<String, Object> map);
    /**
     * 对应节点 insert id="save" parameterType="com.fishpro.mybatis.domain.UserDO" useGeneratedKeys="true" keyProperty="id"
     * */
    public void save(UserInfo user) {
        SqlSession sqlSession = DbOper.getSqlSession();
        try{
//映射⽂件的命名空间.SQL⽚段的ID，就可以调⽤对应的映射⽂件中的SQL
            sqlSession.insert("UserInfoDaoID.save", user);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally {
            DbOper.closeSqlSession();
        }
    }
    /**
     * 对应节点 update id="update" parameterType="com.fishpro.mybatis.domain.UserDO"
     * */
  //  int update(UserInfo user);
    /**
     * 对应节点 delete id="remove"
     * */
 //   int remove(Integer id);
    /**
     * 对应节点 delete id="batchRemove"
     * */
  //  int batchRemove(Integer[] ids);
}
