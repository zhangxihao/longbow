package com.prcsteel.cbms.utils.StudyTemp;

import android.os.SystemClock;
import android.widget.TextView;
import android.widget.Toast;

import com.prcsteel.cbms.BasicTestCase;

/**
 * Created by bob on 2015/9/11.
 */
public class StudyTemp extends BasicTestCase{
    /**
     * 获取Toast的String值
     * @return
     */
    public String getToast(int timeout){
        TextView toastTextView = null;
        String toastText = "";
        long endTime = SystemClock.uptimeMillis() + timeout;
        while(SystemClock.uptimeMillis() < endTime){
            toastTextView = (TextView)uiHelper.getSolo().getView("message", 0);
            if(null != toastTextView){
                toastText = toastTextView.getText().toString();
                break;
            }else {
                Toast.makeText(getInstrumentation().getTargetContext(), "没有获取到text", Toast.LENGTH_LONG).show();
            }
        }

        return toastText;
    }
}
