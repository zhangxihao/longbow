package com.prcsteel.cbms;

import android.content.Intent;
import android.os.PowerManager;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.prcsteel.cbms.activity.LoginActivity;
import com.prcsteel.cbms.service.LogService;
import com.prcsteel.cbms.utils.DirectoryConfiguration;
import com.prcsteel.cbms.utils.NetworkUtil;
import com.prcsteel.cbms.utils.ScreenUtil;
import com.robotium.solo.Solo;

/**
 * Created by bob on 2015/9/10.
 */
abstract public class BasicTestCase extends ActivityInstrumentationTestCase2<LoginActivity> {

    private Solo solo;
    private PowerManager.WakeLock wakeScreenObject = null;
    protected UIHelper uiHelper = null;

    public BasicTestCase() {
        super(LoginActivity.class);
    }

    /**
     * 复写setUp进行异常捕获，截图处理
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        try{
            super.setUp();
            init();
            startLogService();     // 日志采集,如果服务没有开启过
        }catch (Throwable tr){
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw new SetUpException(tr);
        }
    }

    /**
     * 复写tearDown,进行异常捕获，截图处理
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        try{
            if(wakeScreenObject != null){
                wakeScreenObject.release();
                wakeScreenObject = null;
            }
            solo.finishOpenedActivities();
            uiHelper = null;
//            stopLogService();   // 测试结束后采集结束，取消注释后可以每个Testcase都生成一份log
            super.tearDown();
        }catch(Throwable th){
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw new TearDownException(th);
        }

    }

    private void init(){
        solo = new Solo(getInstrumentation(), getActivity());
        uiHelper = new UIHelper(solo);

        //唤醒设备
        if(wakeScreenObject == null){
            wakeScreenObject = ScreenUtil.wakeScreen(this);
        }
        //解锁
        ScreenUtil.unlock(getInstrumentation());
        //连接网络
        NetworkUtil.setAirplaneModeOffAndNetworkOn(getInstrumentation().getTargetContext());

        DirectoryConfiguration.directoryConfig();   //创建测试目录
    }

    /**
     * 在setUp、runTest、tearDown抛出了自定义异常，这里统一进行捕获然后，确保tearDown方法被执行，用来释放资源
     *
     * @throws Throwable
     */
    @Override
    public void runBare() throws Throwable {
        try {
            super.runBare();
        }catch (SetUpException smte){
            this.tearDown();
            throw smte;
        }  catch (RunTestException rte) {
            this.tearDown();
            throw rte;
        } catch (TearDownException tde) {
            this.tearDown();
            throw tde;
        }

    }
    /**
     * 复写runTest,捕获异常进行截图处理
     *
     * @throws Throwable
     */
    @Override
    protected void runTest() throws Throwable {
        try {
            super.runTest();
        }catch (Throwable th){
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw new RunTestException(th);
        }
    }

    /**
     * 日志服务
     */

    public void startLogService(){
        getInstrumentation().getContext().startService(new Intent(getActivity().getApplicationContext(), LogService.class));
    }

    public void stopLogService(){
        getInstrumentation().getContext().stopService(new Intent(getActivity().getApplicationContext(), LogService.class));
    }

    /**
     * 三个自定义的异常类，对应setUp时发生的异常，runTest发生的异常，tearDown发生的异常
     *
     */
    class SetUpException extends Exception{
        SetUpException(Throwable e){
            super("Error in BasicTestCase.setUp()!", e);
        }
    }
    class RunTestException extends Exception{
        RunTestException(Throwable e){
            super("Error in BasicTestCase.runTest()!", e);
        }
    }
    class TearDownException extends Exception{
        TearDownException(Throwable e){
            super("Error in BasicTestCase.tearDown()!", e);
        }
    }

}
