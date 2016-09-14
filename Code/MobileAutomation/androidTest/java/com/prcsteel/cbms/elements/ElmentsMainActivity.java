package com.prcsteel.cbms.elements;

import android.widget.ImageButton;
import android.widget.TextView;

import com.prcsteel.cbms.utils.TestData.MainActivityData;
import com.robotium.solo.Solo;

/**
 * Created by bob on 2015/9/23.
 * 1. 代办事项界面
 */
public class ElmentsMainActivity extends AbstractBasicElement {

    private ImageButton mImgBtnMenu;    // 左侧菜单


    public ElmentsMainActivity(Solo solo) {
        this.solo = solo;
    }

    @Override
    public void initViews() {
//        mImgBtnMenu = (ImageButton) solo.getCurrentActivity().findViewById(MainActivityData.IMAGE_BUTTON_MENU);
//        mImgBtnMenu = (ImageButton) solo.getView("com.prcsteel.cbms:id/btn_titlebar_left");
    }

    // 点击菜单栏
    public void clickOnMenu(){
//        solo.clickOnView(mImgBtnMenu);
        solo.clickOnImageButton(MainActivityData.IMAGE_BUTTON_MENU);
    }

}
