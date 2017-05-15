package org.tac.tests.string;

import java.lang.reflect.*;

public class Warper {
    private static Field stringValue;
    static {
        // String has a private char [] called "value"
        // if it does not, find the char [] and assign it to value
        try {
            stringValue = String.class.getDeclaredField("value");
        } catch (NoSuchFieldException ex) {
            // safety net in case we are running on a VM with a
            // different name for the char array.
            Field[] all = String.class.getDeclaredFields();
            for (int i = 0; stringValue == null && i < all.length; i++) {
                if (all[i].getType().equals(char[].class)) {
                    stringValue = all[i];
                }
            }
        }
        if (stringValue != null) {
            stringValue.setAccessible(true); // make field public
        }
    }

    public Warper() {
        try {
            stringValue.set("Romeo, Romeo, wherefore art thou oh Romero?", "Stop this romance nonsense, or I'll be sick".toCharArray());
            stringValue.set("hi there", "cheers !".toCharArray());
        } catch (IllegalAccessException ex) {
        } // shhh
    }
}