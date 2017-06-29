package com.android.dynamicviews.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.android.dynamicviews.widget.CustomInputBox;
import com.android.dynamicviews.widget.IRemoveViewListener;

/**
 * Created by dHulk on 29/06/17.
 */

public class DynamicLayoutHelper {

    /**
     * add custom input box to provided container
     * @param context
     * @param container
     * @param listener
     * @return
     * to get text call CustomInputBox.getText() method
     * to set hint call CustomInputBox.setHint() method
     */
    public static CustomInputBox addInputBoxToContainer(@NonNull Context context, @NonNull ViewGroup container, @NonNull IRemoveViewListener listener) {
        CustomInputBox inputBox = new CustomInputBox(context);
        inputBox.setRemoveViewListener(listener);
        container.addView(inputBox);
        return inputBox;
    }
}
