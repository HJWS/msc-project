package com.shuowang.iotsim.sendreceive;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class CallBack implements MqttCallback{

    public CallBack(){}
    public void connectionLost(Throwable throwable) {

    }

    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {


        System.out.println("Receive:\n" + "Topic: " + topic + "\n" + "Content" + new String(mqttMessage.getPayload()));
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
