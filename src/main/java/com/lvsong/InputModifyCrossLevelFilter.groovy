package com.lvsong

class InputModifyCrossLevelFilter extends AbstractEngineModuleRule {

    void run(Object inputContext, Object outputContext){
        //业务执行逻辑：可配置化
        super.run(inputContext, outputContext)

//        script (
//                conditionAnd (
//                        querySource() == 'cdaf7529ae151acc521803ea338d95ec',
//                        'inputModifyPrice' in toolCodes()
//                ),
//
//                {
//                    useToolCodes().addAll(['limitDiscount', 'inputModifyPrice', 'groupDiscount'])
//                    excludeToolCodes().addAll(['shopCoupon', 'itemCoupon'])
//                }
//        )

        rule (
                conditionOr (
                        querySource() == 'cdaf7529ae151acc521803ea338d95ec',
                        'inputModifyPrice' in toolCodes()
                ),

                {
                    useToolCodes().addAll(['limitDiscount', 'inputModifyPrice', 'groupDiscount'])
                    excludeToolCodes().addAll(['shopCoupon', 'itemCoupon'])
                }
        )

//        if (querySource() != 'cdaf7529ae151acc521803ea338d95ec') {
//            return
//        }
//
//        if (!toolCodes().contains('inputModifyPrice')) {
//            return
//        }
//
//        useToolCodes().with {
//            add('limitDiscount')
//            add('inputModifyPrice')
//            add('groupDiscount')
//        }
//
//        excludeToolCodes().with {
//            add('shopCoupon')
//            add('itemCoupon')
//        }
    }
}
