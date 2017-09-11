package com.imooc.girl.controller;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.GirlRepository;
import com.imooc.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value="/girls")
    public List<Girl> girlList(){
            return girlRepository.findAll();
    }


    /**
     * 添加一个女生
      * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value="/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") int age){
        Girl girl=new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 返回某个ID值的女生的信息
     * @param id
     * @return
     */
    @GetMapping(value="/girls/{id}")
    public Girl girlFoundOne(@PathVariable("id") int id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") int id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") int age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") int id){
        girlRepository.delete(id);
    }


    @GetMapping(value="/girls/age/{age}")
    public List<Girl> grilListByAge(@PathVariable("age") int age){
            return girlRepository.findByAge(age);
    }


    @PostMapping(value="/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

}
