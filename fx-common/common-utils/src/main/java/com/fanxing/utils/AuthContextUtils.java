package com.fanxing.utils;

import com.fanxing.model.entity.user.User;

public class AuthContextUtils {
    private static final ThreadLocal<User> userThreadLocal = new ThreadLocal<>() ;

    public static void setUser(User user){userThreadLocal.set(user);}

    public static User getUser(){return userThreadLocal.get();}

    public static void removeUser(){userThreadLocal.remove();}
}
