package com.minixiao.controller;

import com.minixiao.domain.Mnxra;
import com.testSqlite.TestSQLite;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by HealerJean on 2017/3/20.
 */
@Controller
public class LoginController {
    //请求的方式的GET
    TestSQLite testSqlite;
    @RequestMapping(value = "/mng/index" ,method = RequestMethod.GET)
    public String index(){

        return "index";
    }

    /**
     * 首页显示内容
     * @return
     */
    @RequestMapping(value = "/mng/login" ,method = RequestMethod.GET)
    public ModelAndView findall(){
        testSqlite = new TestSQLite();
        ModelAndView mv = new ModelAndView("find");
        List<Mnxra>  mnxras = testSqlite.queryAll();
        mv.addObject("mnxras",mnxras);
        return mv;
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    //@DeleteMapping(value = "/mng/delete/{id}")
    @RequestMapping(value = "/mng/delete/{id}" ,method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Integer id){
        System.out.println("来到删除页面");
        testSqlite = new TestSQLite();
        testSqlite.del(id);
        ModelAndView mv = new ModelAndView("find");
        List<Mnxra>  mnxras = testSqlite.queryAll();
        mv.addObject("mnxras",mnxras);
        return mv;
    }
    /**
     * 更新首页
     */
    @RequestMapping(value = "/mng/updateindex/{id}" ,method = RequestMethod.GET)
    public ModelAndView updateindex(@PathVariable("id") Integer id){
        testSqlite = new TestSQLite();
        Mnxra mnxra = testSqlite.findByid(id);
        ModelAndView mv = new ModelAndView("update");
        mv.addObject("mnxra",mnxra);
        return mv;
    }


    /**
     * 更新功能
     * @param id
     * @param name
     * @param href
     * @param subdomain
     *
     * @return
     */
    @RequestMapping(value = "/mng/update" ,method = RequestMethod.GET)
    public ModelAndView update(@RequestParam("id") Integer id, @RequestParam("name") String name,@RequestParam("href") String href,@RequestParam("subdomain") String subdomain,@RequestParam("createtime") String createtime){
      System.out.println("来到这更新页面了");
        Mnxra mnxra = new Mnxra();
        mnxra.setName(name);
        mnxra.setHref(href);
        mnxra.setSubdomain(subdomain);
        mnxra.setId(id);
        testSqlite = new TestSQLite();
        testSqlite.update(mnxra);
        Mnxra mnxraupdate = testSqlite.findByid(id);
        ModelAndView mv = new ModelAndView("update");
        mv.addObject("mnxra",mnxraupdate);
        return mv;
    }

    /**
     * 添加首页面
     * @return
     */
    @RequestMapping(value = "/mng/addindex" ,method = RequestMethod.GET)
    public String addindex(){

        return "add";
    }
    /**
     * 添加功能
     */
    @RequestMapping(value = "/mng/add" ,method = RequestMethod.GET)
    public ModelAndView add( @RequestParam("name") String name,@RequestParam("href") String href,@RequestParam("subdomain") String subdomain){
        System.out.println("来到这更新页面了");
        Mnxra mnxra = new Mnxra();
        mnxra.setName(name);
        mnxra.setHref(href);
        mnxra.setSubdomain(subdomain);
        testSqlite = new TestSQLite();
        testSqlite.add(mnxra);
        ModelAndView mv = new ModelAndView("find");
        List<Mnxra>  mnxras = testSqlite.queryAll();
        mv.addObject("mnxras",mnxras);
        return mv;

    }


    /**
     * 查找功能 未用到
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/mng/find" ,method = RequestMethod.GET)
    public String find(@PathVariable("id") int id,Map<String, Object> map){
        testSqlite = new TestSQLite();
        Mnxra mnxra = testSqlite.findByid(id);
        map.put("mnxra",mnxra);
        return "find";
    }





}