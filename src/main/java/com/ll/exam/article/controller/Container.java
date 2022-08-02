package com.ll.exam.article.controller;

public class Container {
    private static final ArticleController articleController = new ArticleController();
    public static ArticleController getArticleController() {
        return articleController;
    }
}
