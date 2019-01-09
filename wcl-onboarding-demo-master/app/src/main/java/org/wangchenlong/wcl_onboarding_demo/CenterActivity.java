package org.wangchenlong.wcl_onboarding_demo;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 居中位置移动的启动动画
 * 三种动画方式: 移动\渐变\缩放.
 * <p>
 * Created by wangchenlong on 16/2/28.
 */
public class CenterActivity extends AppCompatActivity {
    public static final int STARTUP_DELAY = 300; // 启动延迟
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;

    @Bind(R.id.onboard_ll_container)
    LinearLayout mLlContainer;
    @Bind(R.id.onboard_iv_logo)
    ImageView mIvLogo;
    @Bind(R.id.onboard_b_choice_1)
    Button mBChoice1;
    @Bind(R.id.onboard_b_choice_2)
    Button mBChoice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_center);
        ButterKnife.bind(this);

        // 向上移动
        ViewCompat.animate(mIvLogo)
                .translationY(-300)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(1.2f))
                .start();

        for (int i = 0; i < mLlContainer.getChildCount(); i++) {
            View v = mLlContainer.getChildAt(i);
            ViewPropertyAnimatorCompat viewAnimator;
            // TextView控件, Button是TextView的子类
            if (!(v instanceof Button)) {
                // 渐变动画，从消失到显示
                viewAnimator = ViewCompat.animate(v)
                        .translationY(50).alpha(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(ANIM_ITEM_DURATION);
            } else { // Button控件, 从缩小到扩大
                viewAnimator = ViewCompat.animate(v)
                        .scaleY(1).scaleX(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(ANIM_ITEM_DURATION / 2);
            }
            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();
        }

        mBChoice1.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(), "Nice!", Toast.LENGTH_SHORT).show());
        mBChoice2.setOnClickListener(v -> onBackPressed());
    }
}
