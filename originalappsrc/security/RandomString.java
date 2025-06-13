package bih.p003in.forestdept.security;

import java.security.SecureRandom;

/* loaded from: classes8.dex */
public class RandomString {
    private static final String ALPHA_NUMERIC_STRING = "abcdef0123456789";

    public static String randomAlphaNumeric(int count) {
        SecureRandom secureRnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(ALPHA_NUMERIC_STRING.charAt(secureRnd.nextInt(ALPHA_NUMERIC_STRING.length())));
        }
        return sb.toString();
    }
}