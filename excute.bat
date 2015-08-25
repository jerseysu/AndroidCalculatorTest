@echo on
f:\code\apache-ant-1.9.6-bin\bin\ant build

f:\code\AndroidSDk\platform-tools\adb.exe push f:\code\LearnUIAutomator\bin\UIAutomator.jar /data/local/tmp

f:\code\AndroidSDk\platform-tools\adb.exe shell uiautomator runtest UIAutomator.jar -c UIAutomator.CalculatorTestCase