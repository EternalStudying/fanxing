package com.fanxing.common.exception;

import com.fanxing.model.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class FxException extends RuntimeException{

    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public FxException(ResultCodeEnum resultCodeEnum){
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }


}
