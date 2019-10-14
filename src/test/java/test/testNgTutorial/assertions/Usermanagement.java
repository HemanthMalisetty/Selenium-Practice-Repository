package test.testNgTutorial.assertions;

import java.util.ArrayList;
import java.util.Collection;

public class Usermanagement {
    private Collection<String> userStorage;

    public Usermanagement(){
        userStorage = new ArrayList<>();
    }

    public boolean addUser(String userEmail){
        return userStorage.add(userEmail);
    }

    public String getUser(String userEmail){
        for (String s : userStorage){
            if (s.equals(userEmail)){
                return s;
            }
        }
        return null;
    }
    public boolean deleteUser(final String userEmail){
        return userStorage.removeIf(e -> e.equals(userEmail));
    }
}
