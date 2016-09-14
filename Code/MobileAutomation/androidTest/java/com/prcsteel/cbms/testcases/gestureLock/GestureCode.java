package com.prcsteel.cbms.testcases.gestureLock;

import android.app.Instrumentation;
import android.graphics.Path;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.Display;
import android.view.MotionEvent;

import com.prcsteel.cbms.BasicTestCaseWithLogin;

/**
 * Created by bob on 2015/9/25.
 * 设置手势密码
 * http://blogs.steeplesoft.com/posts/2013/simulating-swipes-in-your-android-tests.html
 */

public class GestureCode extends BasicTestCaseWithLogin {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }



    /*
    public void setGestureCode(){
        uiHelper.getSolo().swipe();
        uiHelper.getSolo().drag();



    }
    private void swipeToLeft(int stepCount) {
        Display display = uiHelper.getSolo().getCurrentActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        float xStart = width - 10 ;
        float xEnd = 10;
        uiHelper.getSolo().drag(xStart, xEnd, height / 2, height / 2, stepCount);
    }

    private void swipeToRight(int stepCount) {
        Display display = uiHelper.getSolo().getCurrentActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        float xStart = 10 ;
        float xEnd = width - 10;
        uiHelper.getSolo().drag(xStart, xEnd, height / 2, height / 2, stepCount);
    }

    protected void swipe(Path.Direction direction) {
        Instrumentation inst = getInstrumentation();
        Point size = new Point();
        uiHelper.getSolo().getCurrentActivity().getWindowManager().getDefaultDisplay().getSize(size);
        int width = size.x;

        long downTime = SystemClock.uptimeMillis();
        float xStart = ((direction == Path.Direction.Left) ? (width - 10) : 10);
        float xEnd = ((direction == Path.Direction.Left) ? 10 : (width - 10));

        // The value for y doesn't change, as we want to swipe straight across
        inst.sendPointerSync(MotionEvent.obtain(downTime, SystemClock.uptimeMillis(),
                MotionEvent.ACTION_DOWN, xStart, size.y / 2, 0));
        inst.sendPointerSync(MotionEvent.obtain(downTime, SystemClock.uptimeMillis(),
                MotionEvent.ACTION_MOVE, xEnd, size.y / 2, 0));
        inst.sendPointerSync(MotionEvent.obtain(downTime, SystemClock.uptimeMillis() + 1000,
                MotionEvent.ACTION_UP, xEnd, size.y / 2, 0));
    }

*/
}
