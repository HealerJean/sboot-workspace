package com.studybook.Test;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HealerJean on 2017/5/8.
 */
@Service
public class TestService {

    public void hello(){
        System.out.println("测试");
    }

    /**
     * 测试 map.remove(移除数据后的是什么东西
     * @return
     */
    public Object  testMapRemove(){
        Map<String,Object> map = new HashMap<>();
        map.put("mapOne","mapOneValue");
        return  map.remove("mapOne");
    }
}
