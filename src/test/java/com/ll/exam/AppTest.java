package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test
    public void junit_aseerThat() {
        int rs = 10+20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    public void ioc_articleController(){
        ArticleController articleController = Container.getArticleController();

        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc__articleController__싱글톤() {
        ArticleController articleController1 = Container.getArticleController();
        ArticleController articleController2 = Container.getArticleController();
        // 실행, 기대
        assertThat(articleController2).isEqualTo(articleController1);
    }

    @Test
    public void ioc_Controller들을_스캔하여_수집(){
        List<String> lists = Container.getAllControllerNames();
        System.out.println(lists.toString());
        assertThat(lists).contains("home");
        assertThat(lists).contains("article");


    }

}