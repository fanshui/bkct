package com.bkct.controller.test;

import com.bkct.model.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("restfultest")
public class RestfulTestController {

    @RequestMapping(value = "/restfultest/{name}",method = RequestMethod.GET)
    @ResponseBody
    public String resttest2(@PathVariable("name") String name) {

        return name;
    }

}
