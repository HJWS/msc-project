package com.shuowang.iotsim.utils;


import java.util.Random;

public class MyUtils {
    public static Random RDM = new Random(System.currentTimeMillis());

    public static int getRandomNum(int from, int to){
        long range = (long)to - (long)from + 1;
        long fraction = (long)(range * RDM.nextDouble());
        return (int)(fraction + from);
    }
}
