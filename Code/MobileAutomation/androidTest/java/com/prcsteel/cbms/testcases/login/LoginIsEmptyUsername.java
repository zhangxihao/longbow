package com.prcsteel.cbms.testcases.login;

import android.os.SystemClock;

import com.prcsteel.cbms.BasicTestCase;
import com.prcsteel.cbms.utils.PromptMessage.AssertMessage;
import com.prcsteel.cbms.utils.PromptMessage.ReturnMessage;
import com.prcsteel.cbms.utils.TestData.LoginData;

/**
 * Created by bob on 2015/9/14.
 * ---------------------------TestCase-----------------------------
 * step1: 不输入用户名--> 输入密码 -->点击登录按钮
 * expect1:提示“请输入用户名”
 *
 */
public class LoginIsEmptyUsername extends BasicTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testIsEmptyUsername(){
        uiHelper.getElementsLoginActivity().clearEdtUsernameAndPassword();
        uiHelper.getElementsLoginActivity().enterEdtPassword(LoginData.PASSWORD);
        uiHelper.getElementsLoginActivity().clickOnBtnLogin();

        uiHelper.getSolo().waitForDialogToOpen();
        System.out.println("断言之前");
        assertTrue(AssertMessage.ASSERT_FAILURE_TOAST_NOTFOUND, uiHelper.getSolo().searchText(ReturnMessage.USERNAME_IS_EMPTY, true));
        System.out.println("断言失败，程序不会执行到这里");
        SystemClock.sleep(1000);
    }
}
