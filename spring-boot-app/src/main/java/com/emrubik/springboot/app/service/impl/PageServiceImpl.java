package com.emrubik.springboot.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emrubik.springboot.app.service.IComponentService;
import com.emrubik.springboot.app.service.IPageService;
import com.emrubik.springboot.dao.mapper.PageMapper;
import com.emrubik.springboot.domain.po.Component;
import com.emrubik.springboot.domain.po.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author puroc123
 * @since 2018-07-03
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements IPageService {

    @Autowired
    private IPageService iPageService;

    @Autowired
    private IComponentService iComponentService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteAllResouces(List<String> pageIds) throws Exception {
        for (String pageId : pageIds) {
            //删除页面包含的组件
            iComponentService.delete(new EntityWrapper<Component>().eq("page_id", pageId));
        }
        //删除页面
        iPageService.deleteBatchIds(pageIds);
        return false;
    }
}
