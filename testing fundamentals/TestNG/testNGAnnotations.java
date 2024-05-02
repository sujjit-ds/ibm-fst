import org.testng.annotations.*;

public class testNGAnnotations {

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("BeforeGroups");
    }

    @Test
    public void testMethod() {
        System.out.println("TestMethod");
    }

    @Test(groups = {"Group1"})
    public void group1(){
        System.out.println("Group1");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
    }
}
