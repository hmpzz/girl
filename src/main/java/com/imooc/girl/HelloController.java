package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController  //用WEB的方式访问类
public class HelloController {

    @Autowired //使用配置类需要加这行注解
    private GirlProperties girlproperties;


    @RequestMapping(value = "/say",method = RequestMethod.GET) //访问的目录，用GET的方式访问
    public String Say(@RequestParam(value = "id",required =false,defaultValue = "888") int id){
            return "ID:"+id;
//        return girlproperties.getCupSize();
    }
}
