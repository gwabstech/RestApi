package com.gwabstech.RestApi.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    private static int userCount = 5;
    static {
        userList.add(new User(1,"Abubakar",new Date()));
        userList.add(new User(2,"Abdullahi",new Date()));
        userList.add(new User(3,"Gwabare",new Date()));
        userList.add(new User(4,"Habu",new Date()));
        userList.add(new User(5,"Abu",new Date()));
    }


    // getting users
    public List<User> getUserList(){
        return userList;
    }

    // adding user
    public User addUser(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    // getSingle User
    public User findUserById(int id){
       for(int i = 0; i <= userCount; i++ ){
           if (userList.get(i).getId() == id){
               return userList.get(i);
           }

       }
       return null;
    }



}
