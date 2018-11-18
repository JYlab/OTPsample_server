package io.github.jylab.otpsvr;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

import io.github.jylab.otpsvr.util.Base64Coder;

public class APISelector  {
    public  enum OTP_API{
        LEVEL1, LEVEL2
    }

    public static OTPApi getOTPApi(OTP_API LEVEl) {
        if(LEVEl == OTP_API.LEVEL1) return new OTPApiLevel1();
        //else if(LEVEl == OTP_API.LEVEL2) return new OTPApiLevel2();


        return null;
    }

    public static class OTPApiLevel1 implements OTPApi {
        private static HashMap<String, String> UserInfo = new HashMap<String, String>();

        private static String UniqInfo = "";
        private static byte[] recvData;
        private static byte[] otp = null;


        public void getUniqInfo(String encData) {
            recvData = Base64Coder.decode(encData);
        }

        public byte[] generateOTP() {
            DBManager dbManager = new DBManager();
            try {
                dbManager.connDB();
            } catch (Exception e) {
                e.printStackTrace();
            }

            UniqInfo = new String(recvData);

            if (dbManager.userCheck(UniqInfo)) {

                try {
                    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    secureRandom.setSeed(secureRandom.generateSeed(128));
                    otp = digest.digest((secureRandom.nextLong() + "").getBytes());

                } catch (NoSuchAlgorithmException e) {
                    System.out.print("Fail to generate OTP");
                    e.printStackTrace();

                }

            } else {
                System.out.print("Can't find the user");
            }

            return otp;

        }


    }
}
