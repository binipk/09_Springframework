package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassMappingTestController {

    @GetMapping("/order/class-regist")  // 중복 피하려면 경로도 바꿔줘야 해
    public String registOrder(Model model) {
        model.addAttribute("message", "클래스 기반 컨트롤러 - 주문 등록 처리");
        return "mappingResult";
    }
}
