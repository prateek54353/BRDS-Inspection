package bih.p003in.forestdept.security;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.language.Soundex;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/* loaded from: classes8.dex */
public class Aes256CbcEncryptDecrypt {
    public static final String HMAC_SHA256 = "HmacSHA256";

    private SecretKey getSecretKey(String key) {
        byte[] decodedKey = key.getBytes(StandardCharsets.UTF_8);
        SecretKey secretkey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return secretkey;
    }

    public String Encrypt(String plainText, String key) {
        char[] padding = {'='};
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, getSecretKey(key));
            byte[] iv = cipher.getIV();
            byte[] bufferPlainText = plainText.getBytes(StandardCharsets.UTF_8);
            String encryptedText = trimEnd(Base64.getEncoder().encodeToString(cipher.doFinal(bufferPlainText)), padding).replace('+', Soundex.SILENT_MARKER).replace('/', '_');
            String mac = BitConverterToString(HmacSHA256(Base64.getEncoder().encodeToString(iv) + encryptedText, key)).replace("-", "").replace('+', Soundex.SILENT_MARKER).replace('/', '_').toLowerCase();
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("iv", Base64.getEncoder().encodeToString(iv));
            jsonObj.put("value", encryptedText);
            jsonObj.put("mac", mac);
            jsonObj.put("ts", Instant.now().toString());
            String temp = trimEnd(Base64.getEncoder().encodeToString(jsonObj.toString().getBytes()), padding).replace('+', Soundex.SILENT_MARKER).replace('/', '_');
            System.out.println(temp);
            return temp;
        } catch (Exception e) {
            System.out.println("Error occured during encryption:" + e.toString());
            return null;
        }
    }

    public String Decrypt(String plainText, String key) {
        new char[1][0] = '=';
        try {
            String base64DecodedPlainText = new String(Base64.getMimeDecoder().decode(DecodeUrlBase64(plainText)), StandardCharsets.UTF_8);
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(base64DecodedPlainText);
            byte[] iv = Base64.getDecoder().decode((String) jsonData.get("iv"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, getSecretKey(key), new IvParameterSpec(iv));
            byte[] payload = Base64.getDecoder().decode(DecodeUrlBase64(jsonData.get("value").toString()));
            return new String(cipher.doFinal(payload), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] DecodeUrlBase64(String str) {
        String str2 = str.replace("-", "+").replace("_", "/");
        return padRight(str2, '=', ((str2.length() + 3) / 4) * 4).getBytes();
    }

    private static String padRight(String str, char ch, int length) {
        return String.format("%" + (-length) + "s", str).replace(' ', ch);
    }

    private static byte[] HmacSHA256(String data, String secretKey) {
        try {
            if (secretKey == null || data == null) {
                throw new NullPointerException();
            }
            Mac mac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), HMAC_SHA256);
            mac.init(secretKeySpec);
            byte[] dataByte = data.getBytes(StandardCharsets.UTF_8);
            return mac.doFinal(dataByte);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
    }

    private static String BitConverterToString(byte[] bytes) throws Exception {
        if (bytes == null) {
            throw new Exception("The Byte array must have a length of 1 byte");
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String trimEnd(String value, char[] padding) {
        int len = value.length();
        while (0 < len && value.charAt(len - 1) == padding[0]) {
            len--;
        }
        return value.substring(0, len);
    }
}