//package com.ssg.sb01.controller;
//
//import com.ssg.sb01.dto.BoardDTO;
//import com.ssg.sb01.dto.PageRequestDTO;
//import com.ssg.sb01.dto.PageResponseDTO;
//import com.ssg.sb01.service.BoardService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//@RequestMapping("/board")
//@Log4j2
//@RequiredArgsConstructor
//public class BoardController {
//    private final BoardService boardService;
//
//    @GetMapping("/list")
//    public void list(PageRequestDTO pageRequestDTO, Model model) {
//        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
//        log.info(responseDTO);
//
//        model.addAttribute("responseDTO", responseDTO);
//    }
//
//    @GetMapping({"/read", "/modify"})
//    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model) {
//        BoardDTO boardDTO = boardService.getOne(bno);
//
//        model.addAttribute("dto", boardDTO);
//    }
//
//    @PostMapping("/modify")
//    public String modify(@Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        log.info("POST modify...!!!");
//
//        if (bindingResult.hasErrors()) {
//            log.info("has error...!");
//
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
//            redirectAttributes.addFlashAttribute("bno", boardDTO.getBno());
//
//            return "redirect:/board/modify";
//        }
//
//        boardService.update(boardDTO);
//
//        return "redirect:/board/list";
//    }
//
//    @PostMapping("/remove")
//    public String remove(Long bno) {
//        boardService.delete(bno);
//
//        return "redirect:/board/list";
//    }
//}
