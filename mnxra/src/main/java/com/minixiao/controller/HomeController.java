package com.minixiao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HealerJean on 2017/3/20.
 */
@Controller
@Transaction(readonly=true)
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private HttpServletRequest request;
    @Value("#{mnx.subdomian.suffix}")
    private String subdomain_suffix;

    //请求的方式的GET 浏览器默认进入这个页面
    @GetMapping({"/", "index.html"})
    public String home() {
        String subdomain = request.getServerName();
        logger.debug(subdomain);
        logger.info(subdomain_suffix);
        if (subdomain.endsWith(subdomain_suffix)) {
            String sub = subdomain.replace(subdomain_suffix, "");
            // 查询得到跳转
            String href = "http://www.jd.com";
            if (StringUtils.hasLength(href)) {
                return "redirect:" + href;
            }
        }

        return "redirect://www.minixiao.com";
    }
}