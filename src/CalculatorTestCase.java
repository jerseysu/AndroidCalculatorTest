//Author: JerseySu
//Email: loverjersey@gmail.com
//Comment: This is a TestCase for Android Calculator
//Device: Android 6
//ReferencePage:
//http://university.utest.com/android-ui-testing-uiautomatorviewer-and-uiautomator/


package UIAutomator;

//Import the uiautomator libraries
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import UIAutomator.Calculator;

public class CalculatorTestCase extends UiAutomatorTestCase {   
	
		//Init Caluclator class
		Calculator calc = new Calculator();
		UiObject Calculator;
		UiObject allAppsButton;
		
		

    protected void setUp()   {
        /* StartTestCase */

    }
 
    protected void tearDown() {
        /* CloseTestCase */
    	// PressHome
		getUiDevice().pressHome();
	}
    
    private void LaunchApps() throws UiObjectNotFoundException{
    	// Simulate a short press on the HOME button
    	getUiDevice().pressHome();

	    // All Apps button's content-description property has the value “Apps”
    	allAppsButton = new UiObject(new UiSelector().description("Apps"));

    	// Simulate a click to bring up the All Apps screen.
    	allAppsButton.clickAndWaitForNewWindow();
	    
    	// Get a reference to that list
    	UiScrollable ListOfapplications = new UiScrollable(new UiSelector().scrollable(true));
			
    	ListOfapplications.setAsHorizontalList();
    	// find the application with the name Calculators			
    	Calculator = new UiObject(new UiSelector().text("Calculator"));
    	
    	Calculator.clickAndWaitForNewWindow();
    	
    	//Detect app launched
    	assertTrue("Unable to detect Calculator App", calc.Pager().exists());
    	System.out.println("Calculator App launched");
    	    
    	//Clear Formular
    	calc.ClearFormular();
    }
    
    public void testingFormulor() throws UiObjectNotFoundException {   
		
		// Launch Calculator app
		this.LaunchApps();
		
		// test the press of button "7"
		calc.Seven().click();
		// test the press of button "+"
		calc.Add().click();
		// and then the press of button "1"
		calc.One().click();
		//Results should be "8"
		assertEquals("8", calc.Results().getText());
		System.out.printf("Results is %s %n",calc.Results().getText().toString());
		
		// test the press of button "="
		calc.Eql().click();
		
		// formulor should be "8" ∞
		assertEquals("8", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());			
		
		//Clear
		calc.Clr().click();
		assertEquals("", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());	
		
		// press of "Back" button
		getUiDevice().pressBack();
		
		
			
			
	}
	
	public void testingPadOps_Del() throws UiObjectNotFoundException, InterruptedException {
		//Launch Calculator
		this.LaunchApps();
		
		//test the press of button "9"
		calc.Night().click();
		
		//test the press of button "."
		calc.Point().click();
		
		//test the press of button "del"
		calc.Del().longClick();
		Thread.sleep(3000);		
		
		assertEquals("", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());
		
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadOps_Add() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();	
		
		
		//test the press of button "7"+"8"=
		calc.Seven().click();
		calc.Add().click();
		calc.Eight().click();
		calc.Eql().click();

		
		assertEquals("15", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());
		
		//Clear Formular
    	calc.ClearFormular();
		

	}
	
