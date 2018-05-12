package com.bkct.listener;

import com.bkct.entity.User;
import com.bkct.util.SessionUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.HashSet;

@WebListener
public class NumOnLineHttpSessionListener implements HttpSessionListener {

    private int countNumberOnline = 0;
    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();

        countNumberOnline++;
        context.setAttribute("countNumberOnline",countNumberOnline);


    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        ServletContext context = se.getSession().getServletContext();

        countNumberOnline--;
        context.setAttribute("countNumberOnline",countNumberOnline);

        ArrayList<User> userList = null;
        userList = (ArrayList<User>) se.getSession().getServletContext().getAttribute("userList");
        if (SessionUtil.getUserBySessionId(userList,se.getSession().getId()) != null) {
            userList.remove(SessionUtil.getUserBySessionId(userList,se.getSession().getId()));
        }


    }


}
