package com.studybook.Test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 需要导入junit 包
 * Created by HealerJean on 2017/5/8.
 */
public class TestMy {
 @Autowired
 TestService testService;
    @Test
    public void testHello(){
        TestService testService = new TestService();
        testService.hello();
    }
    @Test
    public void testMapRemove(){
        //会报空异常
        System.out.println(testService.testMapRemove());
    }
}
