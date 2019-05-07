package com.Service.Impl;


import com.Dao.TestDao;
import com.Pojo.Test;
import com.Service.ITestService;
import com.gtaotao.framework.service.AbstractService;
import com.gtaotao.framework.dataaccess.mybatis.plugin.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gengtao on 2019/5/7.
 */
@Service
public class TestServiceImpl extends AbstractService<Test, Long> implements ITestService{
    @Autowired
    private TestDao testDao;


    @Override
    protected IBaseDao<Test, Long> getMyBatisDao() {
        return testDao;
    }
}
