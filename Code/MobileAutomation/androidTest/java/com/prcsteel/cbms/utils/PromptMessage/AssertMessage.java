package com.prcsteel.cbms.utils.PromptMessage;

/**
 * Created by bob on 2015/9/18.
 * 程序中所使用的断言提示消息
 */
public class AssertMessage {
    public static final String TEST_FAILURE_MESSAGE = "测试失败，程序到运行到了不应该到达的位置！";  // Assert.fail
    public static final String ASSERT_FAILURE_TOAST_NOTFOUND = "提示消息没有发现可能出现bug！";   // 断言提示框
    public static final String ASSERT_FAILURE_ACTIVIT_NOTFOUND = "指定Activity没有发现可能出现Bug！";  // 断言Activity
    public static final String ASSERT_STRING_EXPECT_IS_ACTUAL = "预期字符串与实际字符不匹配！";   // 断言获取的文本与实际文本
}
