package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;

import java.lang.reflect.InvocationTargetException;

public class Ut {

    public static class cls {

        public static <T>T newObj(Class<T> cls, T defaultValue) {

            try {
                return cls.getDeclaredConstructor().newInstance();

            } catch (InstantiationException e) {
                return null;
            } catch (IllegalAccessException e) {
                return null;
            } catch (InvocationTargetException e) {
                return null;
            } catch (NoSuchMethodException e) {
                return null;
            }
        }
    }
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
