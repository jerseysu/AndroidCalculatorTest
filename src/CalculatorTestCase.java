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
	    
	    // All Apps button¡¦s content-description property has the value ¡§Apps¡¨
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
		
		// formulor should be "8" ¡Û
		assertEquals("8", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());			
		
		//Clear
		calc.Clr().click();
		assertEquals("", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());	
		
		// press of "Back" button
		getUiDevice().pressBack();
		
		
			
			
	}
	
	public void testingFunc() throws UiObjectNotFoundException {
		//Launch Calculator
		this.LaunchApps();		
		//test the press of button "7"
		calc.Seven().click();
		
		//tassertEquals "7"
		assertEquals("7", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());
		
		//test the press of button "del"
		calc.Del().click();
		
		assertEquals("", calc.Formula().getText());
		System.out.printf("Formulor is %s %n",calc.Formula().getText().toString());
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
	
	public void testingUI() throws UiObjectNotFoundException{
		
		//Launch Calculator
		LaunchApps();
		
		/*assertEquals("+".toString(), calc.Add().getText());
		assertEquals("-".toString(), calc.Sub().getText());
		assertEquals("¡Ò".toString(), calc.Div().getText());
		assertEquals("¡Ñ".toString(), calc.Mul().getText());*/
		
				
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

	
	