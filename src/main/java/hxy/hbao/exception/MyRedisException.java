package hxy.hbao.exception;

import io.lettuce.core.RedisConnectionException;
import io.lettuce.core.RedisException;

public class MyRedisException extends RedisException {
    public MyRedisException(String msg){
        super(msg);
    }
}
