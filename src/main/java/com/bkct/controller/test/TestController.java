package com.bkct.controller.test;

import com.bkct.model.request.TestParam;
import com.bkct.model.response.Response;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("test")
public class TestController {

    //返回页面
    @RequestMapping(value = "/ah", method = {RequestMethod.GET})
    public String test() {
        Logger log = Logger.getLogger(this.getClass());
        log.info("access ah.html by servlrtdispatcher");
        return "ah";
    }

    @RequestMapping("/aj")
    public String test2() {
        return "aj";
    }


    /**
     * @param testParam
     * @return
     */
    @RequestMapping(value = "/resttest", method = RequestMethod.POST)
    @ResponseBody
    public Response resttest1(TestParam testParam) {
        return new Response().success(testParam);
    }

    //get 返回json
    @RequestMapping(value = "/resttest/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response resttest2(@PathVariable("id") String id) {
        Map map = new HashMap<String, String>();
        map.put("id", id);
        map.put("niubi", id + "NIUBI!");
        return new Response().success(map);

    }

}
