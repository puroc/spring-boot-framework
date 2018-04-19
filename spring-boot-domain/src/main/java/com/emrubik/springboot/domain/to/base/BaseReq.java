package com.emrubik.springboot.domain.to.base;

import lombok.Data;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
public class BaseReq<T> {

    @Valid
    private List<T> payloads = new ArrayList<T>();

    public void setPayLoad(T payload){
        payloads.add(payload);
    }
}
