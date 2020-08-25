package com.shuowang.iotsim.sendreceive;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class EdgeCallBack implements MqttCallback {
    BufferedOutputStream bufferedOutputStream;

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("cscloud1n2.txt")); //cscloud1n3.txt
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
