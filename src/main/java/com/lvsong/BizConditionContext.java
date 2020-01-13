package com.lvsong;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务条件上下文
 *
 * @author lvsong
 * @date 2020-01-13 2:53 PM
 **/
public class BizConditionContext {

    /**
     * 商品类型
     */
    private String itemType;

    /**
     * 当前的营销工具列表
     */
    private List<String> toolCodes = new ArrayList<String>();

    /**
     * 交易来源
     */
    private String querySource;

    /**
     * 查询页面
     */
    private String queryPage;

    /**
     * 未选择的营销工具
     */
    private String noSelectToolCode;

    /**
     * 订单类型
     */
    private String orderType;

    public String getNoSelectToolCode() {
        return noSelectToolCode;
    }

    public void setNoSelectToolCode(String noSelectToolCode) {
        this.noSelectToolCode = noSelectToolCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public List<String> getToolCodes() {
        return toolCodes;
    }

    public void setToolCodes(List<String> toolCodes) {
        this.toolCodes = toolCodes;
    }

    public String getQuerySource() {
        return querySource;
    }

    public void setQuerySource(String querySource) {
        this.querySource = querySource;
    }

    public String getQueryPage() {
        return queryPage;
    }

    public void setQueryPage(String queryPage) {
        this.queryPage = queryPage;
    }
}
