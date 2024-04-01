package com.ssg.sb01.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {

    @Operation(summary = "hello")
    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello...!!!");

        model.addAttribute("msg", "Hello World!");
    }

    @GetMapping("/ex/ex01")
    public void ex01(Model model) {
        List<String> list = Arrays.asList("Hello", "Spring boot", "!!!");

        model.addAttribute("list", list);
    }

    class SampleDTO {
        private String p1, p2, p3;

        public String getP1() {
            return p1;
        }

        public String getP2() {
            return p2;
        }

        public String getP3() {
            return p3;
        }
    }

    @GetMapping("/ex/ex02")
    public void ex02(Model model) {
        log.info("ex/ex02...!!!");

        List<String> list = IntStream.range(1, 10).mapToObj(i -> "Data" + i).toList();

        model.addAttribute("list", list);

        Map<String, String> map = new HashMap<>();

        map.put("A", "aaa");
        map.put("B", "bbb");

        model.addAttribute("map", map);

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.p1 = "value -- p1";
        sampleDTO.p2 = "value -- p2";
        sampleDTO.p3 = "value -- p3";

        model.addAttribute("dto", sampleDTO);
    }

    @GetMapping("/ex/ex03")
    public void ex03(Model model) {
        model.addAttribute("arr", new String[]{"aaa","bbb", "ccc"});
    }
}
