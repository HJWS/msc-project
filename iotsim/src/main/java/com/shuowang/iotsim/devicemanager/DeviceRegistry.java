package com.shuowang.iotsim.devicemanager;

import javafx.util.Pair;

import java.util.*;

public class DeviceRegistry {

    private String CILENT_ID;
    static List<Pair<String, Device>> DEV_LIST = new ArrayList<>();
//    public DeviceRegistry(String clientid){
//        CILENT_ID = clientid;
//    }

    public void register (String clientid,Device d){
        DEV_LIST.add(new Pair<>(clientid, d));
    }

}
