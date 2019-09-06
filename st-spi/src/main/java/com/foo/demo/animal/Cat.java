package com.foo.demo.animal;

import com.foo.demo.IShout;

public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
