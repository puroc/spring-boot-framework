package com.emrubik.springboot.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.emrubik.springboot.domain.po.Project;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author puroc123
 * @since 2018-05-29
 */
public interface IProjectService extends IService<Project> {

    boolean deleteAllResouces(String projectId) throws Exception;

}
