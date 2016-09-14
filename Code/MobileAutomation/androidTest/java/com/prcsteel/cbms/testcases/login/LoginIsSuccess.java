package com.prcsteel.cbms.testcases.login;

import android.util.Log;

import com.prcsteel.cbms.BasicTestCaseWithLogin;
import com.prcsteel.cbms.utils.PromptMessage.AssertMessage;

import junit.framework.Assert;

/**
 * Created by bob on 2015/9/22.
 */
public class LoginIsSuccess extends BasicTestCaseWithLogin {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testLoginIsSuccess(){

//        if (!PreferencesUtils.getBoolean(LoginActivity.this, PreferenceConstants.IS_LOCKKEY_SET + PreferencesUtils.getString(mApplication, PreferenceConstants.USERNAME))) {
//
//        } else {
//
//        }
        /**
         * 这里点击登录有2种情况
         * 1. 已经设置过手势密码登录则直接进入到代办事项
         * 2. 没有设置手势密码登录则进入到设置手势密码页面
         */
        String mCurrentActivityName = uiHelper.getSolo().getCurrentActivity().getLocalClassName();

        if (!(mCurrentActivityName.equals("activity.MainActivity") || mCurrentActivityName.equals("widget.gesturelock.EditLockActivity"))){
            Log.i("sdd", "没有进入到了主界面或者解锁界面");
            Assert.fail(AssertMessage.ASSERT_FAILURE_ACTIVIT_NOTFOUND);
        }else {
//            assertTrue(AssertMessage.ASSERT_FAILURE_ACTIVIT_NOTFOUND, uiHelper.getElementsGestureLockActivity().getTvGestureLock().isShown());
            Log.i("sdd", "已经进入到了主界面或者解锁界面");
            assertTrue(true);
        }

    }
}
