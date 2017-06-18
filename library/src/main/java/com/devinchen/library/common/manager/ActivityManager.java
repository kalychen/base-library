package com.devinchen.library.common.manager;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.manager
 * Created by Devin Chen on 2017/6/8 22:41.
 * explain:
 */

public class ActivityManager extends BaseManager {
    private static ActivityManager mInstance;
    private List<Activity> activities;

    public static ActivityManager getmInstance() {
        if (mInstance == null) {
            mInstance = new ActivityManager();
        }
        return mInstance;
    }

    public void add(Activity activity) {
        if (activities == null) {
            activities = new ArrayList<>();
        }
        activities.add(activity);
    }

    public void remove(Activity activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
        }
    }

    public void removeAll() {
        activities.clear();
    }

    public void close(Activity activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
            activity.finish();
        }
    }

    public void closeAll() {
        for (Activity activity : activities) {
            activity.finish();
        }
        activities.clear();
        activities = null;
    }
}
