package com.shuowang.iotsim.balancer;

import com.shuowang.iotsim.sendreceive.CallBackofBalancer;
import com.shuowang.iotsim.sendreceive.PublishToBroker;

public class LoadUpdate {

    String BACK;

    public String getBACK() {
        return BACK;
    }

    public int run(String client, String node) {
        int count = 0;
        String cpuusage = "";
        String memusage = "";
        CallBackofBalancer cb = new CallBackofBalancer();
        PublishToBroker publish = new PublishToBroker(client, cb);
        publish.subTopic("load"+node); //e.g. loadcscloud1n2
        BACK = cb.getBackMsg();
//        for(int i = 0; i < BACK.length(); i++){
//            if(BACK.charAt(i) != ' '){
//                if(count == 1){
//                    cpuusage = cpuusage + BACK.charAt(i);
//                }
//                if(count == 3){
//                    memusage = memusage + BACK.charAt(i);
//                }
//            }
//            else count++;
//        }
//        return (int) (Integer.parseInt(cpuusage) * 0.5 + Integer.parseInt(memusage) * 0.5);
        return 0;
    }
}
