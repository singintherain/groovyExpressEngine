script (
        conditionAnd (
                querySource() == 'cdaf7529ae151acc521803ea338d95ec',
                'inputModifyPrice' in toolCodes()
        ),

        {
            useToolCodes().addAll(['limitDiscount', 'inputModifyPrice', 'groupDiscount'])
            excludeToolCodes().addAll(['shopCoupon', 'itemCoupon'])
        }
)
