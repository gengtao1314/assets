package com.Controller;

import com.Dao.StudentMapper;
import com.Pojo.DataTableResult;
import com.Pojo.Result;
import com.Pojo.Student;
import com.utils.BaseResponse;
import com.utils.ParamUtil;
import com.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 学生信息管理
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    //分页查询
    @RequestMapping("/search")
    public DataTableResult search(Student student,int draw, int start, int length) throws IllegalAccessException {
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Student> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(student, map);//将类转换为Map
        map.put("start",start);//设置从第几条数据开始查询
        map.put("length",length);//设置每页的数据的长度
        List<Student> byMap = studentMapper.search(map);//根据条件查询
        //定义一个类用于存放返回的结果
        DataTableResult result = new DataTableResult();
        //将数据封装在分页结果类里,存放当前页数量，总结构数量和数据，用于前端页面的分页显示
        result.setRecordsTotal(studentMapper.countByMap(new HashMap<>()));//存放当前页的数量
        result.setSuccess(true);
        Map<String,Object> countMap = new HashMap<>();
        paramUtil.objectToMap(student, countMap);
        List<Student> count = studentMapper.search(countMap);//获取满足条件的总数据数量
        result.setRecordsFiltered(count.size());
        result.setDraw(draw);

        result.setData(byMap);//存放数据
        return result;//返回数据
    }

    //不分页查询
    @RequestMapping("/list")
    public Result list(){
        Map<String,Object> map = new HashMap<>();
        List<Student> byMap = studentMapper.search(map);//查询所有数据
        return new ResultUtil<List<Student>>().setData(byMap);
    }

    //根据条件获取检索数据的数量
    @RequestMapping("/count")
    public BaseResponse count(Student student) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Student> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(student, map);//将类转换为Map
        int count = studentMapper.countByMap(map);//检索，获取数量
        response.setResult(count);
        return response;
    }

    //更新数据
    @RequestMapping("/update")
    public BaseResponse update(Student student) throws IllegalAccessException, ParseException {
        BaseResponse response = new BaseResponse();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtils.isNotEmpty(student.getMyBirthday())){
            student.setBirthday(sdf.parse(student.getMyBirthday()));
        }
        if(StringUtils.isNotEmpty(student.getMyAdmissionTime())){
            student.setAdmissionTime(sdf.parse(student.getMyAdmissionTime()));
        }
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Student> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(student, map);//将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);//将map放到list中
        studentMapper.batchUpdate(list);//批量更新
        return response;
    }

    //添加数据
    @RequestMapping("/add")
    public BaseResponse add(Student student) throws IllegalAccessException, ParseException {
        BaseResponse response = new BaseResponse();
        //将字符串转为日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtils.isNotEmpty(student.getMyBirthday())){ //如果出生日期不为空
            student.setBirthday(sdf.parse(student.getMyBirthday()));
        }
        if(StringUtils.isNotEmpty(student.getMyAdmissionTime())){
            student.setAdmissionTime(sdf.parse(student.getMyAdmissionTime()));
        }
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Student> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(student, map);//将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);//将map放到list中
        studentMapper.batchInsert(list);//批量增加
        return response;
    }

    //删除数据
    @RequestMapping("/delete")
    public BaseResponse delete(Student student) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Student> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(student, map);//将类转换为Map
        studentMapper.deleteByMap(map);//根据条件删除数据
        return response;
    }
}
