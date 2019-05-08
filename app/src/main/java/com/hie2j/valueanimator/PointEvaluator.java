package com.hie2j.valueanimator;

import android.animation.TypeEvaluator;

public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {

        int x = (int) (startValue.getX() + fraction*(endValue.getX() - startValue.getX()));
        int y = (int) (startValue.getY() + fraction*(endValue.getY() - startValue.getY()));

        return new Point(x,y);
    }
}
