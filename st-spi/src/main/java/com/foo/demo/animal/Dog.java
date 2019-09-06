package com.foo.demo.animal;

import com.foo.demo.IShout;

public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
