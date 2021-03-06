package com.littlejie.password.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.littlejie.password.AESUtil;

/**
 * Copyright (c) 2017, Bongmi
 * All rights reserved
 * Author: littlejie@bongmi.com
 */

public class PasswordStorage {

    private static final String PASSWORD = "pwd";
    private static final String PASSWORD_KEY = "abc_pwd";

    public static void save(Context context, String password) {
        SharedPreferences preferences =
                context.getSharedPreferences(getPrefsName(context), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        //加密
        try {
            editor.putString(PASSWORD_KEY, AESUtil.encrypt(context.getPackageName(), password));
        } catch (Exception e) {
            e.printStackTrace();
            editor.putString(PASSWORD_KEY, password);
        }
        editor.apply();
    }

    public static String get(Context context) {
        return context.getSharedPreferences(getPrefsName(context), Context.MODE_PRIVATE)
                .getString(PASSWORD_KEY, null);
    }

    public static String encryptPassword(Context context, String password) {
        try {
            return AESUtil.encrypt(context.getPackageName(), password);
        } catch (Exception e) {
            return password;
        }
    }

    public static void clear(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(getPrefsName(context), Context.MODE_PRIVATE);
        prefs.edit().clear().apply();
    }

    private static String getPrefsName(Context context) {
        return context.getPackageName() + "_" + PASSWORD;
    }
}
