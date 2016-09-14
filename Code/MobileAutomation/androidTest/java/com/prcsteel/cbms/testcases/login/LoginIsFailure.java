package com.prcsteel.cbms.testcases.login;

import android.os.SystemClock;

import com.prcsteel.cbms.BasicTestCase;
import com.prcsteel.cbms.utils.FileOperator.FileUtil;
import com.prcsteel.cbms.utils.PromptMessage.AssertMessage;
import com.prcsteel.cbms.utils.TestData.LoginData;

import junit.framework.Assert;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by bob on 2015/9/11.
 * ---------------------------TestCase-----------------------------
 * step1: 输入用户名 testbuyer123 --> 输入密码 123456 -->点击登录按钮
 * expect1:提示“用户名或者密码错误”
 * 采用读取login_failure.xml方式数据驱动用例方式执行
 */
public class LoginIsFailure extends BasicTestCase {

    private static final String Tag = "sdd";
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testLogin(){

        try {
            InputStream inputStream = getInstrumentation().getContext().getResources().getAssets().open(FileUtil.FILE_LOGIN_FAILURE_XML);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  // 工厂
            DocumentBuilder builder = factory.newDocumentBuilder();     //解析器
            Document document = builder.parse(inputStream); // 文档跟节点

            NodeList list = document.getElementsByTagName(LoginData.TESTCASE_UNIT);  // 获得指定标签的所有节点集合

            for(int i = 0; i < list.getLength(); i++){
                Element element = (Element) list.item(i);   // 获取具体元素

                String username =element.getElementsByTagName(LoginData.TESTCASE_UNIT_USERNAME).item(0).getFirstChild().getNodeValue();
                String password = element.getElementsByTagName(LoginData.TESTCASE_UNIT_PASSWORD).item(0).getFirstChild().getTextContent();
                String expect = element.getElementsByTagName(LoginData.TESTCASE_UNIT_EXCEPT).item(0).getFirstChild().getNodeValue();

                uiHelper.getElementsLoginActivity().clearEdtUsernameAndPassword();

                uiHelper.getElementsLoginActivity().enterEdtUsername(username);
                uiHelper.getElementsLoginActivity().enterEdtPassword(password);
                uiHelper.getElementsLoginActivity().clickOnBtnLogin();
//                Log.i(Tag, expect);
                uiHelper.getSolo().waitForDialogToOpen(20000);
                assertTrue(AssertMessage.ASSERT_FAILURE_TOAST_NOTFOUND, uiHelper.getSolo().searchText(expect, true));
                uiHelper.getSolo().waitForDialogToClose(20000);
                SystemClock.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(AssertMessage.TEST_FAILURE_MESSAGE);
        }

    }

}
