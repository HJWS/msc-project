package com.shuowang.iotsim.balancer;



public class LoadBalancer extends Thread {

   InfoCollection info;



    public LoadBalancer(int x, int y) throws InterruptedException {

        info = new InfoCollection();
        info.calDistance(x, y);

    }

    public String getBestNode(){

        double value;
        double max = 0;
        int maxnode = 2;
        for(int i = 0; i < 5; i++){
            value = calAuthority(i + 2);
            //System.out.println("node"+i+": "+value+"\n");
            if(value > max){
                max = value;
                maxnode = i+2;
            }
        }
        switch (maxnode){
            case 2: return "cscloud1n2";
            case 3: return "cscloud1n3";
            case 4: return "cscloud1n4";
            case 5: return "cscloud1n5";
            case 6: return "cscloud1n6";
        }
        return "null";
    }

    public double calAuthority(int node){
//        System.out.println(info.dist1n2);
//        System.out.println(info.latency1n2);
//        System.out.println(info.load1n2);
        switch (node){
            case 2:return (Math.pow(info.dist1n2, -1) * 100 * 0.2 + Math.pow(info.load1n2,-1) * 300 * 0.3 + Math.pow(info.latency1n2, -1) * 300 * 0.2);
            case 3:return (Math.pow(info.dist1n3, -1) * 100 * 0.2 + Math.pow(info.load1n3,-1) * 300 * 0.3 + Math.pow(info.latency1n3, -1) * 300 * 0.2);
            case 4:return (Math.pow(info.dist1n4, -1) * 100 * 0.2 + Math.pow(info.load1n4,-1) * 300 * 0.3 + Math.pow(info.latency1n4, -1) * 300 * 0.2);
            case 5:return (Math.pow(info.dist1n5, -1) * 100 * 0.2 + Math.pow(info.load1n5,-1) * 300 * 0.3 + Math.pow(info.latency1n5, -1) * 300 * 0.2);
            case 6:return (Math.pow(info.dist1n6, -1) * 100 * 0.2 + Math.pow(info.load1n6,-1) * 300 * 0.3 + Math.pow(info.latency1n6, -1) * 300 * 0.2);
        }
        return 0;
    }



}
