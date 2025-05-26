package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// 📌 이 클래스는 클라이언트의 요청 URL에 따라 적절한 메서드를 실행해주는 Spring MVC 컨트롤러입니다.
public class MethodMappingTestController {

    /* ------------------ [menu 관련 요청 처리] ------------------ */

    // 📌 GET 또는 POST 방식으로 "/menu/regist" 요청 시 실행
    @RequestMapping("/menu/regist")
    public String menuRegist(Model model) {
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 GET 방식의 "/menu/modify" 요청
    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String menuModify(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 수정 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 POST 방식의 "/menu/modify" 요청
    @PostMapping("/menu/modify")
    public String postMenuModify(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 수정 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 GET 방식의 "/menu/delete" 요청
    @GetMapping("/menu/delete")
    public String getMenuDelete(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 삭제 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 POST 방식의 "/menu/delete" 요청
    @PostMapping("/menu/delete")
    public String postMenuDelete(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 삭제 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 "/modify", "/delete" URL에 대한 POST 요청을 동시에 처리
    @RequestMapping(value = {"/modify", "/delete"}, method = RequestMethod.POST)
    public String modifyAndDeleteOrder(Model model) {
        model.addAttribute("message", "POST 방식의 주문 수정/삭제 공용 핸들러 메서드 호출");
        return "mappingResult";
    }

    /* ------------------ [order 관련 요청 처리] ------------------ */

    // 📌 GET 방식의 "/order/regist" 요청
    @GetMapping("/order/regist")
    public String getOrderRegist(Model model) {
        model.addAttribute("message", "GET 방식의 주문 등록 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 POST 방식의 "/order/regist" 요청
    @PostMapping("/order/regist")
    public String postOrderRegist(Model model) {
        model.addAttribute("message", "POST 방식의 주문 등록 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 POST 방식의 "/order/modify" 요청
    @PostMapping("/order/modify")
    public String postOrderModify(Model model) {
        model.addAttribute("message", "POST 방식의 주문 수정 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 POST 방식의 "/order/delete" 요청
    @PostMapping("/order/delete")
    public String postOrderDelete(Model model) {
        model.addAttribute("message", "POST 방식의 주문 삭제 핸들러 메서드 호출");
        return "mappingResult";
    }

    // 📌 GET 방식의 "/order/detail/{orderNo}" 요청 (PathVariable 사용)
    @GetMapping("/order/detail/{orderNo}")
    public String detailOrder(@PathVariable("orderNo") String orderNo, Model model) {
        model.addAttribute("message", "GET 방식의 " + orderNo + "번 주문 상세 핸들러 메서드 호출");
        return "mappingResult";
    }
}
