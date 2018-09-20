package com.emrubik.springboot.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.emrubik.springboot.domain.po.Page;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author puroc123
 * @since 2018-07-03
 */
public interface IPageService extends IService<Page> {

    //删除页面以及页面包含的所有资源
     boolean deleteAllResouces(List<String> pageIds) throws Exception;

}
