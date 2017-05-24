package com.studybook.DateJsonFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

/**
 * Created by HealerJean on 2017/4/18.
 */
@Controller
public class JsonFormatDateController {

    @Autowired
    JsonFormatDateRepository jsonFormatDateRepository;

    @GetMapping("/jsonFormatDate.html")
    public String jsonFormatDate(){
        return "jsonformatdate";
    }

    @PostMapping("/addJsonFormatDate")
    public String addJsonFormatDate(JsonFormatTestDomain jsonFormatTestDomain,String jsonFormatDate){
        jsonFormatTestDomain.setJsonFormatDate(LocalDateTime.parse(jsonFormatDate));
        jsonFormatDateRepository.save(jsonFormatTestDomain);
        return "jsonformatdate";
    }
}
