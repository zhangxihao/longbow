package com.prcsteel.cbms.testcases.login;

import android.os.SystemClock;
import android.util.Log;

import com.prcsteel.cbms.BasicTestCase;
import com.prcsteel.cbms.utils.PromptMessage.AssertMessage;

/**
 * Created by bob on 2015/9/14.
 * 测试点击“X”清除用户名密码功能
 */
public class LoginCleanUsernameAndPassword extends BasicTestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testCleanUsernameAndPassword(){

        uiHelper.getElementsLoginActivity().clearEdtUsernameAndPassword();

        String getHintUsername = (String)uiHelper.getElementsLoginActivity().getEdtUsername().getHint();
        String getHintPassword = (String)uiHelper.getElementsLoginActivity().getEdtPassword().getHint();

        uiHelper.getElementsLoginActivity().enterEdtUsername("123");    // 一次性数据
        uiHelper.getElementsLoginActivity().enterEdtPassword("123");

        uiHelper.getElementsLoginActivity().clickOnBtnClearUsername();
        uiHelper.getElementsLoginActivity().clickOnBtnClearPassword();

        String getUsername = uiHelper.getElementsLoginActivity().getEdtUsername().getText().toString();
        String getPassword = uiHelper.getElementsLoginActivity().getEdtPassword().getText().toString();

        assertFalse(AssertMessage.ASSERT_FAILURE_TOAST_NOTFOUND, getHintUsername.equals(getUsername));     // 结果为false通过
        assertFalse(AssertMessage.ASSERT_FAILURE_TOAST_NOTFOUND, getHintPassword.equals(getPassword));
//        Log.i("sdd", "测试打印 infomation 日志");
//        Log.d("sdd", "测试打印 debug 日志");
//        Log.e("sdd", "测试打印 error 日志");
//        Log.w("sdd", "测试打印 warning 日志");
//        Log.v("sdd", "测试打印 verbose 日志");

        SystemClock.sleep(3000);
    }

}
