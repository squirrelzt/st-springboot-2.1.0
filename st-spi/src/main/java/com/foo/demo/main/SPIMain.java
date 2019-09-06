package com.foo.demo.main;

import com.foo.demo.IShout;

import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout shout: shouts) {
            shout.shout();
        }
    }
}
