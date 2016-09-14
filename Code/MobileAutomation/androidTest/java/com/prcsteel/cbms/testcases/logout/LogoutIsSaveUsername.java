package com.prcsteel.cbms.testcases.logout;

import com.prcsteel.cbms.BasicTestCaseWithLogin;
import com.prcsteel.cbms.activity.LoginActivity;
import com.prcsteel.cbms.utils.PromptMessage.AssertMessage;
import com.prcsteel.cbms.utils.TestData.LoginData;

import junit.framework.Assert;

/**
 * Created by bob on 2015/9/14.
 * 1. 验证注销之后保存用户名
 * 2. 手势密码验证失败三次返回登录页面，并且保存原用户名
 */
public class LogoutIsSaveUsername extends BasicTestCaseWithLogin {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    // 测试退出后是否保存了用户名
    public void testLogoutIsSaveUsername(){

        uiHelper.getElmentsMainActivity().clickOnMenu();
        uiHelper.getElementsLogoutToast().clickOnLogout();  //注销

        uiHelper.getSolo().waitForActivity(LoginActivity.class, 3000);
        String mUsername = uiHelper.getElementsLoginActivity().getEdtUsername().getText().toString();
        Assert.assertEquals(AssertMessage.ASSERT_STRING_EXPECT_IS_ACTUAL, LoginData.USERNAME, mUsername);
    }
}
