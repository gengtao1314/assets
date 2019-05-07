package com.Dao;

import com.Pojo.Test;
import com.gtaotao.framework.dataaccess.mybatis.plugin.IBaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/10/9.
 */
@Repository
public interface TestDao extends IBaseDao<Test, Long>{
}
