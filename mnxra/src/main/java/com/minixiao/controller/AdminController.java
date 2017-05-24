package com.minixiao.controller;

import com.minixiao.domain.Subdomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by HealerJean on 2017/3/21.
 */
@Controller
@RequestMapping("/mnx")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("login.html")
    public String login() {
        return "login";
    }

    @PostMapping("login.html")
    public String login(String username, String password, Model model) {
        // TODO:
        if (true) {
            return "redirect:/mnx/index.html";
        }
        model.addAttribute("username", username);
        return "login";
    }

    @GetMapping("index.html")
    public String home() {
        return "index";
    }

    @ResponseBody
    @GetMapping("list.json")
    public List<Subdomain> find(String keyword) {
        //TODO:
        return null;
    }

    @ResponseBody
    @GetMapping("delete.json")
    public void delete(String id) {
        return;
    }

    @ResponseBody
    @GetMapping("add.json")
    public String add(Subdomain) {
        String id = "new";
        return id;
    }

    public String update(Subdomain) {
        return "";
    }
}
