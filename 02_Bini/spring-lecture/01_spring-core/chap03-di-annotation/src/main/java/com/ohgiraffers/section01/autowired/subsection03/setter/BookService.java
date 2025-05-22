package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 📌 BookService 클래스
 * - 이 클래스는 비즈니스 로직을 처리하는 서비스 계층.
 * - @Service 어노테이션을 통해 "bookServiceSetter"라는 이름으로 스프링 컨테이너에 Bean으로 등록됨.
 */
@Service("bookServiceSetter")
public class BookService {

    /**
     * 📌 의존성 필드
     * - BookDAO 타입의 Bean이 여기에 주입됨 (setter 방식 사용)
     */
    private BookDAO bookDAO;

    /**
     * ✅ Setter 주입 메서드
     * - @Autowired 어노테이션이 붙은 setter 메서드를 통해 의존성 주입이 이루어짐.
     * - required = false 옵션은 해당 타입의 Bean이 없더라도 예외를 발생시키지 않음.
     */
    @Autowired(required = false)
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * 📘 전체 책 목록 조회
     * - DAO의 selectBookList 메서드를 호출해 모든 책 정보를 가져옴.
     */
    public List<BookDTO> selectAllBooks() {
        return bookDAO != null ? bookDAO.selectBookList() : null;
    }

    /**
     * 📗 특정 책 번호로 조회
     * - DAO의 selectOneBook 메서드를 호출해 해당 번호의 책 정보를 가져옴.
     */
    public BookDTO selectBookBySequence(int sequence) {
        return bookDAO != null ? bookDAO.selectOneBook(sequence) : null;
    }
}
