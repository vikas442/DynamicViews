package com.android.dynamicviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.android.dynamicviews.util.DynamicLayoutHelper;
import com.android.dynamicviews.widget.CustomInputBox;
import com.android.dynamicviews.widget.IRemoveViewListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private int itemCount = 0;

    @BindView(R.id.container)
    LinearLayout mContainer;

    @BindView(R.id.btnAddTextBox)
    View mAddItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAddTextBox)
    public void addItem(View view) {
        if (itemCount < 10) {
            CustomInputBox box = DynamicLayoutHelper.addInputBoxToContainer(this, mContainer, mRemoveViewListener);
            box.requestFocus();
            itemCount++;
            handleAddItemViewVisibility();
        }
    }

    private IRemoveViewListener mRemoveViewListener = new IRemoveViewListener() {
        @Override
        public void onRemoveView(CustomInputBox view) {
            mContainer.removeView(view);
            itemCount--;
            handleAddItemViewVisibility();
            handleFocus();
        }
    };

    private void handleFocus() {
        if (itemCount>0){
            View view=mContainer.getChildAt(itemCount-1);
            if (view!=null && view instanceof CustomInputBox){
                view.requestFocus();
            }
        }
    }

    private void handleAddItemViewVisibility() {
        mAddItemView.setVisibility(itemCount < 10 ? View.VISIBLE : View.GONE);
    }
}
