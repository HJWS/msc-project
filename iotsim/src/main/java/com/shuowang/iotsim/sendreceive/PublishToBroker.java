package com.shuowang.iotsim.sendreceive;



import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class PublishToBroker {

    public MqttClient mqttClient = null;
    public static MemoryPersistence memoryPersistence = null;
    public static MqttConnectOptions mqttConnectOptions = null;
    public String CLIENT_ID;
    public MqttCallback CALLBACK;

    public PublishToBroker(String client_id, MqttCallback cb) {
        CLIENT_ID = client_id;
        init(client_id);
        CALLBACK = cb;
    }


    private void init(String clientId) {
        //初始化连接设置对象
        mqttConnectOptions = new MqttConnectOptions();
        //初始化MqttClient
        if (null != mqttConnectOptions) {
//			true可以安全地使用内存持久性作为客户端断开连接时清除的所有状态
            mqttConnectOptions.setCleanSession(true);
//			设置连接超时
            mqttConnectOptions.setConnectionTimeout(30);
//			设置持久化方式
            memoryPersistence = new MemoryPersistence();
            if (null != memoryPersistence && null != clientId) {
                try {
                    mqttClient = new MqttClient("tcp://127.0.0.1:1883", clientId, memoryPersistence); //连接到broker
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {

            }
        } else {
            System.out.println("mqttConnectOptions对象为空");
        }

        System.out.println(mqttClient.isConnected());
        //设置连接和回调
        if (null != mqttClient) {
            if (!mqttClient.isConnected()) {

//			创建回调函数对象
                //CallBack mqttReceriveCallback = new CallBack();
//			客户端添加回调函数
                mqttClient.setCallback(CALLBACK);
//			创建连接
                try {
                    System.out.println("connecting" +
                            "" +
                            "" +
                            "" +
                            "...");
                    mqttClient.connect(mqttConnectOptions);
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else {
            System.out.println("mqttClient为空");
        }
        System.out.println("MQTT connection establish status:" + mqttClient.isConnected());
    }

    //	关闭连接
    public void closeConnect() {
        //关闭存储方式
        if (null != memoryPersistence) {
            try {
                memoryPersistence.close();
            } catch (MqttPersistenceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("memoryPersistence is null");
        }

//		关闭连接
        if (null != mqttClient) {
            if (mqttClient.isConnected()) {
                try {
                    mqttClient.disconnect();
                    mqttClient.close();
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("mqttClient is not connect");
            }
        } else {
            System.out.println("mqttClient is null");
        }
    }

    //	发布消息
    public void publishMessage(String pubTopic, String message, int qos) {
        if (null != mqttClient && mqttClient.isConnected()) {
            System.out.println("发布消息   " + mqttClient.isConnected());
            System.out.println("id:" + mqttClient.getClientId());
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            mqttMessage.setPayload(message.getBytes());

            MqttTopic topic = mqttClient.getTopic(pubTopic);

            if (null != topic) {
                try {
                    MqttDeliveryToken publish = topic.publish(mqttMessage);
                    if (!publish.isComplete()) {
                        System.out.println("消息发布成功");
                    }
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } else {
            reConnect(this.CLIENT_ID);
        }

    }

    //	重新连接
    public void reConnect(String clientid) {
        if (null != mqttClient) {
            if (!mqttClient.isConnected()) {
                if (null != mqttConnectOptions) {
                    try {
                        mqttClient.connect(mqttConnectOptions);
                    } catch (MqttException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("mqttConnectOptions is null");
                }
            } else {
                System.out.println("mqttClient is null or connect");
            }
        } else {
            init(clientid);
        }

    }

    //	订阅主题
    public void subTopic(String topic) {
        if (null != mqttClient && mqttClient.isConnected()) {
            try {
                mqttClient.subscribe(topic, 1);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("mqttClient is error");
        }
    }


    //	清空主题
    public void cleanTopic(String topic) {
        if(null != mqttClient&& !mqttClient.isConnected()) {
            try {
                mqttClient.unsubscribe(topic);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            System.out.println("mqttClient is error");
        }
    }

//    @Override
//    public void run() {
//        try {
//            for (int i=0;i<6;i++){
//                PublishToBroker publishServer=new PublishToBroker();
//                Thread.sleep(1000);
//                publishServer.publishMessage(""+i,"hello"+i,1);
//
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}

