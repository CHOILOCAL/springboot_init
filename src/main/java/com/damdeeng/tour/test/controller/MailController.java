package com.damdeeng.tour.test.controller;

import com.damdeeng.tour.test.dto.mailDto;
import com.damdeeng.tour.test.service.mailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MailController {

    private final mailService mailService;

    @GetMapping("/mail")
    public String dispMail() {
        return "mail";
    }

    @PostMapping("/mail")
    public void execMail(mailDto mailDto) {
        mailService.mailSend(mailDto);
    }

}
