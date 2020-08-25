package com.shuowang.iotsim.datagenerator;

import java.io.*;
import com.shuowang.iotsim.sendreceive.PublishToBroker;

public class DataGenerator {

    private String FILE_NAME;
    private static String PATH = "E:\\MSC project\\my project\\src\\main\\resources\\";
    private int STRING_LENGTH;
    FileOutputStream fout;

    public DataGenerator(String filename, int length) throws FileNotFoundException {
        FILE_NAME = filename;
        STRING_LENGTH = length;
        dataGen();
    }

    private void dataGen() throws FileNotFoundException {
        fout = new FileOutputStream(PATH + FILE_NAME + ".txt");
        int i = 0;
        while (i < STRING_LENGTH)
        {
            try {
                fout.write(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i ++;
        }
    }
    public String getFileName(){return PATH + FILE_NAME + ".txt";}

}
