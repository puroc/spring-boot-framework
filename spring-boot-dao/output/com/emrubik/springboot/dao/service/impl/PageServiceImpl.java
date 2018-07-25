package com.emrubik.springboot.dao.service.impl;

import com.emrubik.springboot.dao.entity.Page;
import com.emrubik.springboot.dao.mapper.PageMapper;
import com.emrubik.springboot.dao.service.IPageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author puroc123
 * @since 2018-07-03
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements IPageService {

}
