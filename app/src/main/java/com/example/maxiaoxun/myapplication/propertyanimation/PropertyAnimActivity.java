package com.example.maxiaoxun.myapplication.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.maxiaoxun.myapplication.R;

/**
 * Created by maxiaoxun on 16/10/11 17:06.
 * email maxiaoxun@meituan.com
 */

public class PropertyAnimActivity extends Activity {

    private ImageView mBlueBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim);

        mBlueBall = (ImageView) findViewById(R.id.blue_ball);
    }

    //简单的多动画Together
    public void runTogether(View view){
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX", 1.0f, 2.0f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY", 1.0f, 2.0f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000);
        animatorSet.setInterpolator(new LinearInterpolator());

        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.start();
    }
    //多动画按次序执行
    public void runOneAfterAnother(View view){
        float x = mBlueBall.getX();
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX", 1.0f, 2.0f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY", 1.0f, 2.0f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mBlueBall,"X", x, mBlueBall.getWidth()/4);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(mBlueBall,"X", x);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000);
        //设置加速度模式运行
        animatorSet.setInterpolator(new AccelerateInterpolator());

        animatorSet.play(objectAnimator1).with(objectAnimator2);
        animatorSet.play(objectAnimator2).with(objectAnimator3);
        animatorSet.play(objectAnimator4).after(objectAnimator3);



        animatorSet.start();


    }
}
