package com.eduardtarassov.TweenAccessors;

import aurelienribon.tweenengine.TweenAccessor;

/**
 * The ValueAccessor class will help us tween the val variable in the Value class.
 * Created by Eduard on 3/1/14.
 */
public class ValueAccessor implements TweenAccessor<Value> {

    @Override
    public int getValues(Value target, int tweenType, float[] returnValues) {
        returnValues[0] = target.getValue();
        return 1;
    }

    @Override
    public void setValues(Value target, int tweenType, float[] newValues) {
        target.setValue(newValues[0]);
    }

}
