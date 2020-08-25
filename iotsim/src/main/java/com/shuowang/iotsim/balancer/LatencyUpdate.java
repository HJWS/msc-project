package com.shuowang.iotsim.balancer;

import com.shuowang.iotsim.utils.Latency;

public class LatencyUpdate{
//    String addr;
    int latency;
//    public LatencyUpdate(String ip){
//        addr = ip;
//    }

    public int getLatency() {
        return latency;
    }


    public int run(String addr) {
        return latency = Latency.getLatency(addr);
    }
}
