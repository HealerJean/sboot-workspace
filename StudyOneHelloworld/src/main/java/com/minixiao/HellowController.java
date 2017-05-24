package com.minixiao;

import org.apache.coyote.RequestGroupInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


/**
 * Created by HealerJean on 2017/3/19.
 */
@RestController //这个类要是想通过web的方式访问就要加一个 注解 @RestController
public class HellowController {
    //请求的方式的GET
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String say(){
        HttpRequest request = new HttpRequest() {
            @Override
            public HttpMethod getMethod() {
                return null;
            }

            @Override
            public URI getURI() {
                return null;
            }

            @Override
            public HttpHeaders getHeaders() {
                return null;
            }
        };
        request.getURI();
        System.out.print(request.getURI()+"****");
        return "hello spring boot";

    }
}
