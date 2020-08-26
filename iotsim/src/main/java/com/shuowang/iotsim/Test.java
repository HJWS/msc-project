package com.shuowang.iotsim;

import com.shuowang.iotsim.datagenerator.DataGenerator;


import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        DataGenerator dg = new DataGenerator("test", 580);
    }
}
