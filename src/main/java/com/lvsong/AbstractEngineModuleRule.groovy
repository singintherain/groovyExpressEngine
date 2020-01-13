package com.lvsong

abstract class AbstractEngineModuleRule implements EngineGroovyModuleRule {
    def rule = {
        condtion, action -> if (condtion) action.call()
    }

    def conditionAnd = {
        Boolean... args ->
            for (int i = 0; i < args.length; i++) {
                if (!args[i]) {
                    return false;
                }
            }

            return true
    }

    def conditionOr = {
        Boolean... args ->
            for (int i = 0; i < args.length; i++) {
                if (args[i]) {
                    return true;
                }
            }

            return false
    }

    void run(Object condition, Object action) {
        querySource.delegate = condition
        toolCodes.delegate = condition
        useToolCodes.delegate = action
        excludeToolCodes.delegate = action
    }

    protected def querySource = { delegate.querySource }
    protected def toolCodes = { delegate.toolCodes }
    protected def useToolCodes = { delegate.useToolCodes }
    protected def excludeToolCodes = { delegate.excludeToolCodes }
}
