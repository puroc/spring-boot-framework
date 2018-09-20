package com.emrubik.springboot.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emrubik.springboot.app.service.IPageService;
import com.emrubik.springboot.app.service.IProjectService;
import com.emrubik.springboot.dao.mapper.ProjectMapper;
import com.emrubik.springboot.domain.po.Page;
import com.emrubik.springboot.domain.po.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author puroc123
 * @since 2018-05-29
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Autowired
    private IPageService iPageService;

    @Override
    public boolean deleteAllResouces(String projectId) throws Exception {
        //删除工程下所有的页面及页面包含的资源
        List<Page> pages = iPageService.selectList(new EntityWrapper<Page>().eq("project_id", projectId));
        List<String> pageIdList = new ArrayList<String>();
        for (Page page : pages) {
            pageIdList.add(page.getId()+"");
        }
        return iPageService.deleteAllResouces(pageIdList);
    }
}
