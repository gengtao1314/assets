package com.Controller;

import com.Dao.UserDao;
import com.Pojo.DataTableResult;
import com.Pojo.Result;
import com.Pojo.Student;
import com.Pojo.User;
import com.utils.BaseResponse;
import com.utils.ParamUtil;
import com.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    //跳转到添加企业信息页面
    @RequestMapping("company-list")
    public String toCompany(){
        return "company-list";
    }
    //跳转到新增企业信息页面
    @RequestMapping("company-add")
    public String companyAdd(){
        return "company-add";
    }
    //跳转到编辑企业信息页面
    @RequestMapping("company-edit")
    public String companyEdit(){
        return "company-edit";
    }

    @RequestMapping("student-list")
    public String studentList(){
        return "student-list";
    }
    @RequestMapping("student-add")
    public String studentAdd(){
        return "student-add";
    }
    @RequestMapping("student-edit")
    public String studentEdit(){
        return "student-edit";
    }

    @RequestMapping("user-list")
    public String userList(){
        return "user-list";
    }
    @RequestMapping("user-edit")
    public String userEdit(){
        return "user-edit";
    }
    @RequestMapping("user-add")
    public String userAdd(){
        return "user-add";
    }
    @RequestMapping("employment-list")
    public String employmentList(){
        return "employment-list";
    }
    @RequestMapping("employment-edit")
    public String employmentEdit(){
        return "employment-edit";
    }
    @RequestMapping("employment-add")
    public String employmentAdd(){
        return "employment-add";
    }

    @RequestMapping("logInfo")
    public String logInfo(){
        return "logInfo";
    }

    @RequestMapping("welcome")
    public String welcom(){
        return "welcome";
    }

    //分页查询
    @RequestMapping("/search")
    @ResponseBody
    public DataTableResult search(User user,int draw,  int start, int length) throws IllegalAccessException {
        Map<String,Object> map = new HashMap<>();
        ParamUtil<User> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(user, map);//将类转换为Map
        map.put("start",start);//设置从第几条数据开始查询
        map.put("length",length);//设置每页的数据的长度
        List<User> byMap = userDao.search(map);
        DataTableResult result = new DataTableResult();

        result.setRecordsTotal(userDao.countByMap(new HashMap<>()));//存放当前页的数量
        result.setSuccess(true);
        Map<String,Object> countMap = new HashMap<>();
        paramUtil.objectToMap(user, countMap);
        List<User> count = userDao.search(countMap);//获取满足条件的总数据数量
        result.setRecordsFiltered(count.size());
        result.setDraw(draw);

        result.setData(byMap);//存放数据
        return result;
    }

    //根据条件获取学生数量
    @RequestMapping("/count")
    @ResponseBody
    public BaseResponse count(User user) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<User> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(user, map);//将类转换为Map
        int count = userDao.countByMap(map);//检索，获取数量
        response.setResult(count);
        return response;
    }

    //更新学生信息
    @RequestMapping("/update")
    @ResponseBody
    public BaseResponse update(User user) throws IllegalAccessException, ParseException {
        BaseResponse response = new BaseResponse();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtils.isNotEmpty(user.getMyCreateTime())){
            user.setCreatetime(sdf.parse(user.getMyCreateTime()));
        }
        Map<String,Object> map = new HashMap<>();
        ParamUtil<User> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(user, map);//将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        userDao.batchUpdate(list);//批量更新
        return response;
    }

    //添加学生信息
    @RequestMapping("/add")
    @ResponseBody
    public BaseResponse add(User user) throws IllegalAccessException, ParseException {
        BaseResponse response = new BaseResponse();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtils.isNotEmpty(user.getMyCreateTime())){
            user.setCreatetime(sdf.parse(user.getMyCreateTime()));
        }
        user.setCreatetime(new Date());
        Map<String,Object> map = new HashMap<>();
        ParamUtil<User> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(user, map);//将类转换为Map
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        userDao.batchInsert(list);//批量增加
        return response;
    }

    //删除信息
    @RequestMapping("/delete")
    @ResponseBody
    public BaseResponse delete(User user) throws IllegalAccessException {
        BaseResponse response = new BaseResponse();
        Map<String,Object> map = new HashMap<>();
        ParamUtil<User> paramUtil = new ParamUtil<>();
        paramUtil.objectToMap(user, map);//将类转换为Map
        userDao.deleteByMap(map);//根据条件删除数据
        return response;
    }

    //跳转到用户注册页面
    @RequestMapping("regist")
    public String regist(){
        return "regist";
    }
}
