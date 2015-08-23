package UIAutomator;


//Import the uiautomator libraries
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;

import UIAutomator.Calculator;

public class FirstCalculator extends UiAutomatorTestCase {   
	
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
		//Calculator.clearTextField();
			
		assertTrue("Unable to detect Calculator App", Calculator.exists());
		System.out.println("Calculator App launched");
		    
		//Clear Formulor
		if (calc.Clr().exists() && calc.Formula().getText()!=""){
			calc.Clr().click();
		    System.out.println("Calculator Clear");
		}	    
		    
			
    }

	
	
	public void testingFormulor() throws UiObjectNotFoundException {   
	    
		//this.LaunchApps();
		// now the Calculator app is open
		// test the press of button "7"
		calc.Seven().click();
		// test the press of button "+"
		calc.Add().click();
		// and then the press of button "1"
		calc.One().click();
		//Results should be "8"
		assertEquals("8", calc.Results().getText());
		System.out.printf("Results is %s",calc.Formula().getText().toString());
		
		// test the press of button "="
		calc.Eql().click();
		
		// formulor should be "8" ¡Û
		assertEquals("8", calc.Formula().getText());
		System.out.printf("Formulor is %s",calc.Formula().getText().toString());	
		

		
		// press of "Back" button
		getUiDevice().pressBack();
		
		
			
			
		}
	
	public void testingFunc() throws UiObjectNotFoundException {
		this.LaunchApps();		
		//test the press of button "7"
		calc.Seven().click();
		
		//tassertEquals "7"
		assertEquals("7", calc.Formula().getText());
		System.out.printf("Formulor is %s",calc.Formula().getText().toString());
		
		//test the press of button "del"
		calc.Del().click();
		
		assertEquals("", calc.Formula().getText());
		System.out.printf("Formulor is %s",calc.Formula().getText().toString());
		
		// press of "Back" button
		getUiDevice().pressBack();
	}
}

	
	