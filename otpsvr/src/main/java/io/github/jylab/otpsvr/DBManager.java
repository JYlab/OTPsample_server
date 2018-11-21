package io.github.jylab.otpsvr;

import java.util.HashMap;


import static io.github.jylab.otpsvr.util.SampleInfo.getSampleInfo;

public class DBManager {

    public void connDB(){

    }

    public boolean userCheck(String UniqInfo){
        if(UniqInfo.equals("520c0503015b540f5453010350065056"))
            return true;

        return false;

    }

    public HashMap<String,String > getUserInfo(String UniqInfo){

        HashMap<String,String > SampleInfo=null;
        SampleInfo= getSampleInfo();
        if(SampleInfo==null)
            return null;


        return SampleInfo;

    }

    // when you insert new user
    public void insertUserData(){

    }

}
