package com.Controller;

import com.Dao.LogMapper;
import com.Pojo.DataTableResult;
import com.Pojo.Log;
import com.Pojo.Student;
import com.utils.BaseResponse;
import com.utils.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志管理
 */
@RestController
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogMapper logMapper;

    //分页查询
    @RequestMapping("/search")
    public DataTableResult search(Log log,int draw, int start, int length) throws IllegalAccessException {
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Log> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(log, map);//将类转换为Map
        map.put("start",start);//设置从第几条数据开始查询
        map.put("length",length);//设置每页的数据的长度
        List<Log> byMap = logMapper.search(map);//根据条件查询
        //定义一个类用于存放返回的结果
        DataTableResult result = new DataTableResult();
        //将数据封装在分页结果类里,存放当前页数量，总结构数量和数据，用于前端页面的分页显示
        result.setData(byMap);//存放数据
        result.setRecordsTotal(logMapper.countByMap(new HashMap<>()));//存放当前页的数量
        result.setSuccess(true);
        Map<String,Object> countMap = new HashMap<>();
        paramUtil.objectToMap(log, countMap);
        List<Log> count = logMapper.search(countMap); //获取满足条件的总数据数量
        result.setRecordsFiltered(count.size());
        result.setDraw(draw);
        return result;
    }
    //根据条件获取检索数据的数量，参数封装在Log类里
    @RequestMapping("/count")
    public BaseResponse count(Log log) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Log> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(log, map);//将类转换为Map
        int count = logMapper.countByMap(map); //检索，获取数量
        response.setResult(count);
        return response;
    }
}
