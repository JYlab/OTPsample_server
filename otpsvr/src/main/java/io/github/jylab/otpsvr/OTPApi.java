package io.github.jylab.otpsvr;

public interface OTPApi {
    void setUniqInfo(String encData);
    byte[] generateOTP();

}
