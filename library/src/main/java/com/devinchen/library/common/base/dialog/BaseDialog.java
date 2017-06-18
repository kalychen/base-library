package com.devinchen.library.common.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.base.dialog
 * Created by Devin Chen on 2017/5/15 23:12.
 * explain:
 */

public class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context,0);
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
