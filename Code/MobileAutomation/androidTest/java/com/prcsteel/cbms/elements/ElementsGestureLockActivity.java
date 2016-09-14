package com.prcsteel.cbms.elements;

import android.widget.TextView;

import com.prcsteel.cbms.utils.TestData.GestureLockData;
import com.robotium.solo.Solo;

/**
 * Created by bob on 2015/9/21.
 */
public class ElementsGestureLockActivity extends AbstractBasicElement {
    private TextView mTvGestureLock;

    public ElementsGestureLockActivity(Solo solo){
        this.solo = solo;
        initViews();
    }

    @Override
    public void initViews() {
        mTvGestureLock = (TextView) solo.getCurrentActivity().findViewById(GestureLockData.SET_UNLOCK_GRAPH);
    }

    public TextView getTvGestureLock() {
        return mTvGestureLock;
    }

}
