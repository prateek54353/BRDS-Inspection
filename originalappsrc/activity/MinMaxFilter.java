package bih.p003in.forestdept.activity;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes4.dex */
public class MinMaxFilter implements InputFilter {
    private final int mIntMax;
    private final int mIntMin;

    public MinMaxFilter(int minValue, int maxValue) {
        this.mIntMin = minValue;
        this.mIntMax = maxValue;
    }

    public MinMaxFilter(String minValue, String maxValue) {
        this.mIntMin = Integer.parseInt(minValue);
        this.mIntMax = Integer.parseInt(maxValue);
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(this.mIntMin, this.mIntMax, input)) {
                return null;
            }
            return "";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean isInRange(int a, int b, int c) {
        if (b > a) {
            if (c >= a && c <= b) {
                return true;
            }
        } else if (c >= b && c <= a) {
            return true;
        }
        return false;
    }
}