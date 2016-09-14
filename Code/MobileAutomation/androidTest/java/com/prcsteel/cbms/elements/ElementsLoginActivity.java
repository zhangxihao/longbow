package com.prcsteel.cbms.elements;

import android.os.SystemClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.prcsteel.cbms.utils.TestData.LoginData;
import com.prcsteel.cbms.widget.gesturelock.EditLockActivity;
import com.robotium.solo.Solo;

/**
 * Created by bob on 2015/9/11.
 * 封装登录界面所有控件id,提供给自动化用例使用
 */
public class ElementsLoginActivity extends AbstractBasicElement {
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private ImageView mBtnClearUsername, mBtnClearPassword;

    public ElementsLoginActivity(Solo solo){
        this.solo = solo;
        initViews();
//        SystemClock.sleep(2000);        // ???一个很神奇的问题，可能由于UI主线程太慢导致界面渲染缓慢
    }

    /**
     * 初始化的时候，找到所有登录页面的控件
     */
    @Override
    public void initViews() {
//        mEdtUsername = (EditText) solo.getCurrentActivity().findViewById(R.id.edt_username);
        mEdtUsername = (EditText) solo.getCurrentActivity().findViewById(LoginData.EDIT_USERNAME);  // 后期全部采用这种方式实现
        mEdtPassword = (EditText) solo.getCurrentActivity().findViewById(LoginData.EDIT_PASSWORD);
        mBtnLogin = (Button) solo.getCurrentActivity().findViewById(LoginData.BTN_LOGIN);
    }


    public EditText getEdtUsername() {
//        solo.waitForView(mEdtUsername.isShown());   // 加了会慢，不加就不稳定
        return mEdtUsername;
    }

    public EditText getEdtPassword() {
        return mEdtPassword;
    }

    public Button getBtnLogin() {
        return mBtnLogin;
    }

    /**
     * 输入用户名
     * @param text
     */
    public void enterEdtUsername(String text) {
        solo.enterText(mEdtUsername, text);
    }

    /**
     * 输入密码
     * @param text
     */
    public void enterEdtPassword(String text) {
        solo.enterText(mEdtPassword, text);
    }

    //直接清除帐号和密码
    public void clearEdtUsernameAndPassword(){
        solo.clearEditText(mEdtUsername);
        solo.clearEditText(mEdtPassword);
    }

    // 点击登录
    public void clickOnBtnLogin() {
        solo.clickOnView(mBtnLogin);
//        solo.waitForActivity(MainActivity.class, 3000);
    }

    // 当有内容输入时点击右边的X
    public void clickOnBtnClearUsername(){

        mBtnClearUsername = (ImageView) solo.getCurrentActivity().findViewById(LoginData.BTN_CLEAR_USERNAME);
//        solo.clickOnImage(R.id.btn_clear_username);
//        Log.i("sdd", "找到了:" + mBtnClearPassword.toString());
        solo.clickOnView(mBtnClearUsername);


    }
    public void clickOnBtnClearPassword(){

        mBtnClearPassword = (ImageView) solo.getCurrentActivity().findViewById(LoginData.BTN_CLEAR_PASSWORD);
//        solo.clickOnImage(R.id.btn_clear_password);
        solo.clickOnView(mBtnClearPassword);

    }

    /**
     * 登录
     */
    public void doLoginWithAccount(String[] account){
        enterEdtUsername(account[0]);
        enterEdtPassword(account[1]);
        clickOnBtnLogin();
//        solo.waitForActivity(EditLockActivity.class, 3000);
        solo.sleep(2000);
    }

}
