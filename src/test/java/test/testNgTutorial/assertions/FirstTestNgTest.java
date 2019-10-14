package test.testNgTutorial.assertions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNgTest {
    Usermanagement um;

    @BeforeMethod
    public void setup(){
        um = new Usermanagement();
    }

    @Test
    public void successfulAddUserReturnsTrue(){
        //Arrange
        Usermanagement um = new Usermanagement();

        //Act
        boolean result = um.addUser("abc@gmail.com");

        //Assert
        Assert.assertEquals(result, true);
    }
    @Test
    public void getUserReturnsExistingSavedUser(){

        //Arrange
        Usermanagement um = new Usermanagement();
        um.addUser("abc@gmail.com");

        //Act
        String user = um.getUser("abc@gmail.com");

        //Assert
        Assert.assertEquals(user, "abc@gmail.com");
    }
    @Test
    public void getNonExistingUserReturnNull(){
        //Arrange
        Usermanagement um = new Usermanagement();

        //Act
        String user = um.getUser("abc@gmail.com");

        //Assert
        Assert.assertNull(user);
    }
}
