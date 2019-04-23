package com.service.impl;

import com.service.Speakable;
import org.springframework.stereotype.Service;

@Service
public class PersonSpring implements Speakable {

    @Override
    public void sayHi() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!");
    }
}
