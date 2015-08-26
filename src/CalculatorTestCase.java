//Author: JerseySu
//Email: loverjersey@gmail.com
//Comment: This is a TestCase for Android Calculator
//Device: Android 6


package UIAutomator;


//Import the uiautomator libraries
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;

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
    	// Simulate a short press on the HOME button.
	    getUiDevice().pressHome();
	    
	    // All Apps button’s content-description property has the value “Apps”
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
		    
		//Clear Formulor
		if (calc.Clr().exists() && calc.Formula().getText()!=""){
			calc.Clr().click();
		    System.out.println("Calculator Clear");
		}	    
		    
			
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
		
		calc.Formula().clearTextField();
		calc.Results().clearTextField();
		
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
		
		calc.Formula().clearTextField();
		calc.Results().clearTextField();
		

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
		
		
		calc.Formula().clearTextField();
		calc.Results().clearTextField();
		
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
		
		calc.Formula().clearTextField();
		calc.Results().clearTextField();
		
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
			
		calc.Formula().clearTextField();
		calc.Results().clearTextField();
		
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
			
		calc.Formula().clearTextField();
		calc.Results().clearTextField();
		
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
			
		calc.Formula().clearTextField();
		calc.Results().clearTextField();
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingUI() throws UiObjectNotFoundException{
			
		//Launch Calculator
		LaunchApps();
		
		
		//Testing UI present
		
		/*assertEquals("+".toString(), calc.Add().getText());
		assertEquals("-".toString(), calc.Sub().getText());
		assertEquals("÷".toString(), calc.Div().getText());
		assertEquals("×".toString(), calc.Mul().getText());*/
		
				
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
		


	}
	
}

	
	