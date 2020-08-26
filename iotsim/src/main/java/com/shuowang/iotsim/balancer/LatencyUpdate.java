package com.shuowang.iotsim.balancer;

import com.shuowang.iotsim.utils.Latency;

public class LatencyUpdate{

    int latency;


    public int getLatency() {
        return latency;
    }


    public int run(String addr) {
        return latency = Latency.getLatency(addr);
    }
}
