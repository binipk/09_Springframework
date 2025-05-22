package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 📌 BookService 클래스
 * - 비즈니스 로직을 처리하는 서비스 클래스
 * - @Service 어노테이션을 통해 스프링이 자동으로 Bean으로 등록
 * - "bookServiceConstructor"라는 이름으로 등록됨
 */
@Service("bookServiceConstructor")
public class BookService {

    /**
     * 🔐 BookDAO 의존성 (필수 의존성)
     * - final로 선언하여 반드시 생성자를 통해 주입되도록 강제함
     */
    private final BookDAO bookDAO;

    /**
     * ✅ 생성자 주입 방식
     * - BookDAO 타입의 Bean을 스프링이 자동으로 주입해줌
     * - 생성자가 하나뿐이면 @Autowired 생략 가능 (Spring 4.3 이상)
     */
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * 📘 전체 도서 목록 조회
     * @return 모든 도서 리스트
     */
    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    /**
     * 📗 특정 번호의 도서 조회
     * @param sequence 도서 번호
     * @return 도서 정보
     */
    public BookDTO selectBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
