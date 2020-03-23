package test;

import org.junit.*;

public class TestJunit {
    public TestJunit() {
        System.out.println("构造方法");
    }
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("BeforeClass");
    }
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }


    @Ignore
    public void test3() {
        System.out.println("test3");
    }

}
