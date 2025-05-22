package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

/**
 * 📌 MemberDAO 클래스
 * - DAO는 "Data Access Object"의 줄임말로, 데이터를 **저장하거나 꺼내오는 기능**을 담당하는 클래스야.
 * - 여기서는 DB를 쓰지 않고, 자바에서 제공하는 Map 자료구조를 이용해서
 *   간단히 회원 정보를 저장/조회할 수 있도록 만든 예제 DAO임.
 * - 실제 개발에서는 DB와 연결해서 SQL 실행하거나 ORM을 사용할 수도 있음.
 *
 * 📎 @Repository
 * - 이 클래스가 데이터 저장소 역할을 한다는 걸 Spring에게 알려주는 어노테이션이야.
 * - 이렇게 붙여 놓으면 Spring이 자동으로 Bean으로 등록해줘서
 *   다른 클래스에서 @Autowired 등으로 주입해서 사용할 수 있어.
 */
@Repository
public class MemberDAO {

    /**
     * 🧾 회원 정보를 저장할 공간
     * - Map을 사용해서 데이터를 메모리에 저장하고 있음.
     *   → DB 대신 메모리를 쓰는 거야. 연습용으로 많이 씀.
     * - key: 회원 번호 (int)
     * - value: 회원 정보 객체(MemberDTO)
     */
    private final Map<Integer, MemberDTO> memberMap;

    /**
     * ✅ 생성자
     * - 객체가 처음 생성될 때 회원 2명의 정보를 미리 넣어놔.
     * - 실전에서는 이런 건 DB에서 불러오지만,
     *   연습 단계에서는 메모리(Map)에 이렇게 직접 넣어두기도 해.
     */
    public MemberDAO() {
        memberMap = new HashMap<>();

        // 예시 회원 1: sequence=1, 아이디=user01
        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));

        // 예시 회원 2: sequence=2, 아이디=user02
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    /**
     * 📘 회원 번호로 회원 정보 조회
     * - 사용자가 입력한 회원 번호로 저장된 회원 정보를 찾아서 꺼내주는 메서드
     *
     * @param sequence 찾고 싶은 회원의 번호 (예: 1)
     * @return 그 번호에 해당하는 MemberDTO 객체 (없으면 null 반환)
     */
    public MemberDTO selectMember(int sequence) {
        return memberMap.get(sequence);
    }

    /**
     * 📗 회원 정보 추가
     * - 새로운 회원 정보를 Map에 추가하는 메서드
     * - 기존 Map 사이즈와 비교해서 회원이 실제로 추가되었는지 확인함
     *
     * @param member 추가할 회원 정보 객체
     * @return 추가에 성공했으면 true, 이미 같은 번호가 있어서 실패했으면 false
     */
    public boolean insertMember(MemberDTO member) {
        int before = memberMap.size();  // 추가 전 회원 수

        // 새로운 회원 정보 추가 (같은 key면 덮어쓰기 됨)
        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();   // 추가 후 회원 수

        // 회원 수가 늘었으면 추가 성공 (덮어쓰기면 실패라고 판단)
        return after > before;

        
    }

}



