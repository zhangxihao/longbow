package com.prcsteel.cbms.elements;

import android.widget.TextView;

import com.prcsteel.cbms.utils.TestData.LogoutData;
import com.robotium.solo.Solo;

/**
 * Created by bob on 2015/10/9.
 */
public class ElementsLogoutToast extends AbstractBasicElement {

    private TextView mLogout;

    public ElementsLogoutToast(Solo solo){
        this.solo = solo;
        initViews();
    }

    @Override
    public void initViews() {
        mLogout = solo.getText(LogoutData.TEXTVIEW_LOGOUT, true);
    }

    // 注销登录
    public void clickOnLogout(){
//        mLogout.performClick();
        solo.clickOnView(mLogout);
        solo.clickOnText(LogoutData.BUTTON_CONFIRM, 1, false);
    }

}
