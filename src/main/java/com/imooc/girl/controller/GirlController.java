package com.imooc.girl.controller;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.imooc.girl.utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    //LGG，一定要用slf4j
    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);

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

        logger.info("girList");
            return girlRepository.findAll();
    }


    /**
     * 添加一个女生
      * @param girl
     * @return
     */
    @PostMapping(value="/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        Result result=new Result();

        if (bindingResult.hasErrors()){


        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());

        Result success = ResultUtil.success(girlRepository.save(girl));

        return result;
        //return girlRepository.save(girl);
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

    @GetMapping(value="girls/getAge/{id}")
    public void getAge(@PathVariable("id") int id){
        girlService.getAge(id);
    }

}
