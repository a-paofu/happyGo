package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Boolean success;

    private Integer code;

    private String message;

    private Object data;

    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }

    public static Result fail(Integer code,String message){
        return new Result(false,code,message,null);
    }

    public static Result success(){
        return new Result(true,200,"success",null);
    }

}
