package com.emrubik.springboot.app.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emrubik.springboot.app.service.IOrgService;
import com.emrubik.springboot.domain.po.Org;
import com.emrubik.springboot.domain.to.base.BaseReq;
import com.emrubik.springboot.domain.to.base.BaseResp;
import com.emrubik.springboot.domain.to.org.OrgTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author puroc123
 * @since 2018-03-20
 */
@Controller
@Validated
@RequestMapping("/idm")
public class OrgController {

    @Autowired
    private IOrgService orgService;

    @GetMapping("/org/{orgId}/tree")
    public ResponseEntity getOrgTree(@PathVariable @NotBlank String orgId) {
        OrgTree orgTree = orgService.getOrgTree(orgId);
        BaseResp<OrgTree> baseResp = new BaseResp<OrgTree>();
        baseResp.setPayLoad(orgTree);
        return ResponseEntity.ok(baseResp);
    }

    @GetMapping("/org/{orgId}")
    public ResponseEntity getOrg(@PathVariable @NotBlank String orgId) {
        Org org = orgService.selectOne(new EntityWrapper<Org>().eq("id", orgId));
        BaseResp<Org> baseResp = new BaseResp<Org>();
        baseResp.setPayLoad(org);
        return ResponseEntity.ok(baseResp);
    }

    @PostMapping("/org")
    public ResponseEntity insertOrg(@RequestBody @Validated BaseReq<Org> baseReq) {
        Org org = baseReq.getPayloads().get(0);
        org.setTimestamp(new Date());
        boolean result = orgService.insert(org);
        BaseResp baseResp = new BaseResp();
        if (!result) {
            baseResp.fail("机构" + org.getName() + "插入失败");
        }
        return ResponseEntity.ok(baseResp);
    }

    @PutMapping("/org/{orgId}")
    public ResponseEntity updateOrg(@RequestBody @Validated BaseReq<Org> baseReq,@PathVariable String orgId){
        Org org = baseReq.getPayloads().get(0);
        boolean result = orgService.update(org, new EntityWrapper<Org>().eq("id", orgId));
        BaseResp baseResp = new BaseResp();
        if (!result) {
            baseResp.fail("机构" + orgId + "更新失败");
        }
        return ResponseEntity.ok(baseResp);
    }

    @DeleteMapping("/org/{orgId}")
    public ResponseEntity deleteOrg(@PathVariable String orgId) {
        BaseResp baseResp = new BaseResp();
        //有下级机构时，不允许删除该机构
        List<Org> sonOrgList = orgService.selectList(new EntityWrapper<Org>().eq("parent_id", orgId));
        if (!sonOrgList.isEmpty()) {
            baseResp.fail(BaseResp.EXIST_SON_ORG,"该机构拥有下级机构，不允许删除");
            return ResponseEntity.ok(baseResp);
        }
        //该机构是根机构时，不允许删除该机构
        Org rootOrg = orgService.selectOne(new EntityWrapper<Org>().eq("id", orgId).eq("parent_id", 0));
        if (rootOrg != null) {
            baseResp.setMessage("不能删除企业根机构");
            baseResp.fail(BaseResp.CAN_NOT_DELETE_ROOT_ORG,"不能删除企业根机构");
            return ResponseEntity.ok(baseResp);
        }
        //删除机构
        boolean result = orgService.delete(new EntityWrapper<Org>().eq("id", orgId));
        if (!result) {
            baseResp.fail("删除机构：" + orgId + "失败");
        }
        return ResponseEntity.ok(baseResp);
    }

}

