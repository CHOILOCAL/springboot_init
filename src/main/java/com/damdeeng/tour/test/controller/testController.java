package com.damdeeng.tour.test.controller;

//import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@RequiredArgsConstructor
@Controller
//@Api(value = "메인 테스트")
//@RequestMapping("/v1/api/main")
public class testController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        log.info("******************");
        return "main";
    }

    @RequestMapping(value="/api/hello", method = RequestMethod.GET)
    public void hello() {
        log.info("클라이언트에서 요청한 /api/hello");
    }

}
