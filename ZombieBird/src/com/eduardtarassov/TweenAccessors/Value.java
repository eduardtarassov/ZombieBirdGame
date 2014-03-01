package com.eduardtarassov.TweenAccessors;

/**
 * This class will just be a wrapper class for one float. We create this because only Objects can be tweened (primitives cannot).
 * So, to tween a float, we must create a class for it.
 * Created by Eduard on 3/1/14.
 */
public class Value {
    private float val = 1;

    public float getValue() {
        return val;
    }

    public void setValue(float newVal) {
        val = newVal;
    }
}
