package com.prcsteel.cbms.utils.TestData;

import com.prcsteel.cbms.R;

/**
 * Created by bob on 2015/9/18.
 * 测试数据类，目前使用类实现，后期使用xml配置，使用App或Swing自动生成。主要包含以下几个：
 * 1. xml文件标签名封装，方便以后随机修改xml文件结构
 * 2. 登录控件的封装，后期开发如果修改id，逻辑代码不需要修改。
 * 3. 登录的正确错误密码设置
 * 4. 最终预期达到在开发代码还未开始测试逻辑已经写好，但是不方便调试。后面会将这种类做成模板，自动生成类文件
 * 5. 最好是开发也按照这种约定来写，那么开发测试使用的是同一个控件类文件，后期开发重构测试代码不需要修改，减少维护成本
 * 6.
 */
abstract public class LoginData {
    public static final String USERNAME = "testbuyer";  // 正确的用户名
    public static final String PASSWORD = "123456"; // 正确的密码

    // 登录的xml标签
    public static final String ROOT_ELEMENT = "testcases";  // 根元素
    public static final String TESTCASE_UNIT = "testcase";   // 单条测试用例
    public static final String TESTCASE_UNIT_ID = "id";     // 单条测试用例下的标签
    public static final String TESTCASE_UNIT_USERNAME = "username";
    public static final String TESTCASE_UNIT_PASSWORD = "password";
    public static final String TESTCASE_UNIT_EXCEPT = "expect";

    // 登录控件id，提供给ElementsLoginActivity类使用。后期考虑将左右控件封装在同一个库里面，开发测试统一调用。
    // 考虑到后期可能某些直接用String或者其他方式，统一管理，避免重构工具不靠谱
    public static final int EDIT_USERNAME = R.id.edt_username;
    public static final int EDIT_PASSWORD = R.id.edt_password;
    public static final int BTN_LOGIN = R.id.btn_login;
    public static final int BTN_CLEAR_USERNAME = R.id.btn_clear_username;
    public static final int BTN_CLEAR_PASSWORD = R.id.btn_clear_password;


}
