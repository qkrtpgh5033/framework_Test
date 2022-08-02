package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.GetMapping;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class Container {

    private static Map<Class, Object> objects;

    static {
        objects = new HashMap<>();

        objects.put(ArticleController.class, new ArticleController());
        objects.put(HomeController.class, new HomeController());
    }

    public static <T> T getObj(Class<T> cls) {
        return (T)objects.get(cls);
    }

    public static List<String> getAllControllerNames() {
        List<String> ControllerNames = new ArrayList<>();

        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Controller.class)) {
            System.out.println("cl.getSimpleName() = " + cl.getSimpleName());
            String name = cl.getSimpleName().replace("Controller", "");
            name = Ut.str.de(name);
            ControllerNames.add(name);
        }
        return ControllerNames;
    }

}
