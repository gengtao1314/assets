package com.Pojo;


import com.enums.TestStatus;
import com.gtaotao.framework.dic.DictionaryStorage;
import com.gtaotao.framework.entity.BaseEntity;

/**
 * Created by gengtao on 2019/5/7.
 */
public class Test extends BaseEntity {
    String test;

    String testStatus;

    String testStatusName;

    public String getTestStatusName() {
        return DictionaryStorage.get(TestStatus.class.getName(), this.getTestStatus()).getName();
    }

    public void setTestStatusName(String testStatusName) {
        this.testStatusName = testStatusName;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
