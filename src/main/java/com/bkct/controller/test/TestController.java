package com.bkct.controller.test;

import com.alibaba.fastjson.JSON;
import com.bkct.entity.Chariman;
import com.bkct.service.TestService;
import com.bkct.util.CheckEncode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    private final Chariman chariman;

    @Autowired
    private TestService testService;

    @Autowired
    public TestController(Chariman chariman) {
        this.chariman = chariman;
    }

    @ResponseBody
    @RequestMapping(value = "testlogback")
    public Chariman logbacktest() {
        logger.info(JSON.toJSONString(chariman));
        CheckEncode.getEncoding(chariman.getName());
        return chariman;
    }

    @RequestMapping(value = "sum")
    @ResponseBody
    public String sumTwoInt(@RequestParam(defaultValue = "5") String first,
                            @RequestParam(defaultValue = "8") String second) {
        return Integer.toString(testService.sum(Integer.parseInt(first), Integer.parseInt(second)));
    }

    @RequestMapping(value = {"test2"})
    public String test2(){
        return null;
    }

    @RequestMapping()
    public String index(){
        return "index";
    }

}