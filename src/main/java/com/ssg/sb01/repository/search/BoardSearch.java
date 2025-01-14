package com.ssg.sb01.repository.search;

import com.ssg.sb01.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch { // 단순한 페이지 처리 기능
    Page<Board> search1(Pageable pageable);
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}
