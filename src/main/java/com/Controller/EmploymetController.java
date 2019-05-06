package com.Controller;

import com.Dao.EmploymentMapper;
import com.Pojo.DataTableResult;
import com.Pojo.Employment;
import com.Pojo.Student;
import com.utils.BaseResponse;
import com.utils.ParamUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 就业信息管理
 */
@RestController
@RequestMapping("/employment")
public class EmploymetController {
    @Autowired
    private EmploymentMapper employmentMapper;

    //分页查询，参数封装在Employment类里
    @RequestMapping("/search")
    public DataTableResult search(Employment employment, int draw, int start, int length) throws IllegalAccessException {
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Employment> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(employment, map);//将类转换为Map
        map.put("start",start);//设置从第几条数据开始查询
        map.put("length",length);//设置每页的数据的长度
        List<Employment> byMap = employmentMapper.search(map);//根据条件查询
        //定义一个类用于存放返回的结果
        DataTableResult result = new DataTableResult();

        //将数据封装在分页结果类里,存放当前页数量，总结构数量和数据，用于前端页面的分页显示
        result.setRecordsTotal(employmentMapper.countByMap(new HashMap<>()));//存放当前页的数量
        result.setSuccess(true);
        Map<String,Object> countMap = new HashMap<>();
        paramUtil.objectToMap(employment, countMap);
        List<Employment> count = employmentMapper.search(countMap);//获取满足条件的总数据数量
        result.setRecordsFiltered(count.size());
        result.setDraw(draw);

        result.setData(byMap);
        return result;
    }
    //根据条件获取检索数据的数量，参数封装在Employment类里
    @RequestMapping("/count")
    public BaseResponse count(Employment employment) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();//定义一个map
        ParamUtil<Employment> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(employment, map);//将类转换为Map
        int count = employmentMapper.countByMap(map);//检索，获取数量
        response.setResult(count);
        return response;
    }
    //更新数据，参数封装在Employment类里
    @RequestMapping("/update")
    public BaseResponse update(Employment employment) throws IllegalAccessException, ParseException {
        BaseResponse response = new BaseResponse();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtils.isNotEmpty(employment.getMyEntryTime())){
            employment.setEntryTime(sdf.parse(employment.getMyEntryTime()));
        }
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Employment> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(employment, map);//将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);//将map放到list中
        employmentMapper.batchUpdate(list);//批量更新
        return response;
    }

    //添加数据，参数封装在Employment类里
    @RequestMapping("/add")
    public BaseResponse add(Employment employment) throws IllegalAccessException, ParseException {
        BaseResponse response = new BaseResponse();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtils.isNotEmpty(employment.getMyEntryTime())){
            employment.setEntryTime(sdf.parse(employment.getMyEntryTime()));
        }
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Employment> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(employment, map);//将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);//将map放到list中
        employmentMapper.batchInsert(list);//批量增加
        return response;
    }

    //删除数据，参数封装在Employment类里
    @RequestMapping("/delete")
    public BaseResponse delete(Employment employment) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Employment> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(employment, map);//将类转换为Map
        employmentMapper.deleteByMap(map); //根据条件删除数据
        return response;
    }
}
