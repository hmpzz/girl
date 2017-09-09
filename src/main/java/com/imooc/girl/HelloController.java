package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController  //用WEB的方式访问类
public class HelloController {

    @Autowired //使用配置类需要加这行注解
    private GirlProperties girlproperties;


    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.POST) //访问的目录，用GET的方式访问
    public String Say(){

        return girlproperties.getCupSize();
    }
}
