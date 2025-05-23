package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 회원 관련 비즈니스 로직을 담당하는 서비스 클래스
 * - DAO를 주입 받아 데이터를 처리
 */
@Service
public class MemberService {

    private final MemberDAO memberDAO;

    // 생성자 주입 방식
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    /**
     * 전체 회원 조회 메서드
     * @return 회원 목록
     */
    public Map<Long, MemberDTO> selectMembers() {
        System.out.println("selectMembers 메소드 실행");
        return memberDAO.selectMembers();
    }

    /**
     * 단일 회원 조회 메서드
     * @param id 회원 ID
     * @return 해당 ID의 회원 정보
     */
    public MemberDTO selectMember(Long id) {
        System.out.println("selectMember 메서드 실행");
        return memberDAO.selectMember(id);
    }
}
