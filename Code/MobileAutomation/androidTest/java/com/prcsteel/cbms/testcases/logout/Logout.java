package com.prcsteel.cbms.testcases.logout;

import com.prcsteel.cbms.BasicTestCaseWithLogin;
import com.prcsteel.cbms.activity.LoginActivity;
import com.prcsteel.cbms.activity.MainActivity;
import com.prcsteel.cbms.utils.PromptMessage.AssertMessage;
import com.prcsteel.cbms.utils.TestData.LogoutData;


/**
 * Created by bob on 2015/9/11.
 */
public class Logout extends BasicTestCaseWithLogin {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testLogout(){
        uiHelper.getSolo().waitForActivity(MainActivity.class, 3000);

        uiHelper.getElmentsMainActivity().clickOnMenu();

        uiHelper.getSolo().waitForText(LogoutData.TEXTVIEW_LOGOUT, 1, 3000, true, true);

        uiHelper.getElementsLogoutToast().clickOnLogout();

        assertTrue(AssertMessage.ASSERT_FAILURE_TOAST_NOTFOUND, uiHelper.getSolo().searchText(LogoutData.MESSAGE_LOGOUT_SUCCESS, true));

        assertTrue(AssertMessage.ASSERT_FAILURE_ACTIVIT_NOTFOUND, uiHelper.getSolo().waitForActivity(LoginActivity.class, 3000));
    }


}
