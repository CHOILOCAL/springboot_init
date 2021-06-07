package com.damdeeng.tour.test.controller;

//import io.swagger.annotations.Api;
import com.damdeeng.tour.exception.AppError;
import com.damdeeng.tour.exception.SampleException;
import com.damdeeng.tour.test.repository.AccountRepository;
import com.damdeeng.tour.test.service.AccountContext;
import com.damdeeng.tour.test.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RequiredArgsConstructor
@Controller
//@Api(value = "메인 테스트")
//@RequestMapping("/v1/api/main")
public class testController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

//    @RequestMapping(value="/", method = RequestMethod.GET)
    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "message");
        } else {
            model.addAttribute("message", "message " + principal.getName());
        }
        return "index";
    }

    @RequestMapping(value="/info", method = RequestMethod.GET)
    public String info(Model model, Principal principal) {
        model.addAttribute("message", "info " + principal.getName());
        return "info";
    }

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "dashboard " + principal.getName());
        AccountContext.setAccountThreadLocal(accountRepository.findByUsername(principal.getName()));
        accountService.dashboard();
        return "dashboard";
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "admin " + principal.getName());
        return "admin";
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public void hello(Model model) {
        model.addAttribute("message", "hello");
        log.info("클라이언트에서 요청한 /api/hello");
    }

    @GetMapping("/error")
    public void error() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError SampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("I don't Know");

        return appError;
    }
}
