package com.shuowang.iotsim.backend;

import com.shuowang.iotsim.devicemanager.Device;
import com.shuowang.iotsim.devicemanager.DeviceRegistry;
import com.shuowang.iotsim.utils.MyUtils;

public class ControlCenter{

    String CLIENT_ID;
    int NUMBER_OF_DEVICES;
    int FILE_SIZE;
    DeviceRegistry DR;


    public void start(int numberofdevices) throws Exception {
        NUMBER_OF_DEVICES = numberofdevices;
        DR = new DeviceRegistry();
        for (int i = 0; i < NUMBER_OF_DEVICES; i ++) {
            FILE_SIZE = MyUtils.getRandomNum(1000000, 5000000);
            Device nt = new Device("client" + i, FILE_SIZE);
            DR.register("client" + i, nt);
            Thread dev = new Thread(nt);
            dev.start();
        }
    }
}
