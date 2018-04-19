package com.emrubik.springboot.domain.to.base;

import lombok.Data;

@Data
public class PageResp<T> extends BaseResp<T> {

    private int totalNum;
}
