package com.zy.restful.controller;

import com.zy.restful.entiry.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/restful")
@CrossOrigin(origins = {"http://localhost:8080"})
//允许所有访问
//@CrossOrigin(origins = "*",maxAge = 3600)
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
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据新建成功\",\"id\":" + requestId + "}";
    }

    @PutMapping("/request")
    //@ResponseBody
    public String doPutRequest(Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    //@ResponseBody
    public String doDeleteRequest() {
        return "{\"message\":\"数据删除成功\"}";
    }

    //json序列化单条数据
    @GetMapping("/person")  //http://localhost/restful/person?id=1
    public Person findPersonById(Integer id) {
        Person person = new Person();
        if (id == 1) {
            person.setName("张三");
            person.setAge(66);
        } else if (id == 2) {
            person.setName("李四");
            person.setAge(18);
        }
        return person;
    }

    //json序列化多条数据
    @GetMapping("/persons")  // http://localhost/restful/persons
    public List<Person> findPersons() {
        List list = new ArrayList();
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(66);
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(22);
        p2.setBirthday(new Date());

        list.add(p1);
        list.add(p2);

        System.out.println("====================");
        return list;
    }

}
