package com.ll.exam.article.controller;


import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.GetMapping;

@Controller // 해당 클래스는 컨트롤러 이다.
public class ArticleController {
    @GetMapping("/usr/article/list") //  경로와 같이 관련된 요청을 처리하는 함수이다.
    public void showList() {

    }
    public ArticleController() {

    }
}
