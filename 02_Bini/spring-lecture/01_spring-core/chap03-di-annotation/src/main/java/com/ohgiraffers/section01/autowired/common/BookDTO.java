package com.ohgiraffers.section01.autowired.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 📘 BookDTO 클래스
 * - 책 정보를 저장하는 Data Transfer Object (DTO)
 * - Lombok 어노테이션을 활용하여 getter, setter, 생성자, toString 자동 생성
 */
@Getter // 각 필드의 getter 메서드를 자동 생성해줌
@Setter // 각 필드의 setter 메서드를 자동 생성해줌
@ToString // 객체 정보를 문자열로 표현할 때 유용 (디버깅용)
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 자동 생성
public class BookDTO {

    private int sequence;       // 책 고유 번호 (시퀀스 ID)
    private int isbn;           // 책의 ISBN 번호
    private String title;       // 책 제목
    private String author;      // 저자 이름
    private String publisher;   // 출판사
    private Date createdDate;   // 등록일 또는 출판일
}
