package com.bkct.util;

import com.bkct.entity.User;

import java.util.ArrayList;

public class SessionUtil {

    public static User getUserBySessionId(ArrayList<User> userList, String sessionIdString) {

        for (User user : userList) {
            if (user.getSessionId().equals(sessionIdString)) {
                return user;
            }
        }

        return null;

    }

}
