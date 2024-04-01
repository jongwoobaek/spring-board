package com.ssg.sb01.service;

import com.ssg.sb01.domain.Board;
import com.ssg.sb01.dto.BoardDTO;
import com.ssg.sb01.dto.PageRequestDTO;
import com.ssg.sb01.dto.PageResponseDTO;
import com.ssg.sb01.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor // 의존성 주입 - 생성자 주입
@Transactional // 스프링은 해당 객체를 감싸는 별도의 클래스를 생성한다. 반드시 db작업 서비스 객체인 트렌젝션 처리를 위해 해당 어노테이션을 사용한다.
public class BoardServiceImpl implements BoardService {
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();

        return bno;
    }

    @Override
    public BoardDTO getOne(Long bno) {
        Optional<Board> board = boardRepository.findById(bno);

        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);

        return boardDTO;
    }

    @Override
    public void update(BoardDTO boardDTO) {
        Long bno = boardDTO.getBno();

        Optional<Board> result = boardRepository.findById(bno); //select
        Board board = result.orElseThrow(); //select
        board.change(boardDTO.getTitle(), boardDTO.getContent());

        boardRepository.save(board);
    }

    @Override
    public void delete(Long bno) {
        boardRepository.deleteById(bno);
    }

    @Override
    public List<BoardDTO> getList() {
        List<BoardDTO> boardList = boardRepository.findAll().stream().map(board -> modelMapper.map(board, BoardDTO.class)).toList();

        return boardList;
    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");

        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);

        List<BoardDTO> dtoList = result.getContent().stream()
                .map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());


        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();

    }
}
