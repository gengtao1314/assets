package com.Controller;

import com.utils.Page;
import com.Pojo.BaseDict;
import com.Pojo.Customer;
import com.Pojo.User;
import com.Service.BaseDictService;
import com.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 客户管理控制器类
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    // 依赖注入
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;
    // 客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    // 客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    // 客户级别
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    /**
     * 客户列表
     */
    @RequestMapping(value = "/list")
    public String list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer rows,
                       String name, String source, String industry,
                       String level, Model model) {
        // 条件查询所有客户
        Page<Customer> customers = customerService
                .findCustomerList(page, rows, name,
                        source, industry, level);
        model.addAttribute("page", customers);
        // 客户来源
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
        // 客户所属行业
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
        // 客户级别
        List<BaseDict> levelType = baseDictService
                .findBaseDictByTypeCode(LEVEL_TYPE);
        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("name", name);
        model.addAttribute("source", source);
        model.addAttribute("industry", industry);
        model.addAttribute("level", level);
        return "customer";
    }

    /**
     * 创建客户
     */
    @RequestMapping("/create")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session) {
        // 获取Session中的当前用户信息
        User user = (User) session.getAttribute("USER_SESSION");
        // 将当前用户id存储在客户对象中
        customer.setCreate_id(user.getId());
        // 创建Date对象
        Date date = new Date();
        // 得到一个Timestamp格式的时间，存入mysql中的时间格式“yyyy/MM/dd HH:mm:ss”
        Timestamp timeStamp = new Timestamp(date.getTime());
        customer.setCreatetime(timeStamp);
        // 执行Service层中的创建方法，返回的是受影响的行数
        int rows = customerService.createCustomer(customer);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    /**
     * 通过id获取客户信息
     */
    @RequestMapping("/getCustomerById")
    @ResponseBody
    public Customer getCustomerById(Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    /**
     * 更新客户
     */
    @RequestMapping("/update")
    @ResponseBody
    public String customerUpdate(Customer customer) {
        int rows = customerService.updateCustomer(customer);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    /**
     * 删除客户
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String customerDelete(Integer id) {
        int rows = customerService.deleteCustomer(id);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

}
