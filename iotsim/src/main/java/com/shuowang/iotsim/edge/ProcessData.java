package com.shuowang.iotsim.edge;

import com.shuowang.iotsim.sendreceive.EdgeCallBack;
import com.shuowang.iotsim.sendreceive.PublishToBroker;
import org.eclipse.paho.client.mqttv3.MqttCallback;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProcessData {
    BufferedInputStream bufferedInputStream;
    EdgeCallBack edgeCallBack;
    public void connectBroker(){
        PublishToBroker publishToBroker = new PublishToBroker("cscloud1n2", edgeCallBack);
        publishToBroker.subTopic("cscloud1n2");
    }
    public void doProcess() throws IOException {
        while(bufferedInputStream == null)
            bufferedInputStream = new BufferedInputStream(new FileInputStream("cscloud1n2.txt"));
        while (true){
            System.out.println(bufferedInputStream.read());
        }
    }
}
