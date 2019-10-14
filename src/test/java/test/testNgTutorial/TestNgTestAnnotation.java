package test.testNgTutorial;

import org.testng.annotations.Test;

public class TestNgTestAnnotation {
    @Test
    private void aTest(){
        System.out.println("aTest method");
    }
    @Test
    private void cTest(){
        System.out.println("cTest method");
    }
    @Test
    private void bTest(){
        System.out.println("bTest method");
    }
}
