//Author: JerseySu
//Email: loverjersey@gmail.com
//Comment: This is a class for Android Calculator controller
//Device: Android 6

package UIAutomator;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiObjectNotFoundException;

public class Calculator {

	//+
	public UiObject Add() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/op_add"));
    }
	
	//Del
	public UiObject Del() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/del"));
    }
	
	// กา
	public UiObject Div() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/op_div"));
    }
	
	//x
	public UiObject Mul() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/op_mul"));
    }
	
	//-
	public UiObject Sub() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/op_sub"));
    }
	
	//=
	public UiObject Eql() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/eq"));
    }
	
	
	//0
	public UiObject Zero() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_0"));
    }
	
	//1
	public UiObject One() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_1"));
    }
	
	//2
	public UiObject Two() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_2"));
    }
	
	//3
	public UiObject Three() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_3"));
    }
	
	//4
	public UiObject Four() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_4"));
    }
	
	//5
	public UiObject Five() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_5"));
    }
	
	//6
	public UiObject Six() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_6"));
    }
	
	//7
	public UiObject Seven() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_7"));
    }
	
	//8
	public UiObject Eight() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_8"));
    }
	
	//9
	public UiObject Night() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit_9"));
    }
	
	// .
	public UiObject Point() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/dec_point"));
    }
	
	//Formula 
	public UiObject Formula() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/formula"));
    }
	
	//Results
	public UiObject Results() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/result"));
    }
	
	//Clr
	public UiObject Clr() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/clr"));
    }
	
	//Pad pager
	public UiObject Pager() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("com.android.calculator2:id/pad_pager"));
    }
	
	
}
