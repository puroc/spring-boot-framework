package com.emrubik.springboot.domain.to.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseResp<T> {
    public static final String RESULT_SUCCESS = "1";
    public static final String RESULT_FAILED = "0";
    //    10开头的为机构相关结果码
    public static final String EXIST_SON_ORG = "10001";
    public static final String CAN_NOT_DELETE_ROOT_ORG = "10002";

    private String resultCode = RESULT_SUCCESS;
    private String message;
    private List<T> payloads = new ArrayList<T>();

    public void setPayLoad(T payload) {
        payloads.add(payload);
    }

    public void fail(String errorMsg) {
        this.setResultCode(RESULT_FAILED);
        this.setMessage(errorMsg);
    }

    public void fail(String errorCode, String errorMsg) {
        this.setResultCode(errorCode);
        this.setMessage(errorMsg);
    }
}
