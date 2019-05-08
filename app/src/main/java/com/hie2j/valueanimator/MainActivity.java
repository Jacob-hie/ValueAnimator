package com.hie2j.valueanimator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btn_attrAnimator;

    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_test = findViewById(R.id.btn_test);
        btn_attrAnimator = findViewById(R.id.btn_attrAnimator);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point start = new Point(100,100);
                Point end = new Point(400,600);
                ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(),start,end);
                valueAnimator.setDuration(6000);
                valueAnimator.setRepeatCount(3);
                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Point point = (Point) animation.getAnimatedValue();
                        Log.e(TAG,"x = " + point.getX() + " y = " + point.getY());
                        btn_test.setTranslationX(point.getX());
                        btn_test.setTranslationY(point.getY());
                        btn_test.requestLayout();
                    }
                });
                valueAnimator.start();
            }
        });
        btn_attrAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startPropertyWithJava();
                startPropertyWithXML();
            }
        });

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        MainActivity.this,R.animator.translation);
                objectAnimator.setTarget(btn_test);
                objectAnimator.start();

//                float currentX = btn_test.getTranslationX();
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
//                        btn_test,"translationX",currentX,300);
//                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float value = (float) animation.getAnimatedValue();
//                        btn_test.setTranslationY(value);
//                    }
//                });
//                objectAnimator.setDuration(3000);
//                objectAnimator.setRepeatCount(4);
//                objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//                objectAnimator.start();
            }
        });
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        MainActivity.this,R.animator.scale);
                objectAnimator.setTarget(btn_test);
                objectAnimator.start();

//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
//                        btn_test,"scaleX",1,4);
//                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float value = (float) animation.getAnimatedValue();
//                        btn_test.setTranslationY(value);
//                    }
//                });
//                objectAnimator.setDuration(3000);
//                objectAnimator.setRepeatCount(4);
//                objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//                objectAnimator.start();
            }
        });
        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        MainActivity.this,R.animator.alpha);
                objectAnimator.setTarget(btn_test);
                objectAnimator.start();

//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
//                        btn_test,"alpha",1.0f,0.2f);
//                objectAnimator.setDuration(3000);
//                objectAnimator.setRepeatCount(4);
//                objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//                objectAnimator.start();
            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        MainActivity.this,R.animator.rotate);
                objectAnimator.setTarget(btn_test);
                objectAnimator.start();

//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
//                        btn_test,"rotation",0,360);
//                objectAnimator.setDuration(3000);
//                objectAnimator.setRepeatCount(4);
//                objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//                objectAnimator.start();
            }
        });
        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                float currentX = btn_test.getTranslationX();
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(
                        btn_test,"rotation",0,360);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(
                        btn_test,"alpha",1.0f,0.2f);
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(
                        btn_test,"translationX",currentX,300);
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(
                        btn_test,"scaleX",1,4);
                animatorSet.play(objectAnimator1).with(objectAnimator2).before(objectAnimator3);
                animatorSet.setDuration(4000);
                animatorSet.start();

//                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,
//                        R.animator.anim_set);
//                animatorSet.setDuration(4000);
//                animatorSet.setTarget(btn_test);
//                animatorSet.start();
            }
        });
    }

    private void startPropertyWithXML() {
        final ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(
                this,R.animator.set_animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) valueAnimator.getAnimatedValue();
                Log.e(TAG,"value = " + value);
                btn_attrAnimator.getLayoutParams().width = value;
                btn_attrAnimator.getLayoutParams().height = value;
                btn_attrAnimator.setText("属性动画"+value);
                btn_attrAnimator.setBackgroundColor(Color.argb(255,value/2,0,0));
                btn_attrAnimator.requestLayout();
            }
        });
        valueAnimator.start();
    }

    private void startPropertyWithJava() {
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(btn_attrAnimator.getLayoutParams().width,600);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) valueAnimator.getAnimatedValue();
                Log.e(TAG,"value = " + value);
                btn_attrAnimator.getLayoutParams().width = value;
                btn_attrAnimator.requestLayout();
            }
        });
        valueAnimator.setRepeatCount(5);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }
}
