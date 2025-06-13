package bih.p003in.forestdept.Captcha;

import android.graphics.Bitmap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.card.MaterialCardViewHelper;
import java.security.SecureRandom;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Captcha {
    protected static List<Integer> usedColors;
    private int height;
    protected Bitmap image;
    private int width;
    protected String answer = "";

    /* renamed from: x */
    protected int f155x = 0;

    /* renamed from: y */
    protected int f156y = 0;

    protected abstract Bitmap image();

    public static int color() {
        int number;
        SecureRandom r = new SecureRandom();
        do {
            number = r.nextInt(4);
        } while (usedColors.contains(Integer.valueOf(number)));
        usedColors.add(Integer.valueOf(number));
        switch (number) {
            case 0:
                return ViewCompat.MEASURED_STATE_MASK;
            case 1:
                return -16776961;
            case 2:
                return -12303292;
            case 3:
                return -7829368;
            case 4:
                return -16711936;
            case 5:
                return -16711681;
            case 6:
                return SupportMenu.CATEGORY_MASK;
            case 7:
                return InputDeviceCompat.SOURCE_ANY;
            case 8:
                return -65281;
            case 9:
                return -1;
            default:
                return -3355444;
        }
    }

    public static int colorText() {
        int number;
        SecureRandom r = new SecureRandom();
        do {
            number = r.nextInt(5);
        } while (usedColors.contains(Integer.valueOf(number)));
        usedColors.add(Integer.valueOf(number));
        switch (number) {
            case 0:
                return -16711936;
            case 1:
                return -16711681;
            case 2:
                return SupportMenu.CATEGORY_MASK;
            case 3:
                return InputDeviceCompat.SOURCE_ANY;
            case 4:
                return -65281;
            default:
                return -1;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        if (width > 0 && width < 10000) {
            this.width = width;
        } else {
            this.width = MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if (height > 0 && height < 10000) {
            this.height = height;
        } else {
            this.height = 100;
        }
    }

    public Bitmap getImage() {
        return this.image;
    }

    public String getAnswer() {
        return this.answer;
    }

    public boolean checkAnswer(String ans) {
        return ans.equals(this.answer);
    }
}