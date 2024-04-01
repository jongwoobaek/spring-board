package com.ssg.sb01.repository;

import com.ssg.sb01.domain.Board;
import com.ssg.sb01.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}
// JpaRepository 인테페이스를 상속하는 인터페이스인 BoardRepository 선엄만으로 CRUD와 페이징 처리 완료