package com.emrubik.springboot.domain.to.org;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddOrgReq {

    //添加的机构名称
    @NotBlank
    private String label;
}
