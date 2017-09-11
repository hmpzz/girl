package com.imooc.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //想要被别的类引用需要加这行注解
@ConfigurationProperties(prefix = "girl")  //此名表示使用配置文件中的girl部分
public class GirlProperties {

    private String cupSize;
    private int age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
