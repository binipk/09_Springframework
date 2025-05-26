package HandlerMethod; // 📌 이 클래스가 포함된 패키지 이름

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*
 📌 @Controller
 - 이 클래스가 Spring MVC에서 요청을 처리하는 '컨트롤러' 역할임을 스프링에게 알려줌
 - DispatcherServlet이 이 클래스를 스캔해서 요청을 위임하게 됨
*/
@RequestMapping("/first/*")
/*
 📌 @RequestMapping("/first/*")
 - 이 컨트롤러 안의 모든 메서드는 "/first/"로 시작하는 요청만 처리함
 - * 는 와일드카드로, 그 뒤에 뭐가 오든 다 허용됨
   예: "/first/regist", "/first/anything", "/first/hello" 등등
*/
public class FirstController {

    // 📌 예: 사용자가 브라우저에서 /first/regist 로 요청한 경우 처리됨
    @GetMapping("/regist")
    /*
     📌 @GetMapping("/regist")
     - 위의 @RequestMapping("/first/*")와 결합해서
       → 최종 요청 URL은 "/first/regist" 가 됨
     - 즉, GET 방식으로 "/first/regist" 요청이 오면 이 메서드 실행
    */
    public void regist() {
        /*
         📌 반환 타입이 void일 때 어떻게 동작하냐면?

         - 반환 타입이 void 이면, 스프링은 자동으로 "요청 URL과 같은 이름"의 View를 찾아감
           예: "/first/regist" 요청이면 → "regist.jsp" 를 찾게 됨

         - 실제로는 "/WEB-INF/views/regist.jsp" 같은 파일을 보여주는 구조임
           (스프링 설정에 따라 prefix/suffix 붙음)

         - 이 방식은 간단하지만, 명시적이지 않아서 실무에서는 잘 안 씀
           → 실무에선 보통 return "regist"; 처럼 문자열로 View 이름을 명확히 씀
        */
    }

}
