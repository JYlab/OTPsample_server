package io.github.jylab.otpsvr;


public class OTP  {

    private static OTPApi otpApi;

    private static byte [] otp;


    private static void setOtpAPI(APISelector.OTP_API level) throws Exception {
        otpApi=APISelector.getOTPApi(APISelector.OTP_API.LEVEL1);
    }


    public static void init(int API_LEVEL){
        try {
            if (API_LEVEL == 1) {
                setOtpAPI(APISelector.OTP_API.LEVEL1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void setUniqInfo(String encData){
        byte [] recvData=null;
        try {
            otpApi.setUniqInfo(encData);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static byte[] generateOTP(){
        try{
            otp = otpApi.generateOTP();
        }catch (Exception e){
            e.printStackTrace();
        }

        return otp;
    }

}
