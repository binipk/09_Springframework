package com.ohgiraffers.common;

// 👉 롬복(Lombok)이라는 라이브러리를 써서 귀찮은 코드들을 자동으로 만들어줌!
import lombok.AllArgsConstructor;  // 모든 필드 값을 넣는 생성자 자동으로 만들어줌
import lombok.Getter;              // getter 메서드 자동 생성 (값 꺼낼 때 사용)
import lombok.Setter;              // setter 메서드 자동 생성 (값 넣을 때 사용)
import lombok.ToString;            // toString 메서드 자동 생성 (내용 출력할 때 보기 쉽게 해줌)

/*
 * 📌 이 클래스는 회원 정보를 담는 데이터 상자야! (이런 걸 DTO라고 불러)
 * - 예: 회원 번호, 아이디, 비밀번호, 이름 등을 저장해두고
 * - 다른 클래스에서 이 값을 꺼내서 쓰거나 바꿀 수 있음
 */

// 📌 롬복 어노테이션 (자동으로 필요한 메서드들 만들어줌!)
@Getter          // 👉 getId(), getPwd() 이런 걸 자동으로 만들어줘
@Setter          // 👉 setId("값"), setName("홍길동") 같은 것도 자동 생성
@ToString        // 👉 println(member) 했을 때 예쁘게 출력되게 해줌
@AllArgsConstructor  // 👉 new MemberDTO(1, "id", "pwd", "이름") 이렇게 바로 만들 수 있게 해줌
public class MemberDTO {

    // 👉 회원 번호
    private int sequence;

    // 👉 회원 아이디
    private String id;

    // 👉 회원 비밀번호
    private String pwd;

    // 👉 회원 이름
    private String name;
}
