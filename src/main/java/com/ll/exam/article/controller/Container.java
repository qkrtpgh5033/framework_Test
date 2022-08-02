package com.ll.exam.article.controller;

public class Container {
    static ArticleController articleController = new ArticleController();
    public static ArticleController getArticleController() {
        return articleController;
    }
}
