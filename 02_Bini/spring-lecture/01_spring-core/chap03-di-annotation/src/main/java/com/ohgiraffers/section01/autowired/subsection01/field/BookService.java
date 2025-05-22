package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 📘 BookService 클래스
 * - 도서 관련 기능을 제공하는 서비스 클래스
 * - @Service 어노테이션으로 스프링이 자동으로 Bean으로 등록해줌
 */
@Service("bookServiceField")
public class BookService {

    /**
     * ✅ 필드 주입(Field Injection)
     * - @Autowired를 이용해서 스프링 컨테이너가 BookDAO 타입의 객체를 자동으로 주입함
     * - 필드 주입은 간편하지만, 단위 테스트나 유지보수 시 불리할 수 있음
     * - ※ final 사용 불가 (컴파일 에러) → 생성자 주입이 더 권장됨
     */
    @Autowired
    private BookDAO bookDAO;

    // 전체 도서 목록 조회
    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    // 특정 도서 조회 (sequence로 검색)
    public BookDTO selectBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
