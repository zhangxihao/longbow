package com.prcsteel.cbms.elements;

import com.robotium.solo.Solo;

/**
 * Created by bob on 2015/9/11.
 * 1. 使用模板模式规定步骤
 */
public abstract class AbstractBasicElement implements InterfaceBasicElement {
    protected Solo solo = null;

    // 定义执行步骤，提供给客户端调用
    public void template(){
        this.initViews();
//        this.operatorView();
    }
    @Override
    public abstract void initViews();   // step1：获取所有当前Activity的所有view

//    public abstract void operatorView();    // step2: 操作控件的动作

}
