package com.example.my.domain.todo.controller;

import com.example.my.domain.todo.service.TodoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 배열로 경로 설정, 두가지 경로 모두 매핑
    @GetMapping({"", "/"})
    public ModelAndView todoTablePage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        // 세션에서 유저정보가 null이면 로그인 페이지로 강제 이동
        if(session.getAttribute("dto") == null){
            // redirect : 컨트롤러로 이동.
            modelAndView.setViewName("redirect:/auth/login");
            return modelAndView;
        }
        // null이 아니면 todo 정보 담아서 메인페이지 이동

        System.out.println(session.getAttribute("dto"));

        modelAndView.setViewName("todo/table");
        return modelAndView;
    }

}
