package com.prcsteel.cbms;

import com.prcsteel.cbms.testcases.login.LoginCleanUsernameAndPassword;
import com.prcsteel.cbms.utils.TestData.LoginData;

/**
 * Created by bob on 2015/9/14.
 * 编写登入抽象类，继承BasicTestCase，其他需要登入操作的类继承此类自动实现登录功能
 *
 */
abstract public class BasicTestCaseWithLogin extends BasicTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        uiHelper.getElementsLoginActivity().clearEdtUsernameAndPassword();
        uiHelper.getElementsLoginActivity().doLoginWithAccount(new String[]{LoginData.USERNAME, LoginData.PASSWORD});
    }

}
