package com.ll.exam;

public class Ut {
    public static class str{

        public static String de(String name) {
            String str = "java";
            String firstLtr = str.substring(0, 1);
            String restLtrs = str.substring(1, str.length());

            String first = name.substring(0, 1);
            String rest = name.substring(1, name.length());
            first = first.toLowerCase();
            return first+rest;
        }
    }
}
