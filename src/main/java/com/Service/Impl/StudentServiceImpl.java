package com.Service.Impl;

import com.Dao.StudentMapper;
import com.Pojo.Student;
import com.Service.StudentService;
import com.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by gengtao on 2019/4/4.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

}
