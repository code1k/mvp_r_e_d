package com.zb.mvprrd.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.util.LinkedList;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 */
public class AppManager {

    private static LinkedList<Activity> activityStack;
    private static AppManager instance;
    private static final Object LOCK = new Object();
    public static InputMethodManager IMM;
    public static int screenH, screenW;
    public static WindowManager wm;


    private AppManager() {
    }

    /**
     * 单一实例
     */
    public static AppManager I() {
        synchronized (LOCK) {
            if (instance == null) {
                instance = new AppManager();
            }
            return instance;
        }
    }

    private Application mContext;

    public synchronized void init(Application context) {

        synchronized (LOCK) {
            mContext = context;
            IMM = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics metric = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(metric);
            screenH = metric.heightPixels;
            screenW = metric.widthPixels;
        }
    }

    public Application getApplicationContext() {
        synchronized (LOCK) {
            return mContext;
        }
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        synchronized (LOCK) {
            if (activityStack == null) {
                activityStack = new LinkedList<Activity>();
            }
            activityStack.add(activity);
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        synchronized (LOCK) {
            try {
                Activity activity = activityStack.getLast();
                return activity;
            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }
        }
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        synchronized (LOCK) {
            Activity activity = activityStack.getLast();
            finishActivity(activity);
        }
    }

    public void removeActivity(Activity activity) {
        synchronized (LOCK) {
            if (activityStack != null && activity != null) {
                activityStack.remove(activity);
            }
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        synchronized (LOCK) {
            if (activity != null) {
                removeActivity(activity);
                if (!activity.isFinishing()) {
                    activity.finish();
                }
                activity = null;
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        synchronized (LOCK) {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    finishActivity(activity);
                }
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        synchronized (LOCK) {
            for (int i = 0, size = activityStack.size(); i < size; i++) {
                if (null != activityStack.get(i)) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishOthersActivity(Activity activity) {
        synchronized (LOCK) {
            for (int i = 0, size = activityStack.size(); i < size; i++) {
                if (null != activityStack.get(i) && !activityStack.get(i).getClass().getName().equals(activity
                        .getClass()
                        .getName())) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
            addActivity(activity);
        }
    }


    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        synchronized (LOCK) {
            try {
                finishAllActivity();
                ActivityManager activityMgr = (ActivityManager) context
                        .getSystemService(Context.ACTIVITY_SERVICE);
                activityMgr.restartPackage(context.getPackageName());
                System.exit(0);
            } catch (Exception e) {
            }
        }
    }

    public int ActivityStackSize() {
        synchronized (LOCK) {
            return activityStack == null ? 0 : activityStack.size();
        }
    }
}