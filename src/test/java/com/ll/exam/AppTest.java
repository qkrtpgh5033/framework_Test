package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.article.repository.ArticleRepository;
import com.ll.exam.home.controller.HomeController;
import com.ll.exam.article.service.ArticleService;
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
        ArticleController articleController = Container.getObj(ArticleController.class);

        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc_homeController(){
        HomeController homeController = Container.getObj(HomeController.class);

        assertThat(homeController).isNotNull();
    }

    @Test
    public void ioc__articleController__싱글톤() {
        ArticleController articleController1 = Container.getObj(ArticleController.class);
        ArticleController articleController2 = Container.getObj(ArticleController.class);
        // 실행, 기대
        assertThat(articleController2).isEqualTo(articleController1);
    }
    @Test
    public void ioc_homeController__싱글톤() {
        HomeController homeController1 = Container.getObj(HomeController.class);
        HomeController homeController2 = Container.getObj(HomeController.class);
        // 실행, 기대
        assertThat(homeController2).isEqualTo(homeController1);
    }

    @Test
    public void ioc_Controller들을_스캔하여_수집(){
        List<String> lists = Container.getAllControllerNames();
        System.out.println(lists.toString());
        assertThat(lists).contains("home");
        assertThat(lists).contains("article");
    }

    @Test
    public void ioc__articleService() {
        ArticleService articleService = Container.getObj(ArticleService.class);

        assertThat(articleService).isNotNull();
    }

    @Test
    public void ioc__articleService__싱글톤() {
        ArticleService articleService1 = Container.getObj(ArticleService.class);
        ArticleService articleService2 = Container.getObj(ArticleService.class);

        assertThat(articleService2).isEqualTo(articleService1);
    }

    @Test
    public void articleController를_생성할때_articleService도_같이_생성(){
        ArticleController articleController = Container.getObj(ArticleController.class);

        ArticleService articleService = Ut.reflection.getFieldValue(articleController, "articleService", null);
        assertThat(articleService).isNotNull();
    }

    @Test
    public void articleService를_생성할때_articleRepository도_같이_생성(){
        ArticleService articleService = Container.getObj(ArticleService.class);

        ArticleRepository articleRepository = Ut.reflection.getFieldValue(articleService, "articleRepository", null);
        assertThat(articleRepository).isNotNull();
    }


}