package com.bjsxt.height.future;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-03-14 11:07
 */
public class FutureData implements Data {


    private RealData realData;
    private boolean isReady = false;



    @Override
    public String getRequest() {
        return null;
    }
}
