package com.lvsong;

import groovy.lang.GroovyClassLoader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StringUtils;

/**
 * groovy引擎
 *
 * @author lvsong
 * @date 2020-01-13 2:53 PM
 **/
public class GroovyEngine {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroovyEngine.class);

    public void eval() {
        try {
            // 解析脚本文件
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            final String scriptPath = "classpath*:*.script.groovy";
            ConcurrentHashMap<String, String> scriptMap = readText(resolver, scriptPath);

            GroovyClassLoader classLoader = new GroovyClassLoader();
            String template = readGroovyTemplate();

            for (String key : scriptMap.keySet()) {
                String[] keyNames = StringUtils.split(key, ".");
                String scriptClassName = keyNames[0];
                String script = scriptMap.get(key);

                String fullScript = String.format(template, scriptClassName, script);
                Class<EngineGroovyModuleRule> aClass = classLoader.parseClass(fullScript);
                EngineGroovyModuleRule engineGroovyModuleRule = aClass.newInstance();

                BizConditionContext conditionContext = new BizConditionContext();

                conditionContext.setItemType("fx");
                conditionContext.setOrderType("subOrder");
                conditionContext.setQuerySource("cdaf7529ae151acc521803ea338d95ec");
                conditionContext.getToolCodes().add("inputModifyPrice");

                BizActionContext actionContext = new BizActionContext();
                engineGroovyModuleRule.run(conditionContext, actionContext);

                System.out.println(scriptClassName + " usedToolCodes:" + actionContext.getUseToolCodes());
                System.out.println(scriptClassName + " excludeToolCodes:" + actionContext.getExcludeToolCodes());
                System.out.println(scriptClassName + " calPlan:" + actionContext.getCalPlan());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String readGroovyTemplate() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        // 解析Groovy模板文件
        final String templatePath = "classpath*:*.groovy_class_template";
        ConcurrentHashMap<String, String> templateMap = readText(resolver, templatePath);

        return templateMap.get("common.groovy_class_template");
    }

    private ConcurrentHashMap<String,String> readText(ResourcePatternResolver resolver, String path) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String, String>();

        try {
            Resource[] resources = resolver.getResources(path);

            if (resources.length == 0) {
                return concurrentHashMap;
            }

            for (int i = 0; i < resources.length; i ++) {
                String fileName = resources[i].getFilename();
                InputStream input = resources[i].getInputStream();
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader br = new BufferedReader(reader);
                StringBuilder template = new StringBuilder();
                for (String line; (line = br.readLine()) != null; ) {
                    template.append(line).append("\n");
                }

                concurrentHashMap.put(fileName, template.toString());
            }
        } catch (Exception ex) {
            LOGGER.error("file parse fail", ex);
        }

        return concurrentHashMap;
    }
}
