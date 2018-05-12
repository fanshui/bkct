package com.bkct.controller.real;

import com.bkct.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/numberonline")
public class NumberOnLineController {

    @RequestMapping(value = "/numberonline")
    @ResponseBody
    public String getNumberOfPeopleOnLine(HttpServletRequest hsq) {
        ServletContext context = hsq.getServletContext();
        return "{ countNumberOnline:"+ context.getAttribute("countNumberOnline") + "}";
    }

    @RequestMapping(value = "/usersonline")
    @ResponseBody
    public ArrayList getUsersOnLine(HttpServletRequest hsq) {
        ArrayList<User> arrayList = (ArrayList<User>) hsq.getServletContext().getAttribute("userList");
        return arrayList;
    }
}
