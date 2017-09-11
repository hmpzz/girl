package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.GirlRepository;
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
}
