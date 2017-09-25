package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired//引用外部类
    private GirlRepository girlRepository;

    @Transactional //以下方法需要进行事务处理
    public void insertTwo(){
        Girl girlA=new Girl();
        girlA.setAge(27);
        girlA.setCupSize("B");
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setAge(27);
        girlB.setCupSize("F");
        girlRepository.save(girlB);
    }

    public void getAge(int id){
        Girl girl= girlRepository.findOne(id);
        int age=girl.getAge();
        if (age<10){
            //返回你还在上小学吧
        }else if (age>10 && age<16){
            //返回你可能在上实践
        }
    }
}
