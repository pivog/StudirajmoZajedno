package com.example.studirajmozajednojava;

import android.text.InputFilter;
import android.text.Spanned;

public class numberInputMinMax implements InputFilter {

    private final float min, max;

    public numberInputMinMax(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public numberInputMinMax(String min, String max) {
        this.min = Float.parseFloat(min);
        this.max = Float.parseFloat(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            float input = Float.parseFloat(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) { }
        return "";
    }

    private boolean isInRange(float a, float b, float c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}