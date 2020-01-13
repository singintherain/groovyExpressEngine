package com.lvsong;

import org.junit.Test;

/**
 * goovy脚本引擎测试类
 *
 * @author lvsong
 * @date 2020-01-13 2:55 PM
 **/
public class GroovyEngineTest {

    @Test
    public void evalTest() {
        GroovyEngine engine = new GroovyEngine();

        engine.eval();
    }

    @Test
    public void InputModifyCrossLevelFilterTest() {
        BizConditionContext conditionContext = new BizConditionContext();

        conditionContext.setItemType("fx");
        conditionContext.setOrderType("subOrder");
        conditionContext.setQuerySource("cdaf7529ae151acc521803ea338d95ec");
        conditionContext.getToolCodes().add("inputModifyPrice");

        BizActionContext actionContext = new BizActionContext();

        InputModifyCrossLevelFilter filter = new InputModifyCrossLevelFilter();
        filter.run(conditionContext, actionContext);

        System.out.println(" usedToolCodes:" + actionContext.getUseToolCodes());
        System.out.println(" excludeToolCodes:" + actionContext.getExcludeToolCodes());
        System.out.println(" calPlan:" + actionContext.getCalPlan());
    }
}
