package com.imooc.girl.exception;

import com.imooc.girl.enums.ResultEnum;

public class GirlException  extends RuntimeException{
    private int code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
