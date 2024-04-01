package com.ssg.sb01.service;

import com.ssg.sb01.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    // boardService 객체 주입이 완료되었는지 테스트
    @Test
    public void testBoardServiceAutowired() {
        // boardService가 null이 아닌지 확인
        Assertions.assertThat(boardService).isNotNull();
    }

    @Test
    public void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("title")
                .content("content")
                .writer("writer")
                .build();

        boardService.register(boardDTO);
    }

    @Test
    public void testGetOne() {
        Long bno = 1L;

        BoardDTO boardDTO = boardService.getOne(bno);
        log.info(boardDTO);
    }

    @Test
    public void testUpdate() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(1L)
                .title("new title")
                .content("new content")
                .writer("jongwoo")
                .build();

        boardService.update(boardDTO);
    }

    @Test
    public void testDelete() {
        boardService.delete(2L);

        Assertions.assertThat(boardService.getOne(2L)).isNull();
    }

    @Test
    public void testGetList() {
        List<BoardDTO> boardDTOList = boardService.getList();

        boardDTOList.forEach(log::info);
    }
}
