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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Container {
    
    private static ArticleController articleController;
    private static HomeController homeController;
    static {
        articleController = Ut.cls.newObj(ArticleController.class, null);
        homeController = Ut.cls.newObj(HomeController.class, null);
    }

    public static ArticleController getArticleController() {
        return articleController;
    }

    public static HomeController getHomeController() {
        return homeController;
    }

//    public static void init(){
//        List<String> ControllerNames = new ArrayList<>();
//
//        Reflections ref = new Reflections("com.ll.exam");
//        for (Class<?> cl : ref.getTypesAnnotatedWith(Controller.class)) {
//            System.out.println("cl.getSimpleName() = " + cl.getSimpleName());
//
//            try {
//                Class<?> myClass = Class.forName("com.ll.exam");
//                Constructor<?> constructor = myClass.getConstructor(String.class);
//                Object object = constructor.newInstance(cl.getSimpleName());
//
//                articleController = (ArticleController) object;
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (NoSuchMethodException e) {
//                throw new RuntimeException(e);
//            } catch (InvocationTargetException e) {
//                throw new RuntimeException(e);
//            } catch (InstantiationException e) {
//                throw new RuntimeException(e);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//
//
//            String name = cl.getSimpleName().replace("Controller", "");
//            name = Ut.str.de(name);
//            ControllerNames.add(name);
//        }
//    }


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
