package com.shuowang.iotsim.sendreceive;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class CallBackofBalancer implements MqttCallback {
    String back;

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        back = new String(mqttMessage.getPayload());
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    public String getBackMsg() {
        return back;
    }
}
