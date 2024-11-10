package cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="C:\\Users\\Pran\\eclipse-workspace\\Frameworkboutiqueadd\\src\\feature\\add.feature", 
glue="cucumber", monochrome=true,plugin= {"html:target/cucumber.html"})
public class testrunner extends AbstractTestNGCucumberTests  {

}
