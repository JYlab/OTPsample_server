package io.github.jylab.otpsvr.util;

import java.util.HashMap;

// Have to change with DB conn
public class SampleInfo {

    private static String sampleID="jylee";
    private static String samplePW="1q2w3e4r!";
    private static String sampleUUID="8dc53df5-703e-49b3-f670-b1c468f47f10";
    private static HashMap<String,String> sampleInfo = new HashMap<String, String>();


    public static String getSampleID(){
        return sampleID;
    }

    public static String getSamplePW(){
        return samplePW;

    }
    public static String getSampleUUID(){
        return sampleUUID;

    }

    public static HashMap<String,String> getSampleInfo(){
        sampleInfo.put(sampleID,samplePW);

        return sampleInfo;

    }


}