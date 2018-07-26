package com.emrubik.springboot.app.service;

import com.emrubik.springboot.dao.entity.Project;
import com.baomidou.mybatisplus.service.IService;

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
