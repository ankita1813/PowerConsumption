package com.android.launcher.robotiumtest;

/**
 * Created by ankita on 21/2/17.
 */
import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends ActivityInstrumentationTestCase2<FirstActivity>{

    private Solo solo;

    public RobotiumActivityFunctionalTest() {
        super(FirstActivity.class);
    }

    @Override

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(),getActivity());
    }

    @

    public void testCase() throws Exception {
        String vResult = "TestExample";
        EditText vEditText = (EditText) solo.getView(R.id.edit1);
        solo.clearEditText(vEditText);
        solo.enterText(vEditText, "TestExample");
        solo.clickOnButton("Submit");
        assertTrue(solo.searchText(vResult));
        TextView textField = (TextView) solo.getView(R.id.txt1);
        //Assert to verify result with visible value
        assertEquals(vResult, textField.getText().toString());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}