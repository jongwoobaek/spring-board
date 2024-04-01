package com.ssg.sb01.repository;

import com.ssg.sb01.domain.Board;
import com.ssg.sb01.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        Long bno = 1L;

        Board board = Board.builder()
                .bno(bno)
                .build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("댓글4")
                .replyer("jongwoo1")
                .build();

        replyRepository.save(reply);
    }
}
