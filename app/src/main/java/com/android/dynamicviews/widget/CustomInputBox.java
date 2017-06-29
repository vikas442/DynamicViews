package com.android.dynamicviews.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.dynamicviews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dHulk on 29/06/17.
 */

public class CustomInputBox extends RelativeLayout {

    @BindView(R.id.tilInputBox)
    TextInputLayout mTILInputBox;

    @BindView(R.id.etInputBox)
    TextInputEditText mETInputBox;

    private IRemoveViewListener mRemoveViewListener;

    public CustomInputBox(Context context) {
        super(context);
        init();
    }

    public CustomInputBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomInputBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomInputBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        View rootView = inflate(getContext(), R.layout.layout_custom_data, this);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        ButterKnife.bind(this, rootView);
    }

    /**
     * set callback for close button
     * @param removeViewListener callback
     */
    public void setRemoveViewListener(@NonNull IRemoveViewListener removeViewListener) {
        mRemoveViewListener = removeViewListener;
    }

    @OnClick(R.id.ibRemove)
    public void onRemove(View view) {
        if (mRemoveViewListener != null) {
            mRemoveViewListener.onRemoveView(this);
        }
    }

    /**
     * To get text entered by user
     * @return text string
     */
    public String getText() {
        return mETInputBox.getText().toString();
    }

    /**
     * set hint for user
     * @param resId string resource id
     */
    public void setHint(@StringRes int resId){
        mETInputBox.setHint(resId);
    }

    /**
     * set hint for user
     * @param hint string
     */
    public void setHint(@NonNull String hint){
        mETInputBox.setHint(hint);
    }
}
