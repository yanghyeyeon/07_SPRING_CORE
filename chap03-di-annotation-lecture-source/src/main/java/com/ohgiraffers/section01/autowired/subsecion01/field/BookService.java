package com.ohgiraffers.section01.autowired.subsecion01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service : @Component의 세분화 어노테이션의 한 종류로 Service 계층에서 사용한다.
@Service("bookServiceField")
public class BookService {

    // BookDAO 타입의 Bean 객테를 이 프로퍼티에 자동으로 주입해준다.
    @Autowired
    private BookDAO bookDAO;

    // 도서 목록 전체 조회
    public List<BookDTO> selectAllBooks() {

        return bookDAO.selectBookList();
    }

    // 도서 번호로 도서 조회
    public BookDTO searchBookBySequence(int sequence){

        return  bookDAO.selectOneBook(sequence);
    }
}
