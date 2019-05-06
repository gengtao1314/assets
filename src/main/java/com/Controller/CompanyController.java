package com.Controller;

import com.Dao.CompanyMapper;
import com.Pojo.Company;
import com.Pojo.DataTableResult;
import com.Pojo.Result;
import com.Service.CompanyService;
import com.github.pagehelper.PageInfo;
import com.utils.BaseResponse;
import com.utils.Page;
import com.utils.ParamUtil;
import com.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 企业管理
 */
@RestController
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyMapper companyMapper;

    //分页查询，参数封装在Company类里
    @RequestMapping("/search")
    public DataTableResult search(Company company,int draw, int start, int length) throws IllegalAccessException {
        Map<String,Object> map = new HashMap<>();//实例化一个新的map
        ParamUtil<Company> paramUtil = new ParamUtil<>();//实例化paramUtil
        paramUtil.objectToMap(company, map);  //将类转换为Map
        map.put("start",start);  //设置从第几条数据开始查询
        map.put("length",length); //设置每页的数据的长度
        List<Company> byMap = companyMapper.search(map); //根据条件查询
        //定义一个类用于存放返回的结果
        DataTableResult result = new DataTableResult();//实例化DataTableResult

        //将数据封装在分页结果类里,存放当前页数量，总结构数量和数据，用于前端页面的分页显示
        result.setRecordsTotal(companyMapper.countByMap(new HashMap<>())); //存放当前页的数量
        result.setSuccess(true);//设置返回状态为true
        Map<String,Object> countMap = new HashMap<>();//实例化一个新的map
        paramUtil.objectToMap(company, countMap);//将类转换为Map
        List<Company> count = companyMapper.search(countMap);  //获取满足条件的总数据数量
        result.setRecordsFiltered(count.size());//设置满足条件的总数据数量
        result.setDraw(draw);//未用到

        result.setData(byMap); //存放数据
       return result; //返回数据
    }

    //不分页查询
    @RequestMapping("/list")
    public Result list() {
        Map<String,Object> map = new HashMap<>(); //定义一个map
        List<Company> byMap = companyMapper.search(map);
        return new ResultUtil<List<Company>>().setData(byMap); //查询所有数据
    }

    //根据条件获取检索数据的数量，参数封装在Company类里
    @RequestMapping("/count")
    public BaseResponse count(Company company) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Company> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(company, map);  //将类转换为Map
       int count = companyMapper.countByMap(map);  //检索，获取数量
        response.setResult(count);
        return response;
    }

    //更新数据，参数封装在Company类里
    @RequestMapping("/update")
    public BaseResponse update(Company company) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Company> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(company, map);//将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map); //将map放到list中
        companyMapper.batchUpdate(list); //批量更新
        return response;
    }

    //添加数据，参数封装在Company类里
    @RequestMapping("/add")
    public BaseResponse add(Company company) throws IllegalAccessException{
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Company> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(company, map); //将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);//将map放到list中
        companyMapper.batchInsert(list);//批量增加
        return response;
    }

    //删除数据，参数封装在Company类里
    @RequestMapping("/delete")
    public BaseResponse delete(Company company) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<Company> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(company, map); //将类转换为Map
        companyMapper.deleteByMap(map); //根据条件删除数据
        return response;
    }
}
