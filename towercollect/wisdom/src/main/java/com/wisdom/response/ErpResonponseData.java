package com.wisdom.response;

public class ErpResonponseData {
    public boolean success;
    public String code;
    public String description;

    public ErpResonponseData(boolean success,String code,String description){
        this.success = success;
        this.code = code;
        this.description = description;
    }
}
