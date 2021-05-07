package hxy.hbao.service.impl;

import hxy.hbao.dao.UserInfoDao;
import hxy.hbao.domain.UserInfo;
import hxy.hbao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@CacheConfig(cacheNames = {"project:usercache"})
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoDao userDao;

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public UserInfo get(Integer id){
        log.info("get data from DB");
        return userDao.get(id);
    }

    @Override
    @Cacheable
    public List<UserInfo> findAll(){

        return userDao.findAll();
    }

    @Override
    public int count(Map<String, Object> map){
        return 1;//userDao.count(map);
    }

    @Override
    @CachePut(key = "#user.getId()")
    public UserInfo save(UserInfo user){
         userDao.save(user);

        return user;
    }

    @Override
    public int update(UserInfo user){
        return 1;//userDao.update(user);
    }

    @Override
    public int remove(Integer id){
        return 1;//userDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids){
        return 1;//userDao.batchRemove(ids);
    }
}
