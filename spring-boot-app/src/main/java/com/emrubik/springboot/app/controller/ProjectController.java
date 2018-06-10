package com.emrubik.springboot.app.controller;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emrubik.springboot.app.service.IProjectService;
import com.emrubik.springboot.common.util.BaseContextHandler;
import com.emrubik.springboot.dao.entity.Project;
import com.emrubik.springboot.domain.to.base.BaseReq;
import com.emrubik.springboot.domain.to.base.BaseResp;
import com.emrubik.springboot.domain.to.base.PageResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author puroc123
 * @since 2018-05-29
 */
@Controller
@Validated
@RequestMapping("/app/project")
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;

    @GetMapping("/list")
    public ResponseEntity getProjectList(@RequestParam int current, int size) {
        Page<Project> projectPage = iProjectService.selectPage(new Page<Project>(current, size), new EntityWrapper<Project>().eq("user_id", BaseContextHandler.getUserId()));
        PageResp<Project> baseResp = new PageResp<Project>();
        baseResp.setPayloads(projectPage.getRecords());
        baseResp.setTotalNum(projectPage.getTotal());
        return ResponseEntity.ok(baseResp);
    }

    @PostMapping
    public ResponseEntity addProject(@RequestBody @Validated BaseReq<Project> baseReq) {
        Project project = baseReq.getPayloads().get(0);
        project.setTimestamp(new Date());
        BaseResp resp = new BaseResp();
        boolean result = false;
        if (iProjectService.selectOne(Condition.create().eq("name", project.getName())) != null) {
            resp.setMessage("name:" + project.getName() + "工程已经存在，不能添加名称相同的工程");
        } else {
            result = iProjectService.insert(project);
        }
        if (!result) {
            if (StringUtils.isEmpty(resp.getMessage())) {
                resp.setMessage("name:" + project.getName() + " 添加工程失败");
            }
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity updateProject(@PathVariable String projectId, @RequestBody BaseReq<Project> baseReq) {
        Project project = baseReq.getPayloads().get(0);
        project.setTimestamp(new Date());
        boolean result = iProjectService.update(project, new EntityWrapper<Project>().eq("id", projectId));
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.setMessage("projectId:" + projectId + "的工程不存在，修改失败");
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity deleteProject(@PathVariable String projectId) {
        boolean result = iProjectService.delete(new EntityWrapper<Project>().eq("id", projectId));
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.setMessage("projectId:" + projectId + "的工程不存在，删除失败");
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping
    public ResponseEntity
    deleteProjectList(@RequestBody BaseReq<Project> baseReq) {
        List<String> projectIdList = new ArrayList<String>();
        List<Project> projects = baseReq.getPayloads();
        int size = projects.size();
        for (int i = 0; i < size; i++) {
            projectIdList.add(projects.get(i).getId() + "");
        }
        BaseResp resp = new BaseResp();
        boolean result = iProjectService.deleteBatchIds(projectIdList);
        if (!result) {
            resp.setMessage("删除失败,projectIdList:" + projectIdList);
            resp.setResultCode(BaseResp.RESULT_FAILED);
        }
        return ResponseEntity.ok(resp);
    }


}

