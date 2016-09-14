package com.prcsteel.cbms.testcases.login;

import android.os.SystemClock;

import com.prcsteel.cbms.BasicTestCase;
import com.prcsteel.cbms.utils.PromptMessage.AssertMessage;
import com.prcsteel.cbms.utils.PromptMessage.ReturnMessage;
import com.prcsteel.cbms.utils.TestData.LoginData;

/**
 * Created by bob on 2015/9/14.
 * ---------------------------TestCase-----------------------------
 * step1: 输入用户名 testbuyer --> 不输入密码 -->点击登录按钮
 * expect1:提示“请输入密码”
 */
public class LoginIsEmptyPassword extends BasicTestCase{
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testIsEmptyPassword(){
        uiHelper.getElementsLoginActivity().clearEdtUsernameAndPassword();
        uiHelper.getElementsLoginActivity().enterEdtUsername(LoginData.USERNAME);
        uiHelper.getElementsLoginActivity().clickOnBtnLogin();

        uiHelper.getSolo().waitForDialogToOpen();
        assertTrue(AssertMessage.ASSERT_FAILURE_TOAST_NOTFOUND, uiHelper.getSolo().searchText(ReturnMessage.PASSWORD_IS_EMPTY, true));
        SystemClock.sleep(1000);

    }

}
