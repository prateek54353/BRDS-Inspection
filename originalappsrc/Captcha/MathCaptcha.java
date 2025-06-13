package bih.p003in.forestdept.Captcha;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import java.security.SecureRandom;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MathCaptcha extends Captcha {
    int height;
    protected MathOptions mathOptions;

    public enum MathOptions {
        PLUS_MINUS,
        PLUS_MINUS_MULTIPLY
    }

    public MathCaptcha(int width, int height, MathOptions operators) {
        this.height = height;
        setWidth(width);
        this.mathOptions = operators;
        usedColors = new ArrayList();
        this.image = image();
    }

    public static char addOperator(Integer operators) {
        switch (operators.intValue()) {
        }
        return '+';
    }

    @Override // bih.p003in.forestdept.Captcha.Captcha
    protected Bitmap image() {
        LinearGradient gradient = new LinearGradient(0.0f, 0.0f, getWidth() / 2, this.height / 2, color(), color(), Shader.TileMode.MIRROR);
        Paint p = new Paint();
        int i = 1;
        p.setDither(true);
        p.setShader(gradient);
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), this.height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        c.drawRect(0.0f, 0.0f, getWidth(), this.height, p);
        LinearGradient fontGrad = new LinearGradient(0.0f, 0.0f, getWidth() / 2, this.height / 2, colorText(), colorText(), Shader.TileMode.CLAMP);
        Paint tp = new Paint();
        tp.setDither(true);
        tp.setShader(fontGrad);
        tp.setTextSize((getWidth() / this.height) * 20);
        SecureRandom r = new SecureRandom();
        int one = r.nextInt(9) + 1;
        int two = r.nextInt(9) + 1;
        int math = r.nextInt(this.mathOptions == MathOptions.PLUS_MINUS_MULTIPLY ? 3 : 2);
        if (one < two) {
            Integer temp = Integer.valueOf(one);
            one = two;
            two = temp.intValue();
        }
        switch (math) {
            case 0:
                this.answer = (one + two) + "";
                break;
            case 1:
                this.answer = (one - two) + "";
                break;
            case 2:
                this.answer = (one * two) + "";
                break;
        }
        char[] data = {String.valueOf(one).toCharArray()[0], addOperator(Integer.valueOf(math)), String.valueOf(two).toCharArray()[0]};
        int i2 = 0;
        while (i2 < data.length) {
            this.f155x += (Math.abs(r.nextInt()) % 65) + 30;
            this.f156y = (Math.abs(r.nextInt()) % 50) + 50;
            Canvas cc = new Canvas(bitmap);
            if (i2 != i) {
                tp.setTextSkewX(r.nextFloat() - r.nextFloat());
            }
            cc.drawText(data, i2, 1, this.f155x, this.f156y, tp);
            tp.setTextSkewX(0.0f);
            i2++;
            i = 1;
        }
        return bitmap;
    }
}