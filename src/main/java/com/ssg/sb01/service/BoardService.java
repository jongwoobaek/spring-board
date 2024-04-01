package com.ssg.sb01.service;

import com.ssg.sb01.dto.BoardDTO;
import com.ssg.sb01.dto.PageRequestDTO;
import com.ssg.sb01.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
    Long register(BoardDTO boardDTO);
    BoardDTO getOne(Long bno);
    void update(BoardDTO boardDTO);
    void delete(Long bno);
    List<BoardDTO> getList();
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
