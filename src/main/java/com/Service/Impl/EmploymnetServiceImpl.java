package com.Service.Impl;

import com.Dao.EmploymentMapper;
import com.Service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by gengtao on 2019/4/4.
 */
@Service
public class EmploymnetServiceImpl  implements EmploymentService {
    @Autowired
    private EmploymentMapper employmentMapper;

}
