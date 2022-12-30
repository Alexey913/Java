package view;

import java.util.List;

import data.User;

public abstract class UserView {

    void showTheBest(List<User> userList) {
        User user = userFindTheBest(userList);
        System.out.println(user);
    }

    protected abstract User userFindTheBest(List<User> userList);
}
