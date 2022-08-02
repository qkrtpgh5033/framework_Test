package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.GetMapping;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Container {
    
    private static final ArticleController articleController = new ArticleController();
    private static final HomeController homeController = new HomeController();

    public static ArticleController getArticleController() {
        return articleController;
    }

    public static HomeController getHomeController() {
        return homeController;
    }

    public Container() {
        collectRouteInfosByAnnotations();
    }

    public static List<String> getAllControllerNames() {
        List<String> ControllerNames = new ArrayList<>();
        
        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Controller.class)) {
            String name = cl.getSimpleName().replace("Controller", "");
            name = Ut.str.de(name);
            ControllerNames.add(name);
        }
        return ControllerNames;
    }

    private void collectRouteInfosByAnnotations() {
//        Reflections ref = new Reflections("com.ll.exam");
//        for (Class<?> cl : ref.getTypesAnnotatedWith(Controller.class)) {
//            System.out.println("cl.getName() = " + cl.getName());
////            Method[] methods = cl.getDeclaredMethods();
//            String[] split = cl.getName().split(".");
//            cl.get
//            Controller annotation = cl.getAnnotation(Controller.class);
//            System.out.println("annotation = " + annotation);
//
//        }

        
    }

}
