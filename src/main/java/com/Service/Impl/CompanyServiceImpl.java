package com.Service.Impl;

import com.Dao.CompanyMapper;
import com.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gengtao on 2019/4/4.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyMapper companyMapper;

}
