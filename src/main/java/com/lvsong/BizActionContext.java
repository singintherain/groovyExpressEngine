package com.lvsong;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务操作信息
 *
 * @author lvsong
 * @date 2020-01-13 2:52 PM
 **/
public class BizActionContext {
    /**
     * 可使用的优惠工具集合
     */
    private List<String> useToolCodes = new ArrayList<String>();

    /**
     * 需要排除的优惠工具集合
     */
    private List<String> excludeToolCodes = new ArrayList<String>();

    /**
     * 查询计划
     */
    private String calPlan;

    public List<String> getUseToolCodes() {
        return useToolCodes;
    }

    public void setUseToolCodes(List<String> useToolCodes) {
        this.useToolCodes = useToolCodes;
    }

    public List<String> getExcludeToolCodes() {
        return excludeToolCodes;
    }

    public void setExcludeToolCodes(List<String> excludeToolCodes) {
        this.excludeToolCodes = excludeToolCodes;
    }

    public String getCalPlan() {
        return calPlan;
    }

    public void setCalPlan(String calPlan) {
        this.calPlan = calPlan;
    }
}
