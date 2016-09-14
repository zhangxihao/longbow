package com.prcsteel.cbms;

import com.prcsteel.cbms.elements.ElementsGestureLockActivity;
import com.prcsteel.cbms.elements.ElementsLoginActivity;
import com.prcsteel.cbms.elements.ElementsLogoutToast;
import com.prcsteel.cbms.elements.ElmentsMainActivity;
import com.robotium.solo.Solo;

/**
 * Created by bob on 2015/9/10.
 */
public class UIHelper {
    private Solo solo = null;
    private ElementsLoginActivity elementsLoginActivity;    // 登录界面实例
    private ElementsGestureLockActivity elementsGestureLockActivity;    //解锁
    private ElmentsMainActivity elmentsMainActivity;    // 主界面
    private ElementsLogoutToast elementsLogoutToast;    // 注销

    public UIHelper(Solo solo){
        this.solo = solo;
    }

    public Solo getSolo(){
        return solo;
    }

    //获取封装的 登录类实例
    public ElementsLoginActivity getElementsLoginActivity(){
        elementsLoginActivity = new ElementsLoginActivity(solo);
        return elementsLoginActivity;
    }

    //获取封装的 解锁类实例
    public ElementsGestureLockActivity getElementsGestureLockActivity(){
        elementsGestureLockActivity = new ElementsGestureLockActivity(solo);
        return elementsGestureLockActivity;
    }

    // 主界面
    public ElmentsMainActivity getElmentsMainActivity(){
        elmentsMainActivity = new ElmentsMainActivity(solo);
        return elmentsMainActivity;
    }

    public ElementsLogoutToast getElementsLogoutToast(){
        elementsLogoutToast = new ElementsLogoutToast(solo);
        return elementsLogoutToast;
    }


}
