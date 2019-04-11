package com.inuker.bluetooth.library.utils;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by dingjikerbo on 2015/12/16.
 */
public class BluetoothLog {

    private static final String LOG_TAG = "miio-bluetooth";
    private static boolean showLog = false;
    public static void setShowLog(boolean show){
        showLog = show;
    }

    public static void i(String msg) {
        if(showLog){
            Log.i(LOG_TAG, msg);
        }
    }

    public static void e(String msg) {
        Log.e(LOG_TAG, msg);
    }
    public static void e(String msg,Throwable e) {
        Log.e(LOG_TAG, msg,e);
    }

    public static void v(String msg) {
        if(showLog){
            Log.v(LOG_TAG, msg);
        }
    }

    public static void d(String msg) {
        if(showLog){
            Log.d(LOG_TAG, msg);
        }
    }

    public static void w(String msg) {
        if(showLog){
            Log.w(LOG_TAG, msg);
        }
    }
    public static void w(String msg,Throwable e) {
        if(showLog){
            Log.w(LOG_TAG, msg,e);
        }
    }

    public static void e(Throwable e) {
        e(getThrowableString(e));
    }

    public static void w(Throwable e) {
        w(getThrowableString(e));
    }

    private static String getThrowableString(Throwable e) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);

        while (e != null) {
            e.printStackTrace(printWriter);
            e = e.getCause();
        }

        String text = writer.toString();

        printWriter.close();

        return text;
    }
}
