package hxy.hbao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class NiHaoController {
    @RequestMapping("/hello/nihao")
    public String nihao(){
        log.debug("print debug log.");
        log.debug("print debug log.");
        log.info("print info log11.");
        log.error("print error log11.");
        return "nihao!555";
    }
}
