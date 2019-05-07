package com.Controller;

import com.Controller.Impl.TestControllerRequest;
import com.Controller.Impl.TestControllerResponse;
import com.Pojo.Test;
import com.Service.ITestService;
import com.gtaotao.framework.controller.IControllerResponse;
import com.gtaotao.framework.controller.SpringRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gengtao on 2019/5/7.
 */
@RestController
@RequestMapping("/test")
public class TestController extends SpringRestController {
    @Autowired
    private ITestService testService;

    @RequestMapping(path = "/list"
            , method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<IControllerResponse> list(@RequestBody TestControllerRequest request) throws IllegalAccessException {
        TestControllerResponse response = new TestControllerResponse();
        Map<String,Object> map = new HashMap<>();
        List<Test> list = testService.findByMap(map);
        response.setResult(list);
        return this.success(response);
    }

}
