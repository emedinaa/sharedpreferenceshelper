package com.emedinaa.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.test.suitebuilder.annotation.SmallTest;

import com.emedinaa.sharedpreferences.storage.DefaultSharedPreferencesHelper;
import com.emedinaa.sharedpreferences.storage.SharedPreferencesHelper;
import com.emedinaa.sharedpreferences.utils.GsonHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    private String TEST_KEY_EMAIL= "com.emedinaa.sharedpreferences.session.email";
    private String TEST_VALUE_EMAIL= "emedinaa@gmail.com";

    @Mock
    Context mContext;

    @Mock
    SharedPreferences mSharedPreferences;

    @Mock
    SharedPreferences.Editor mEditor;

    private SharedPreferencesHelper sharedPreferencesHelper;

    @Before
    public void setup() {

        when(mSharedPreferences.getString(eq(TEST_KEY_EMAIL), anyString())).thenReturn(TEST_VALUE_EMAIL);
        when(mSharedPreferences.edit()).thenReturn(mEditor);
        GsonHelper gsonHelper= new GsonHelper();
        sharedPreferencesHelper= new DefaultSharedPreferencesHelper(gsonHelper,mSharedPreferences);
    }

    @Test
    public void testSaveEmail(){
        sharedPreferencesHelper.saveEmail(TEST_VALUE_EMAIL);
        Mockito.verify(mEditor).apply();
    }

    @Test
    public  void testGetEmail()
    {
        String email= sharedPreferencesHelper.email();
        assertThat("Message ", TEST_VALUE_EMAIL, is(equalTo(email)));
        System.out.println("email "+email);
    }


    @Test
    public  void testClear()
    {
        sharedPreferencesHelper.clear();
        when(mSharedPreferences.edit()).thenReturn(mEditor);
        Mockito.verify(mEditor).clear();
        Mockito.verify(mEditor).apply();

    }



}