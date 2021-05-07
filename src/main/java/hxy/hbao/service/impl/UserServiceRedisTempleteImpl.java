package hxy.hbao.service.impl;

import hxy.hbao.dao.UserInfoDao;
import hxy.hbao.domain.UserInfo;
import hxy.hbao.exception.MyRedisException;
import hxy.hbao.service.UserService;
import hxy.hbao.tool.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.PoolException;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceRedisTempleteImpl implements UserService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private UserInfoDao userDao;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //  @Resource
    //  private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String, Object> valueOperations;

    @Resource
    private HashOperations<String, String, Object> hashOperations;

    @Resource
    private ListOperations<String, Object> listOperations;

    @Resource
    private SetOperations<String, Object> setOperations;

    @Resource
    private ZSetOperations<String, Object> zSetOperations;

    @Resource
    private RedisService redisService;

    /**
     * Redis命令 ==》 Lettuce => RedisTemplate进一步的封装
     * redis String类型
     * 用户输入一个key,先判断Redis是否存在数据，存在就在Redis中查询，
     * 不存在就在Mysql数据库查询(模拟)。将结果返回给Redis
     */
    @Override
    public UserInfo get(Integer id) {
/*
        log.info("RedisTemplate ==> 测试");
        List<String> sNames = new ArrayList<String>();
        sNames.forEach();
        List<String> filtered = sNames.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        String value = null;
        String sKey = id.toString();
        //hasKey 相当于 exist
        boolean bKeyExist = false;
        boolean bException = false;
        try {
            //获取redis数据
            bKeyExist = redisTemplate.hasKey(sKey);
        } catch (Exception e) {
            bException = true;
            if (e instanceof MyRedisException) {
                //redis 异常处理
                log.warn("redis accept ecption!" + e.getMessage());
            } else if (e instanceof RedisConnectionFailureException) {
                log.warn("accept RedisConnectionFailureException ecption!" + e.toString());
            } else if (e instanceof PoolException) {
                log.warn("accept RedisConnectionException ecption!" + e.getMessage());
            } else {
                log.warn(" accept other ecption!" + e.getMessage());
                //  return null;
            }
        }
        if (bKeyExist) {
            log.info("=== Redis查询到数据 ===");
            return (UserInfo) redisTemplate.opsForValue().get(sKey);
        } else {
            UserInfo userInfo = userDao.get(id);

            log.info("Redis没有查询到，存入:" + userInfo.toString());
            if (!bException) {
                redisTemplate.opsForValue().set(sKey, userInfo);
                redisTemplate.expire(sKey, 60, TimeUnit.SECONDS);
            }
            return userInfo;
        }*/

        return null;
    }

    @Override
    public List<UserInfo> findAll() {
        return null;
    }

    @Override
    public int count(Map<String, Object> map) {
        return 1;
    }

    @Override
    public UserInfo save(UserInfo user) {
        valueOperations.set("test", user);
        redisService.expireKey("test", 60, TimeUnit.SECONDS);
        UserInfo auserVo = new UserInfo(111, "sfa", 22, "sdfds");
        setOperations.add("user:test1", user, auserVo);
        redisService.expireKey("user:test1", 60, TimeUnit.SECONDS);
        Set<Object> result = setOperations.members("user:test");
        redisService.expireKey("user:test", 60, TimeUnit.SECONDS);
        hashOperations.put("user:user", user.hashCode() + "", user);
        redisService.expireKey("user:user", 60, TimeUnit.SECONDS);
        System.out.println(hashOperations.get("hash:user", user.hashCode() + ""));
        listOperations.leftPush("list:user", user);
        redisService.expireKey("list:user", 60, TimeUnit.SECONDS);
        return null;
    }

    @Override
    public int update(UserInfo user) {

        return 1;
    }

    @Override
    public int remove(Integer id) {
        return 1;
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return 1;
    }
}
