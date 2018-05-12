package com.bkct.listener;

import com.bkct.entity.User;
import com.bkct.util.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebListener
public class NumOnLineHttpServletRequestListener implements ServletRequestListener {

    private ArrayList<User> userList;

    public void requestDestroyed(ServletRequestEvent sre) {

    }

    public void requestInitialized(ServletRequestEvent sre) {

        userList = (ArrayList<User>) sre.getServletContext().getAttribute("userList");

        if (userList == null) {
            userList = new ArrayList<User>();
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
        String sessionIdString = httpServletRequest.getSession().getId();

        if (SessionUtil.getUserBySessionId(userList,sessionIdString) == null) {
            User user = new User();
            user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setSessionId(sessionIdString);
            user.setIpString(httpServletRequest.getRemoteAddr());

            userList.add(user);

        }
        sre.getServletContext().setAttribute("userList",userList);

    }
}
