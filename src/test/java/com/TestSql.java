package com;


import com.Pojo.BaseDict;
import com.Pojo.Permission;
import com.Pojo.User;
import com.Service.BaseDictService;
import com.Service.ShiroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestSql {
    @Autowired
    private ShiroService shiroService;

    @Value("${customer.from.type}")
    private String FROM_TYPE;
    @Autowired
    private BaseDictService baseDictService;
    @Test
    public void Test1() {
        try {
            String usercode = "123";
            String password = "123";
            User user = shiroService.getUserByUserName(usercode);
            System.out.println(user.getName());

            List<Permission> ss = shiroService.getPermissionsByUser(user);

            System.out.println(ss.get(0).toString());

            System.out.println(ss.get(1).toString());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("ok");
    }

    @Test
            public void test2()
    {

        List<BaseDict> fromType = baseDictService.findBaseDictByTypeCode(FROM_TYPE);

        System.out.println(FROM_TYPE.toString());


    }

}

