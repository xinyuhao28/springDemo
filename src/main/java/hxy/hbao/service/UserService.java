package hxy.hbao.service;

import hxy.hbao.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserInfo get(Integer id);

    List<UserInfo> findAll();

    int count(Map<String, Object> map);

    UserInfo save(UserInfo user);

    int update(UserInfo user);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