	public void testingPadOps_Sub() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
		//test the press of button "2"-"1"=
		calc.Two().click();
		calc.Sub().click();
		calc.One().click();
		calc.Eql().click();

		
		assertEquals("1", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());
		
		
		//Clear Formula
		calc.ClearFormular();
		
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadOps_Mul() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
		//test the press of button "3"x"4"=
		calc.Three().click();
		calc.Mul().click();
		calc.Four().click();
		calc.Eql().click();

		
		assertEquals("12", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());
		
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadOps_Div() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
		//test the press of button "60"/"5"=
		calc.Six().click();
		calc.Zero().click();
		calc.Div().click();
		calc.Five().click();
		calc.Eql().click();

		
		assertEquals("12", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Sin() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
		double sin_deg=Math.sin(30.0/180.0*Math.PI);  //sin 30
		double sin_deg_round = new BigDecimal(sin_deg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		//Test sin(30.0/180.0*PI)
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Sin_Func().click();
		calc.Pad_Adv().swipeRight(30);
		calc.Three().click();
		calc.Zero().click();
		calc.Div().click();
		calc.One().click();
		calc.Eight().click();
		calc.Zero().click();
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.PI().click();
		calc.Pad_Adv().swipeRight(30);
		calc.Eql().click();    

		System.out.println("Sin : "+sin_deg_round);
	    
		assertEquals(String.valueOf(sin_deg_round), calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Cos() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
	    double cos_deg=Math.cos(60.0/180.0*Math.PI);  //cos 60	    
		double cos_deg_round = new BigDecimal(cos_deg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		//Test Cos(60.0/180.0*PI)
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Cos_Func().click();
		calc.Pad_Adv().swipeRight(30);
		calc.Six().click();
		calc.Zero().click();
		calc.Div().click();
		calc.One().click();
		calc.Eight().click();
		calc.Zero().click();
		calc.Pad_Adv().dragTo(calc.Seven(), 30);		
		calc.PI().click();
		calc.Pad_Adv().swipeRight(30);
		calc.Eql().click();
		
		System.out.println("Cos : "+cos_deg_round);
	    	
		assertEquals(String.valueOf(cos_deg_round), calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Tan() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
	    double tan_deg=Math.tan(Math.PI/4);  //tan 	    
		double tan_deg_round = new BigDecimal(tan_deg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		//Test tan(PI/4)
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Tan_Func().click();
		calc.PI().click();
		calc.Pad_Adv().swipeRight(30);
		calc.Div().click();
		calc.Four().click();
		calc.Eql().click();
		
		System.out.println("Tan : "+tan_deg_round);
	    	
		assertEquals(String.valueOf((int)tan_deg_round), calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Ln() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();		
	    	
		//Test ln(e)
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Ln_Func().click();
		calc.E().click();
		calc.Pad_Adv().swipeRight(30);
		calc.Eql().click();
		
    	
		assertEquals("1", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Log() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();		
	    
		double log_deg=Math.log10(100);  // log(100) / log(10)    
		double log_deg_round = new BigDecimal(log_deg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		//Test log(100) / log(10)
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Log_Func().click();
		calc.Pad_Adv().swipeRight(30);
		calc.One().click();
		calc.Zero().click();
		calc.Zero().click();
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.RParen().click();
		calc.Pad_Adv().swipeRight(30);
		calc.Div().click();
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Log_Func().click();
		calc.Pad_Adv().swipeRight(30);
		calc.One().click();
		calc.Zero().click();
		
		calc.Eql().click();
		
		System.out.println("Log : "+log_deg_round);
    	
		assertEquals(String.valueOf((int)log_deg_round), calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Factorial() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();		
	    
		int fact_deg=1*2*3*4*5*6*7*8*9*10;  // 10!    
				
		//Test 10!
		calc.One().click();
		calc.Zero().click();
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Fact_Func().click();
		calc.Pad_Adv().swipeRight(30);
		
		calc.Eql().click();
		
		System.out.println("Factorial : "+fact_deg);
    	
		assertEquals(String.valueOf(fact_deg), calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Power() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
	    
		int power_deg=(int) Math.pow(2, 10);  // 2^10		
		
		//Test 2^10
		calc.Two().click();
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Pow().click();
		calc.Pad_Adv().swipeRight(30);
		calc.One().click();
		calc.Zero().click();
		
		calc.Eql().click();
		
		System.out.println("Power : "+power_deg);
    	
		assertEquals(String.valueOf(power_deg), calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingPadAdv_Squre() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
		double squre_deg=Math.sqrt(100);  // squre(100)
		double squre_deg_round = new BigDecimal(squre_deg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		//Test squre(100)
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.Sqrt().click();
		calc.Pad_Adv().swipeRight(30);
		calc.One().click();
		calc.Zero().click();
		calc.Zero().click();
		
		calc.Eql().click();
		
		System.out.println("Squre : "+squre_deg_round);
    	
		assertEquals(String.valueOf((int)squre_deg_round), calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
		
	}
	
	public void testingPadAdv_PI() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
		//Test π
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.PI().click();
		calc.Pad_Adv().swipeRight(30);
		
		calc.Eql().click();
    	
		assertEquals("3.1415926536", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());		
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
		
	}
	
	public void testingPadAdv_GetError() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();
		
		//Test ()
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		calc.LParen().click();
		calc.RParen().click();
		calc.Pad_Adv().swipeRight(30);

		calc.Eql().click();		
  	
		assertEquals("Error", calc.Results().getText());		
		System.out.printf("Results is %s %n",calc.Results().getText().toString());
			
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
		
	}
	
	
	public void testingUI() throws UiObjectNotFoundException, UnsupportedEncodingException{
			
		//Launch Calculator
		LaunchApps();

		//Testing UI present		
				
		assertEquals("0", calc.Zero().getText());
		assertEquals("1", calc.One().getText());
		assertEquals("2", calc.Two().getText());
		assertEquals("3", calc.Three().getText());
		
		assertEquals("4", calc.Four().getText());
		assertEquals("5", calc.Five().getText());
		assertEquals("6", calc.Six().getText());
		assertEquals("7", calc.Seven().getText());
		
		assertEquals("8", calc.Eight().getText());
		assertEquals("9", calc.Night().getText());
		
		assertEquals(".", calc.Point().getText());
		assertEquals("DEL", calc.Del().getText());
		
		
		char character='+';
		assertEquals(String.valueOf(character), calc.Add().getText());
		character='−';
		//this is a bug
		assertEquals(String.valueOf(character), String.valueOf(calc.Sub().getText()));		
		character='÷';
		assertEquals(String.valueOf(character), calc.Div().getText());				
		character='×';
		assertEquals(String.valueOf(character), calc.Mul().getText());
		
		
		calc.Pad_Adv().dragTo(calc.Seven(), 30);
		assertEquals("sin", calc.Sin_Func().getText());
		assertEquals("cos", calc.Cos_Func().getText());
		assertEquals("tan", calc.Tan_Func().getText());
		assertEquals("ln", calc.Ln_Func().getText());
		assertEquals("log", calc.Log_Func().getText());
		character='!';
		assertEquals(String.valueOf(character), calc.Fact_Func().getText());
		character='π';
		assertEquals(String.valueOf(character), calc.PI().getText());
		character='e';
		assertEquals(String.valueOf(character), calc.E().getText());
		character='^';
		assertEquals(String.valueOf(character), calc.Pow().getText());
		character='(';
		assertEquals(String.valueOf(character), calc.LParen().getText());
		character=')';
		assertEquals(String.valueOf(character), calc.RParen().getText());
		character='√';
		assertEquals(String.valueOf(character), calc.Sqrt().getText());
		calc.Pad_Adv().swipeRight(30);
		
		//Check Special Charactor ∞
		//Print Unicode number
		//System.out.println( "\\u" + Integer.toHexString('∞' | 0x10000).substring(1) );
		character='∞';
		calc.Two().click();
		calc.Div().click();
		calc.Zero().click();		
		assertEquals(String.valueOf(character), calc.Results().getText());
		calc.Eql().click();
		assertEquals(String.valueOf(character), calc.Formula().getText());
		
		assertEquals("clr", calc.Clr().getText());		
		

	}
	public void testingPadOps_Display() throws UiObjectNotFoundException {
		//Launch Calculator
		LaunchApps();
		//click Add
		calc.Add().click();
		assertEquals("", calc.Formula().getText());		
		//click Mul
		calc.Mul().click();
		assertEquals("", calc.Formula().getText());
		//click Div
		calc.Div().click();
		assertEquals("", calc.Formula().getText());
		//click Sub (There is a bug here!!)
		calc.Sub().click();
		assertEquals("", calc.Formula().getText());
		
		//Clear Formular
    	calc.ClearFormular();
		
		// press of "Back" button
		getUiDevice().pressBack();
		
	}
	
	public void testingPadOps_OverFlow_01() throws UiObjectNotFoundException {
		//Launch Calculator
		LaunchApps();
		
		//testing 999999999+2
		for (int i=1;i<=10;i++){
			calc.Night().click();
		}
		calc.Add().click();
		calc.Two().click();
		calc.Eql().click();    	
    	
    	System.out.printf("Results is %s %n",calc.Formula().getText());
		
    	assertEquals("1.0000000E10", calc.Formula().getText());
    	
    	//Clear Formular
    	calc.ClearFormular();
    	
		// press of "Back" button
		getUiDevice().pressBack();
		
	}	
}

	
	