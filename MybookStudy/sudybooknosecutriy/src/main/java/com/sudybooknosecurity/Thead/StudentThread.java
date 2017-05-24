package com.sudybooknosecurity.Thead;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HealerJean on 2017/5/10.
 */
public class StudentThread implements Runnable {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentThread.class);
    private  static int i=0;
    private List<Student> students = new ArrayList<Student>();

    public StudentThread(List<Student> students) {
        this.students = students;

    }

    public void run() {

        for (Student student : students) {
            i = i+1;
            logger.info("数量为"+i);
            System.out.println("当前线程：" + Thread.currentThread().getName());
            System.out.println("name = " + student.getName() + " age = "
                    + student.getAge() + " sex = " + student.getSex());
            // 导入学生信息到数据库中
        }
    }

}