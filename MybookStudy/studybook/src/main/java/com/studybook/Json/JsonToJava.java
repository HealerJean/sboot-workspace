package com.studybook.Json;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by HealerJean on 2017/4/6.
 */
public class JsonToJava {
    public static void main(String[] args) {
        String jsonStr = "[{\"assignNo\":\"201310091540\", \"deliveryStatus\":\"66666\",\"id\":\"1\", \"remark\":\"YY\",\"userName\":\"ZHANGSAN\"}, {\"assignNo\":\"3215242251522215\", \"deliveryStatus\":\"33333\",\"id\":\"3\", \"imgName\":\"1381314903597.png\",\"imgStr\": \"1381314903597.png\",\"remark\":\"\", \"userName\":\"ZHANGSAN\"}]";

        //将json字符串数组转换为json数组对象
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);

        Object[] objs = jsonArray.toArray();

        for (Object object : objs) {

            JSONObject jsonObject = JSONObject.fromObject(object);

            System.out.println(jsonObject.toString());

        }


    }

    /**
     *
     * 2.将json字符串转换为java对象
     同样先将json字符串转换为json对象，再将json对象转换为java对象，如下所示。
     JSONObject obj = new JSONObject().fromObject(jsonStr);//将json字符串转换为json对象
     将json对象转换为java对象
     Person jb = (Person)JSONObject.toBean(obj,Person.class);//将建json对象转换为Person对象

     3.将java对象转换为json字符串
     先将java对象转换为json对象，在将json对象转换为json字符串
     JSONObject json = JSONObject.fromObject(obj);//将java对象转换为json对象
     String str = json.toString();//将json对象转换为字符串

     */
}
