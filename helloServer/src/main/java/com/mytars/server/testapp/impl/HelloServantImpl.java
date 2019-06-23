package com.mytars.server.testapp.impl;

import com.mytars.server.testapp.HelloServant;

public class HelloServantImpl implements HelloServant {
    @Override
    public String hello(int no, String name) {
        return String.format("hello no=%s, name=%s, time=%s", no, name, System.currentTimeMillis());
    }
}
