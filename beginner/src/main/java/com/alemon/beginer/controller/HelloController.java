package com.alemon.beginer.controller;

import com.alemon.beginer.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuw
 * enqiang on 16/3/16.
 */
@Controller
@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/hello")
    public Result hello(HttpServletRequest request) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        return result;
    }
}
