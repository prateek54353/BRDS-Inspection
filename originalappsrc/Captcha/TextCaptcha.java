package bih.p003in.forestdept.Captcha;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.core.view.ViewCompat;
import java.io.CharArrayWriter;
import java.security.SecureRandom;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TextCaptcha extends Captcha {
    private char mCh;
    protected TextOptions options;
    private int wordLength;

    public enum TextOptions {
        UPPERCASE_ONLY,
        LOWERCASE_ONLY,
        NUMBERS_ONLY,
        NUMBERS_AND_LETTERS
    }

    public TextCaptcha(int wordLength, TextOptions opt) {
        new TextCaptcha(0, 0, wordLength, opt);
    }

    public TextCaptcha(int width, int height, int wordLength, TextOptions opt) {
        setHeight(height);
        setWidth(width);
        this.options = opt;
        usedColors = new ArrayList();
        this.wordLength = wordLength;
        this.image = image();
    }

    @Override // bih.p003in.forestdept.Captcha.Captcha
    protected Bitmap image() {
        char ch;
        LinearGradient gradient = new LinearGradient(0.0f, 0.0f, getWidth() / this.wordLength, getHeight() / 2, color(), color(), Shader.TileMode.MIRROR);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setShader(gradient);
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        c.drawRect(0.0f, 0.0f, getWidth(), getHeight(), paint);
        Paint tp = new Paint();
        tp.setDither(true);
        tp.setTextSize(((getWidth() / getHeight()) * 20) - 10);
        SecureRandom r = new SecureRandom();
        CharArrayWriter cab = new CharArrayWriter();
        this.answer = "";
        for (int i = 0; i < this.wordLength; i++) {
            switch (C05951.$SwitchMap$bih$in$forestdept$Captcha$TextCaptcha$TextOptions[this.options.ordinal()]) {
                case 1:
                    ch = (char) (r.nextInt(26) + 65);
                    break;
                case 2:
                    ch = (char) (r.nextInt(26) + 97);
                    break;
                case 3:
                    ch = (char) (r.nextInt(9) + 49);
                    break;
                case 4:
                    SecureRandom randomBool = new SecureRandom();
                    if (randomBool.nextBoolean()) {
                        ch = (char) (r.nextInt(9) + 49);
                        break;
                    } else if (randomBool.nextBoolean()) {
                        ch = (char) (r.nextInt(26) + 65);
                        break;
                    } else if (randomBool.nextBoolean()) {
                        ch = (char) (r.nextInt(26) + 97);
                        break;
                    } else if (randomBool.nextBoolean()) {
                        ch = '@';
                        break;
                    } else if (randomBool.nextBoolean()) {
                        ch = '#';
                        break;
                    } else {
                        ch = '*';
                        break;
                    }
                default:
                    ch = (char) (r.nextInt(9) + 49);
                    break;
            }
            cab.append(ch);
            this.answer += ch;
        }
        Canvas cc = new Canvas(bitmap);
        tp.setColor(colorText());
        tp.setTextSkewX(r.nextFloat() - r.nextFloat());
        tp.setShadowLayer(0.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        cc.drawText(cab.toString(), (Math.abs(r.nextInt()) % 50) + 50, (Math.abs(r.nextInt()) % 50) + 50, tp);
        return bitmap;
    }

    /* renamed from: bih.in.forestdept.Captcha.TextCaptcha$1 */
    static /* synthetic */ class C05951 {
        static final /* synthetic */ int[] $SwitchMap$bih$in$forestdept$Captcha$TextCaptcha$TextOptions;

        static {
            int[] iArr = new int[TextOptions.values().length];
            $SwitchMap$bih$in$forestdept$Captcha$TextCaptcha$TextOptions = iArr;
            try {
                iArr[TextOptions.UPPERCASE_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$bih$in$forestdept$Captcha$TextCaptcha$TextOptions[TextOptions.LOWERCASE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$bih$in$forestdept$Captcha$TextCaptcha$TextOptions[TextOptions.NUMBERS_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$bih$in$forestdept$Captcha$TextCaptcha$TextOptions[TextOptions.NUMBERS_AND_LETTERS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private void getLettersNumbers(SecureRandom r) {
        int rint = r.nextInt(74) + 49;
        if (rint > 90 && rint < 97) {
            getLettersNumbers(r);
        } else if (rint > 57 && rint < 65) {
            getLettersNumbers(r);
        } else {
            this.mCh = (char) rint;
        }
    }
}