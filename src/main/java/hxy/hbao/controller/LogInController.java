package hxy.hbao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogInController {

    @RequestMapping("/login/{name}")
    public String logIn(@PathVariable String name) {

        if(!name.equals("hao")) {
            return  "faile";
        }
        return "succeed";
    }
}
