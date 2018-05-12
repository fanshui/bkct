package com.bkct.controller.real;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        System.out.println("login");
        return "login";
    }

    @RequestMapping("/loginsubmit")
    public String submit(String username, String pwd, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (username != null) {
            session.setAttribute("username",username);
            System.out.println(session.getAttribute("username"));

            return "redirect:/test/ah";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }


}
