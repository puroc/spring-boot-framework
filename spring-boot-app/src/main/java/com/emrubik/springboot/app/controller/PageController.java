package com.emrubik.springboot.app.controller;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emrubik.springboot.app.service.IComponentService;
import com.emrubik.springboot.app.service.IPageService;
import com.emrubik.springboot.app.service.IProjectService;
import com.emrubik.springboot.common.util.BaseContextHandler;
import com.emrubik.springboot.dao.entity.Component;
import com.emrubik.springboot.dao.entity.Page;
import com.emrubik.springboot.dao.entity.Project;
import com.emrubik.springboot.domain.to.base.BaseReq;
import com.emrubik.springboot.domain.to.base.BaseResp;
import com.emrubik.springboot.domain.to.base.PageResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author puroc123
 * @since 2018-07-03
 */
@Controller
@Validated
@RequestMapping("/app")
public class PageController {

    public static final String VIEWS = "@/views";
    @Autowired
    private IPageService iPageService;

    @Autowired
    private IComponentService iComponentService;

    @GetMapping("/project/{projectId}/page/list")
    public ResponseEntity getPageListByPage(@PathVariable int projectId, @RequestParam int current, @RequestParam int size) {
        com.baomidou.mybatisplus.plugins.Page<Page> pages = iPageService.selectPage(new com.baomidou.mybatisplus.plugins.Page<Page>(current, size), new EntityWrapper<Page>().eq("project_id", projectId));
        PageResp<Page> baseResp = new PageResp<Page>();
        baseResp.setPayloads(pages.getRecords());
        baseResp.setTotalNum(pages.getTotal());
        return ResponseEntity.ok(baseResp);
    }

    @PostMapping("/project/{projectId}/page")
    public ResponseEntity addPage(@RequestBody @Validated BaseReq<Page> baseReq) {
        Page page = baseReq.getPayloads().get(0);
        page.setComponent(VIEWS + page.getUrl());
        page.setTimestamp(new Date());
        BaseResp resp = new BaseResp();
        boolean result = false;
        if (iPageService.selectOne(Condition.create().eq("name", page.getName())) != null) {
            resp.setMessage("name:" + page.getName() + "页面已经存在，不能添加名称相同的页面");
        } else {
            result = iPageService.insert(page);
        }
        if (!result) {
            if (StringUtils.isEmpty(resp.getMessage())) {
                resp.setMessage("name:" + page.getName() + " 添加页面失败");
            }
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/project/{projectId}/page/{pageId}")
    public ResponseEntity updatePage(@PathVariable String pageId, @RequestBody BaseReq<Page> baseReq) {
        Page page = baseReq.getPayloads().get(0);
        page.setComponent(VIEWS + page.getUrl());
        page.setTimestamp(new Date());
        boolean result = iPageService.update(page, new EntityWrapper<Page>().eq("id", pageId));
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.setMessage("pageId:" + pageId + "的页面不存在，修改失败");
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/project/{projectId}/page/{pageId}")
    public ResponseEntity deletePage(@PathVariable String pageId) throws Exception {
        boolean result = iPageService.deleteAllResouces(new ArrayList<String>() {{
            this.add(pageId);
        }});
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.setMessage("pageId:" + pageId + "的页面不存在，删除失败");
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/project/{projectId}/page")
    public ResponseEntity
    deletePageList(@RequestBody BaseReq<Page> baseReq) throws Exception {
        List<String> pageIdList = new ArrayList<String>();
        List<Page> pages = baseReq.getPayloads();
        int size = pages.size();
        for (int i = 0; i < size; i++) {
            pageIdList.add(pages.get(i).getId() + "");
        }
        BaseResp resp = new BaseResp();
        boolean result = iPageService.deleteAllResouces(pageIdList);
        if (!result) {
            resp.setMessage("删除失败,pageIdList:" + pageIdList);
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/project/{projectId}/page/{pageId}/components")
    public ResponseEntity savePageComponents(@PathVariable String projectId, @PathVariable String pageId, @RequestBody @Validated BaseReq<Component> baseReq) {
        List<Component> components = baseReq.getPayloads();
        //删除该界面的旧组件数据
        iComponentService.delete(new EntityWrapper<Component>().eq("page_id",pageId));
        //添加新组件数据
        boolean result = iComponentService.insertBatch(components);
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.setMessage("pageId:" + pageId + " 插入或更新组件失败");
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/project/{projectId}/page/{pageId}/components")
    public ResponseEntity loadComponent(@PathVariable String projectId, @PathVariable String pageId){
        List<Component> components = iComponentService.selectList(new EntityWrapper<Component>().eq("page_id", pageId));
        BaseResp resp = new BaseResp();
        resp.setPayloads(components);
        return ResponseEntity.ok(resp);
    }
}

