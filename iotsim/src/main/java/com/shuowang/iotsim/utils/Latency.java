package com.shuowang.iotsim.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Latency {

    static final int DEFAULT = 2147483647;
    volatile static int latency;


    public static int getLatency(String addr) {
        Runtime runtime =Runtime.getRuntime();
        Process process ;
        String line;
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;
        String ip = addr;
        String rgex = "time<*=*(.*?)ms";
        try {
            process =runtime.exec("ping " + ip); // PING
            is =process.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            br.readLine();
            br.readLine();
            line = br.readLine();
            getSubUtilSimple(line, rgex);
            is.close();
            isr.close();
            br.close();
        } catch (IOException e) {
            System.out.println(e);
            runtime.exit(1);
        }
        return latency;
    }
    public static void getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            latency = Integer.parseInt(m.group(1));
            return;
        }
        latency = DEFAULT;

    }
}
