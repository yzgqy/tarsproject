package com.mytars.client.testapp;

import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;

public class TestHello {
    public static void main(String[] args) {
//        CommunicatorConfig cfg = new CommunicatorConfig();
//        //构建通信器
//        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
//        //通过通信器，生成代理对象tcp -h 172.17.0.3 -t 60000 -p 18600 -e 0
//        HelloPrx proxy = communicator.stringToProxy(HelloPrx.class, "TestApp.helloServer.HelloObj@tcp -h 172.16.196.129 -p 18600");
//        String ret = proxy.hello(10050, "HelloWorld");
//        System.out.println(ret);

        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
//        TestApp.helloServer.HelloObj	tcp -h 172.17.0.3 -t 60000 -p 18600 -e 0
//        HelloPrx proxy = communicator.stringToProxy(HelloPrx.class, "TestApp.helloServer.HelloObj@tcp -h 172.16.196.129 -p 18600 -t 60000");
        HelloPrx proxy = communicator.stringToProxy(HelloPrx.class, "TestApp.HelloServer.HelloObj@tcp -h 127.0.0.1 -p 18601 -t 3000");

        //同步调用
        String ret = proxy.hello(105, "Hello World");
        System.out.println("返回： "+ret);

        //单向调用
//        proxy.async_hello(null, 1000, "Hello World");

        //异步调用
//        proxy.async_hello(new HelloPrxCallback() {
//、
//            @Override
//            public void callback_expired() {
//            }
//
//            @Override
//            public void callback_exception(Throwable ex) {
//            }
//
//            @Override
//            public void callback_hello(String ret) {
//                System.out.println(ret);
//            }
//        }, 1000, "Hello World");

    }
}
