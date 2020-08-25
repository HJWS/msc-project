package com.shuowang.iotsim;

import com.shuowang.iotsim.backend.ControlCenter;
import com.shuowang.iotsim.balancer.LoadBalancer;
import com.shuowang.iotsim.utils.MyUtils;

public class Balancertest {
    public static void main(String[] args) throws Exception {
        String node;
        //LoadBalancer balancer = new LoadBalancer(MyUtils.getRandomNum(-50, 50), MyUtils.getRandomNum(-50, 50));
        //node = balancer.getBestNode();
        //System.out.println(node);
        ControlCenter cc = new ControlCenter();
        cc.start(1);
    }
}
