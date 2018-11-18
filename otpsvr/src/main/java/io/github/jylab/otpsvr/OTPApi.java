package io.github.jylab.otpsvr;

public interface OTPApi {
    void getUniqInfo(String encData);
    byte[] generateOTP();

}
