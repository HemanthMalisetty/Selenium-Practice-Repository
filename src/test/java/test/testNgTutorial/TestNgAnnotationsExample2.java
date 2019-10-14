package test.testNgTutorial;

import org.testng.annotations.Test;

/**
 * When you are using "@Test" annotation in class level all methods in side the class should be "public"
 */
@Test
public class TestNgAnnotationsExample2 {

    public void aTest(){
        System.out.println("aTest method");
    }

    public void cTest(){
        System.out.println("cTest method");
    }

    public void bTest(){
        System.out.println("bTest method");
    }
}
