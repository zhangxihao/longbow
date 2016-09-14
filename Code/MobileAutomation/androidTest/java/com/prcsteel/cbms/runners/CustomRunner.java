package com.prcsteel.cbms.runners;

import com.prcsteel.cbms.BasicTestCase;
import com.prcsteel.cbms.testsuite.SuiteLogin;

import junit.framework.TestSuite;

/**
 * Created by bob on 2015/9/23.
 * 默认的 runner是InstrumentationTestRunner，继承自 Instrumentation，用来针
 * 对特定的用例跑各种不同的自动化用例。通过Api可以查到只要重写 getAllTests方法
 * 就可以重新定义需要运行的自动化测试用例集。
 */
public class CustomRunner extends CommonRunner {
    @Override
    public TestSuite getAllTests() {

        TestSuite suite = new TestSuite();

        suite.addTest(SuiteLogin.getTestSuite());

        return suite;
    }

}
