package com.prcsteel.cbms.testsuite;

import com.prcsteel.cbms.testcases.login.LoginCleanUsernameAndPassword;
import com.prcsteel.cbms.testcases.login.LoginIsEmptyPassword;
import com.prcsteel.cbms.testcases.login.LoginIsEmptyUsername;
import com.prcsteel.cbms.testcases.login.LoginIsEmptyUsernameAndPassword;
import com.prcsteel.cbms.testcases.login.LoginIsFailure;
import com.prcsteel.cbms.testcases.login.LoginIsSuccess;
import com.prcsteel.cbms.testcases.logout.Logout;
import com.prcsteel.cbms.testcases.logout.LogoutIsSaveUsername;

import junit.framework.TestSuite;

/**
 * Created by bob on 2015/9/23.
 * 1. 登入、登出测试用例集
 */
public class SuiteLogin {
    public static TestSuite getTestSuite(){
        TestSuite suite = new TestSuite();

        suite.addTestSuite(LoginCleanUsernameAndPassword.class);
        suite.addTestSuite(LoginIsEmptyPassword.class);
        suite.addTestSuite(LoginIsEmptyUsername.class);
        suite.addTestSuite(LoginIsEmptyUsernameAndPassword.class);
        suite.addTestSuite(LoginIsFailure.class);
        suite.addTestSuite(LoginIsSuccess.class);
        suite.addTestSuite(Logout.class);
        suite.addTestSuite(LogoutIsSaveUsername.class);

        return suite;
    }
}
