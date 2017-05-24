package com.testSqlite;

import com.minixiao.domain.Mnxra;
import org.springframework.stereotype.Component;

import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestSQLite {
    public static void main(String[] args) {
  //   测试查找
  /*  Mnxra mnxra = new Mnxra();
   mnxra = new TestSQLite().queryById(1);
    System.out.print(mnxra);*/


 /*    测试保存
    Mnxra mnxra = new Mnxra("taobao","www.taobao.com","taobao");
        new TestSQLite().save(mnxra);
*/
/*    测试删除
    if(new TestSQLite().del(10)){
            System.out.print("删除成功");
        }
*/
/*
  测试更新
 Mnxra mnxra = new Mnxra(3,"淘宝","www.taobao.com","taobao");
        new TestSQLite().update(mnxra);
*/
/*查找所有的
    new TestSQLite().queryAll();
*/


        new TestSQLite().findBysubdomain("jd2");
    }

    protected static Connection connect = null;
    protected static Statement stmt = null;
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:D:/workspace/StudySpringBoot/mnxra/src/main/resources/test.db");
           // :C:/Users/anialy/Desktop/workspace/MyProj/db/MY_DB"
          //  D:/workspace/StudySpringBoot/mnxra/src/main/resources/test.db
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Opened database successfully");
    }

    public void createTable() {
        try {
            connect.setAutoCommit(false);

            stmt = connect.createStatement();

            String sql = "create table user(id int,name text,sex text)";

            stmt.executeUpdate(sql);
            System.out.println("create data success");

            // 提交
            connect.commit();

            // 关闭Statement


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testsave() {
        try {
            connect.setAutoCommit(false);

            stmt = connect.createStatement();
         //   insert into mnxra (name,href,subdomian,createtime) VALUES ('京东', 'www.jd.com', 'jd',(select datetime('now','localtime')));
            String sql = "insert into mnxra (name,href,subdomain,createtime) VALUES ('京东', 'www.jd.com', 'jd',(select datetime('now','localtime')))";
            // 执行
            int count = stmt.executeUpdate(sql);
            if (count > 0) {
                System.out.println("insert data success");
            } else {
                System.out.println("insert data fail");
            }

            // 提交
            connect.commit();
            // 关闭Statement
            stmt.close();
            // 关闭Connection
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Mnxra mnxra) {
        try {
            connect.setAutoCommit(false);

            stmt = connect.createStatement();

            String sql = "insert into mnxra (name,href,subdomain,createtime) VALUES ('"+mnxra.getName()+"','"+mnxra.getHref()+"','"+mnxra.getSubdomain()+"',(select datetime('now','localtime')))";

            int count = stmt.executeUpdate(sql);
            if (count > 0) {
                System.out.println("insert data success");
            } else {
                System.out.println("insert data fail");
            }

            // 提交
            connect.commit();
            // 关闭Statement

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean del(int id) {
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "delete from mnxra where id = " + id;
            int count = stmt.executeUpdate(sql);
            connect.commit();

            if (count > 0) {
                return true;
            } else {
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void update(Mnxra mnxra) {
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "update  mnxra  set name = '"+mnxra.getName()+"',href ='"+mnxra.getHref()+"',subdomain ='"+mnxra.getSubdomain()+"' where id = "+ mnxra.getId();
            //        String sql = "update  mnxra  set name = 'zhangyujin',href="+mnxra.getHref()+"subdomain='"+mnxra.getSubdomain()+"' where id = "+ mnxra.getId();

            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                System.out.println("update data success");
            } else {
                System.out.println("update data fail");
            }
            connect.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Mnxra findByid(int id) {
        Mnxra mnxra = new Mnxra();
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "select * from mnxra where id = "+id;

            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                mnxra.setId(result.getInt("id"));
                mnxra.setName(result.getString("name"));
                mnxra.setHref(result.getString("href"));
                mnxra.setSubdomain(result.getString("subdomain"));
                mnxra.setCreatetime(result.getString("createtime"));
/*测试*/

                System.out.println(result.getInt("id"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("href"));
                System.out.println(result.getString("subdomain"));
                System.out.println(result.getString("createtime"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  mnxra;
    }

    public List<Mnxra> queryAll() {
        List<Mnxra> mnxras = new ArrayList<Mnxra>();

        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "select * from mnxra";

            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                Mnxra mnxra = new Mnxra(result.getInt("id"),result.getString("name"),result.getString("href"),result.getString("subdomain"),result.getString("createtime"));
                System.out.print(mnxra.getCreatetime());
                System.out.println(result.getInt("id"));
                System.out.println(result.getString("name"));
                mnxras.add(mnxra);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  mnxras;

    }

    public String findBysubdomain(String subdomain) {
        Mnxra mnxra = new Mnxra();
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "select href from mnxra where subdomain = '"+subdomain+"'";

            ResultSet result = stmt.executeQuery(sql);
            if(result.next()) {

                result.getString(1);
                mnxra.setHref(result.getString("href"));

/*测试*/
                System.out.println(result.getString(1));


                System.out.println(result.getString("href"));

                return   result.getString(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  "";
    }





}
