package com.bkct.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request.getRequestURI().indexOflogin" + request.getRequestURI().indexOf("/login"));
        System.out.println(request.getRequestURI());
        System.out.println(request.getSession().getAttribute("username"));
        Logger log = Logger.getLogger(LoginInterceptor.class);
        log.info(request.getMethod());

        if (request.getRequestURI().indexOf("/login") >= 0 ) {
            return true;
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
