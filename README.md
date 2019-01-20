# HA Assignment
<p>Scenarios Automated:</p>
<ul><li>As a new user on the website > Search for an item on the website > checkout > register and
complete the order</li>
<li>Login to the account for an existing user > search for an item on the website > checkout to
complete the order</li>
</ul>
<h3>Programming Language and Automation Tools</h3>
<ul><li>Programming Language:<b>Java(jdk 1.8)</b></li>
  <li> Build Tool: Maven</li>
  <li> Selenium WebDriver: 3.141.0 </li>
  <li> Cucumber-java:1.2.5</li>
  <li>cluecumber-report-plugin:1.4.2</li>
  <li> IDE: IntelliJ IDEA 2017.1</li>
</ul>
<h3>Framework Overview</h3>
<p>The framework is based on page object design pattern. I have provided two approaches for automating these scenarios. The fist one is using TestNG and second one is BDD using cucumber. User can choose any of the approach for automating tests. The major components of the framework are:</p>
<ul><li> DriverFactory: singleton Class to intialize the Web Driver</li> <li> BaseClass: Contians all the reusable methods like find element, isElementPresent, GetElementText etc..</li><li>PageObjects: Application pages containing page methods and locators</li>
  <li>CentralData.Property: Containing Web application specific data such as Browser,Wait Timeout, App Url etc.. </li>
  <li>TestNGtests: Containing TestNg tests</li>
  <li> TestRunner: TestNG runner XML file
</ul>
<h4> Cucumber BDD specific components:<h4>
   <ul>
  <li>Stepdefinitions: Contain step definations of application pages.</li>
  <li>Features: Containing fetaures files</li>
  <li>TestRunner: Junit runner class</li>
  <li>Target/generated-report: Contains generated html report</li>
  </ul>
  <h3>Running TestNG Tests:</h3>
  
  <ul>
    <li> open the project as maven Project in IDE such as InteliJ IDEA</li>
    <li> Set the browser name as Chrome or FireFox or InternetExplorer in "src/test/resources/CentralData.properties" file</li>
  <li>Run the "src/test/java/resources/testng/testng.xml" file</li></ul>
  <h3> Running TestNG tests through command line</h3>
  <ul>
  <li> Execute the maven goal <b>mvn clean install -Dbrowser=Chrome</b>  in the project directory.</li></ul>
 <br/>
 <h3>Running Cucumber Tests:</h3>
 <p>Run the "src/test/java/runner/CucumberTestRunner.java" class</p>
 <h3> Cucumber Html output:</h3>
 <p> After running the tests, execute the maven goal <b> mvn cluecumber-report:reporting</b> and it will generate a HTML output report in "target/generated-report" folder</p>
  </ul>
