package hxy.hbao.controller;


import hxy.hbao.domain.UserInfo;

import hxy.hbao.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

@RestController
@Slf4j

public class HelloController {

    @Resource(name="userServiceImpl")
    private UserService userService;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("/send/{id}/{input}")
    public String sendMsg(@PathVariable String id,@PathVariable String input){

        System.out.println("kafkaconfig ------------------------send");
        kafkaTemplate.send("dcTop3", id+input);
        System.out.println("kafkaconfig ------------------------send end");
        return "success";
    }
    @KafkaListener(topics = "dcTop3")
   // @KafkaListener(id = "demo", topics = "dcTop3")

    public void getKafkaData(String data) {

        System.out.println("kafkaconfig =listen======="+data);
    }

    @RequestMapping("hello")
    public String hello() {
        UserInfo user = new UserInfo("王三", 22, "2222");
        userService.save(user);
        log.info("hello");
        return "hello!555";
    }

    @GetMapping("/allusers")
    @ResponseStatus(HttpStatus.OK)
    public Object getUsers() {

        return userService.findAll();
    }
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserInfo user){

        userService.save(user);


    }
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id) {

        if (null == id) {
            return null;
        }


        UserInfo userInfo = userService.get(Integer.valueOf(id));

        return userInfo;
    }
}

