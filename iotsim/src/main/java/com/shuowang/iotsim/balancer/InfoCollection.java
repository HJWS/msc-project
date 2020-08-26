package com.shuowang.iotsim.balancer;


public class InfoCollection {

    int latency1n2;
    int latency1n3;
    int latency1n4;
    int latency1n5;
    int latency1n6;

    int load1n2;
    int load1n3;
    int load1n4;
    int load1n5;
    int load1n6;

    int dist1n2;
    int dist1n3;
    int dist1n4;
    int dist1n5;
    int dist1n6;

    String cs1n2 = "10.1.0.155";
    String cs1n3 = "10.1.0.154";
    String cs1n4 = "10.1.0.153";
    String cs1n5 = "10.1.0.152";
    String cs1n6 = "10.1.0.151";
    static final int X2 = 0, Y2 = 0;
    static final int X3 = 20, Y3 = 20;
    static final int X4 = 20, Y4 = -20;
    static final int X5 = -20, Y5 = 20;
    static final int X6 = -20, Y6 = -20;






    public void collectLatency() throws InterruptedException {

        LatencyUpdate latup = new LatencyUpdate();
        latency1n2 = latup.run(cs1n2);
        latency1n3 = latup.run(cs1n3);
        latency1n4 = latup.run(cs1n4);
        latency1n5 = latup.run(cs1n5);
        latency1n6 = latup.run(cs1n6);
        System.out.println("latency:\ncscloud1n2: " +latency1n2+
                " \ncscloud1n3: " +latency1n3+
                " \ncscloud1n4: " +latency1n4+
                " \ncscloud1n5: " +latency1n5+
                " \ncscloud1n6: " +latency1n6);
    }
    public void collectLoad() throws InterruptedException {

        LoadUpdate loaup = new LoadUpdate();
        load1n2 = loaup.run("LoadUpdater_1n2", "cscloud1n2");
        load1n3 = loaup.run("LoadUpdater_1n3", "cscloud1n3");
        load1n4 = loaup.run("LoadUpdater_1n4", "cscloud1n4");
        load1n5 = loaup.run("LoadUpdater_1n5", "cscloud1n5");
        load1n6 = loaup.run("LoadUpdater_1n6", "cscloud1n6");
//        loaup.run("LoadUpdater_1n2", "cscloud1n2");
//        loaup.run("LoadUpdater_1n3", "cscloud1n3");
//        loaup.run("LoadUpdater_1n4", "cscloud1n4");
//        loaup.run("LoadUpdater_1n5", "cscloud1n5");
//        loaup.run("LoadUpdater_1n6", "cscloud1n6");

//        load1n2 = 11;
//        load1n3 = 11;
//        load1n4 = 12;
//        load1n5 = 11;
//        load1n6 = 12;
        System.out.println("load:\ncscloud1n2: " +load1n2+
                " \ncscloud1n3: " +load1n3+
                " \ncscloud1n4: " +load1n4+
                " \ncscloud1n5: " +load1n5+
                " \ncscloud1n6: " +load1n6);

            //Thread.sleep(3000);
        //}

    }

    public void calDistance(int x, int y) {
//        System.out.println("("+x+", "+y+")");
        dist1n2 = (int) Math.sqrt((X2 - x)*(X2 - x) + (Y2 - y)*(Y2 - y));
        dist1n3 = (int) Math.sqrt(Math.pow((X3 - x), 2) + Math.pow((Y3 - y), 2));
        dist1n4 = (int) Math.sqrt(Math.pow((X4 - x), 2) + Math.pow((Y4 - y), 2));
        dist1n5 = (int) Math.sqrt(Math.pow((X5 - x), 2) + Math.pow((Y5 - y), 2));
        dist1n6 = (int) Math.sqrt(Math.pow((X6 - x), 2) + Math.pow((Y6 - y), 2));
        System.out.println("distance:\ncscloud1n2: " +dist1n2+
                " \ncscloud1n3: " +dist1n3+
                " \ncscloud1n4: " +dist1n4+
                " \ncscloud1n5: " +dist1n5+
                " \ncscloud1n6: " +dist1n6);
    }

    public InfoCollection() throws InterruptedException {

        this.collectLoad();
        this.collectLatency();
    }
}
