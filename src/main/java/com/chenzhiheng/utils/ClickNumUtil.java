package com.chenzhiheng.utils;

public class ClickNumUtil {



    //点击翻倍值
    final int NORMAL_LUCK = 1;

    final int DOUBLE_LUCK = 2;

    final int TRIPLE_LUCK = 3;

    public static int getLuckClick(){
        int rand = RandDataUtil.getNum(1,100);
        int clickNum = 0;
        if(rand <= 80){
            clickNum = 1;
        }else if(rand <= 95){
            clickNum = 2;
        }else{
            clickNum = 3;
        }
        return clickNum;
    }
}
