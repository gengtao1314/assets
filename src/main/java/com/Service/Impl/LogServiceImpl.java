package com.Service.Impl;

import com.Dao.LogMapper;
import com.Pojo.Log;
import com.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

public class LogServiceImpl  implements LogService{
    @Autowired
    private LogMapper logMapper;

}
