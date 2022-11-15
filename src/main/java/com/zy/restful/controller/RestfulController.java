package com.zy.restful.controller;

import com.zy.restful.entiry.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restful")
public class RestfulController {
    @GetMapping("/request")
    //@ResponseBody
    public String doGetRequest() {
        return "{\"message\":\"返回查询结果\"}";
    }

    //POST /restful/request/100
    @PostMapping("/request/{rid}")
   // @ResponseBody
    public String doPostRequest(@PathVariable("rid") Integer requestId, Person person) {
        System.out.println(person.getName()+":"+person.getAge());
        return "{\"message\":\"数据新建成功\",\"id\":"+requestId +"}";
    }

    @PutMapping("/request")
    //@ResponseBody
    public String doPutRequest(Person person) {
        System.out.println(person.getName()+":"+person.getAge());
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    //@ResponseBody
    public String doDeleteRequest() {
        return "{\"message\":\"数据删除成功\"}";
    }
}
