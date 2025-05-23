package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 회원 정보를 저장하고 조회하는 DAO 클래스
 * - Spring Bean으로 등록됨 (@Repository)
 */
@Repository
public class MemberDAO {

    // 회원 정보를 담는 Map: key = 회원 ID, value = MemberDTO
    private final Map<Long, MemberDTO> memberDTOMap;

    // 생성자: 샘플 회원 데이터를 Map에 초기화
    public MemberDAO() {
        memberDTOMap = new HashMap<>();
        memberDTOMap.put(1L, new MemberDTO(1L, "유관순"));
        memberDTOMap.put(2L, new MemberDTO(2L, "홍길동"));
    }

    /**
     * 모든 회원 조회
     * @return 회원 Map
     */
    public Map<Long, MemberDTO> selectMembers() {
        return memberDTOMap;
    }

    /**
     * 단일 회원 조회
     * @param id 조회할 회원의 ID
     * @return 해당 ID의 회원 정보
     * @throws RuntimeException 회원이 없을 경우 예외 발생
     */
    public MemberDTO selectMember(Long id) {
        MemberDTO returnMember = memberDTOMap.get(id); // 오타 수정됨
        if (returnMember == null) {
            throw new RuntimeException("해당 id의 회원은 없어!");
        }
        return returnMember;
    }
}
