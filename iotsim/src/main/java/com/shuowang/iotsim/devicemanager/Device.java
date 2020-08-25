package com.shuowang.iotsim.devicemanager;

/**

  *
  *
  *
  *
  *
  *
 **/


import com.shuowang.iotsim.balancer.LoadBalancer;
import com.shuowang.iotsim.datagenerator.DataGenerator;
import com.shuowang.iotsim.sendreceive.CallBack;
import com.shuowang.iotsim.sendreceive.PublishToBroker;
import com.shuowang.iotsim.utils.MyUtils;
import org.eclipse.paho.client.mqttv3.MqttCallback;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Device implements Runnable {

    String CLIENT_ID;
    String TOPIC;
    int LENGTH;
    MqttCallback callback;
    DataGenerator DG;
    PublishToBroker PUBLISHER;
    FileInputStream filein;
    BufferedInputStream bufferedin;
    LoadBalancer balancer;
    //int[] byt;
    String message = new String();

    int X;
    int Y;
    @Override
    public void run() {
        //byt = new int[LENGTH];
        PUBLISHER = new PublishToBroker(CLIENT_ID, callback);
        try {
            filein = new FileInputStream(DG.getFileName());
            bufferedin = new BufferedInputStream(filein);
            TOPIC = balancer.getBestNode();
            System.out.println("allocated node to "+CLIENT_ID+"is: "+TOPIC);
            if (TOPIC == "null"){
                System.out.println("hosts not reachable");
            }
            while(bufferedin.read() != -1){
                message += bufferedin.read();
                PUBLISHER.publishMessage(TOPIC, message, 1);
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Device(String clientid, int filelength) throws Exception{
        CLIENT_ID = clientid;
        LENGTH = filelength;
        X = MyUtils.getRandomNum(-50, 50);
        Y = MyUtils.getRandomNum(-50, 50);
        System.out.println("Position of "+clientid+": "+"("+X+", "+Y+")");
        callback = new CallBack();
        balancer = new LoadBalancer(X, Y);
        try {
            DG = new DataGenerator(CLIENT_ID, LENGTH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
