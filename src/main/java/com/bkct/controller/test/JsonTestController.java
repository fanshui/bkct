package com.bkct.controller.test;

import com.bkct.model.request.JsonRequest;
import com.bkct.model.response.Response;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("/jsontest")
public class JsonTestController {

    @RequestMapping(value = "/jsontest1",method = RequestMethod.POST)
    @ResponseBody
    public String stringreturn(@RequestBody  JsonRequest jsonRequest) {
        Logger logger = Logger.getLogger(JsonTestController.class);
        logger.info("request param is : " + jsonRequest);
        return "who are you?";
    }

    @RequestMapping(value = "/jsontest2",method = RequestMethod.POST)
    @ResponseBody
    public Response jsonreturn(@RequestBody JsonRequest jsonRequest) {
        Logger logger = Logger.getLogger(JsonTestController.class);
        logger.info("request param is : " + jsonRequest);
        return new Response<>().success(jsonRequest);
    }

}
