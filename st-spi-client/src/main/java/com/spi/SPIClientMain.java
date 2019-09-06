package com.spi;

import java.util.ServiceLoader;

public class SPIClientMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout shout: shouts) {
            shout.shout();
        }
    }
}
