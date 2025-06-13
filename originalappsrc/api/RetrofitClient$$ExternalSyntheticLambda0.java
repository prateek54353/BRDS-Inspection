package bih.p003in.forestdept.api;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class RetrofitClient$$ExternalSyntheticLambda0 implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return RetrofitClient.lambda$getClient$0(str, sSLSession);
    }
}