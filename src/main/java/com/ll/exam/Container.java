package com.ll.exam;

import com.ll.exam.annotation.Autowired;
import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.Service;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.article.service.ArticleService;
import org.reflections.Reflections;

import java.util.*;


public class Container {

    private static Map<Class, Object> objects;

    static {
        objects = new HashMap<>();

        scanServices();
        scanControllers();
        initObject();


    }
    private static void initObject() {

        for (Class clsKey : objects.keySet()) {
            Object obj = objects.get(clsKey);
            Arrays.asList(obj.getClass().getDeclaredFields())
                    .stream()
                    .sequential()
                    .filter(f -> f.isAnnotationPresent(Autowired.class))
                    .map(field -> {
                        field.setAccessible(true);
                        return field;
                    })
                    .forEach(field -> {
                        Class clazz = field.getType();

                        try {
                            field.set(obj, objects.get(clazz));
                        } catch (IllegalAccessException e) {

                        }
                    });
        }

    }
    private static void scanServices() {
        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Service.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
    }

    private static void scanControllers() {
        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
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
