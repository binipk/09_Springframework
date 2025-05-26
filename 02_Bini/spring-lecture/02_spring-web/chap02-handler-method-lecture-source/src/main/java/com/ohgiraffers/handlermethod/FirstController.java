package com.ohgiraffers.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/first/*")  // 📌 모든 요청이 "/first/"로 시작하는 주소에 대해 이 컨트롤러가 담당함
public class FirstController {

    /* 📌 [1] GET 방식: 메뉴 등록 화면 보여주기
     * - 주소: GET /first/regist
     * - 반환 타입이 void면 -> "first/regist.html" 파일을 찾아감
     */
    @GetMapping("/regist")
    public void regist() {
        // 아무 것도 안 해도 view 이름은 /templates/first/regist.html
    }

    /* 📌 [2] POST 방식: WebRequest로 form 데이터 받기
     * - 주소: POST /first/regist
     * - WebRequest는 사용자가 form에 입력한 데이터를 가져올 수 있는 객체
     */
    @PostMapping("/regist")
    public String registMenu(WebRequest request, Model model) {

        // 📌 form에서 넘어온 값 꺼내기
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        // 📌 응답할 메시지 작성하고 모델에 담기 (→ View에서 ${message}로 출력 가능)
        String message = name + "을 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
                + price + "원으로 등록했습니다.";
        model.addAttribute("message", message);

        // 📌 templates/first/messagePrinter.html을 반환
        return "first/messagePrinter";
    }

    /* 📌 [3] GET 방식: 메뉴 수정 화면 보여주기 */
    @GetMapping("/modify")
    public void modify() {
        // → templates/first/modify.html을 찾아감
    }

    /* 📌 [4] POST 방식: @RequestParam 사용
     * - 주소: POST /first/modify
     * - form에서 넘어온 값을 변수로 자동 바인딩 받음
     */
    @PostMapping("/modify")
    public String modifyMenu(
            @RequestParam(value = "nam", required = false) String modifyName,  // ❗ 오타: name → nam (故 intentionally 설명용일 수도 있음)
            @RequestParam(value = "price", defaultValue = "0") int modifyPrice,
            Model model
    ) {
        // 📌 메시지 작성
        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경했습니다.";
        model.addAttribute("message", message);

        // 📌 templates/first/messagePrinter.html로 이동
        return "first/messagePrinter";
    }

    /* 📌 [5] GET 방식: 검색 페이지 보여주기 */
    @GetMapping("/search")
    public void search() {
        // → templates/first/search.html
    }

    /* 📌 [6] POST 방식: @ModelAttribute 사용
     * - form 값을 객체(DTO)에 한 번에 담아서 전달받음
     * - 자동으로 View에 menu 라는 이름으로도 전달됨 (생략 가능)
     */
    @PostMapping("/search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menuDTO) {
        // menuDTO.getName(), getPrice() 등으로 접근 가능
        return "first/searchResult";
    }

    /* 📌 [7] GET 방식: 로그인 페이지 보여주기 */
    @GetMapping("/login")
    public void login() {
        // → templates/first/login.html
    }

    /* 📌 [8] POST 방식: 로그인 시 세션에 데이터 저장
     * - id라는 값을 모델에 저장하면 View에 출력 + 세션에도 저장 가능
     * - 나중에 @SessionAttribute로 꺼낼 수 있음
     */
    @PostMapping("/login")
    public String loginTest(String id, Model model) {
        model.addAttribute("id", id);  // → ${id}로 View에서 출력 가능
        return "first/login Result";   // → templates/first/login Result.html
    }

    /* @SessionAttribute 만료
     * SessionStatus 라는 세션의 상태를 관리하는 객체의 setComplete 메소드로 세션을 만료 시킨다.
     * HttpSession의 invalidate 메소드를 호출해도 세션 값은 만료 되지 않고 유지 된다.
     * */

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "/first/loginResult";
    }

    @GetMapping("/body")
    public void body() {
    }

    @PostMapping("/body")
    public void bodyTest(
            @RequestBody String body,
            @RequestHeader("content-type")String contentType
    ) {
        System.out.println("body = " + body);
        System.out.println("contentType = " + contentType);
    }
}
