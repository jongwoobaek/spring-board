package com.ssg.sb01.repository;

import com.ssg.sb01.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//public interface ReplyRepository extends JpaRepository<Reply, Long> {
//    @Query("select r from Reply r where r.board.bno = :bno")
//    Page<Reply> listOfBoard(Long bno, Pageable pageable);
//}
