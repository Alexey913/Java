package data.comparator;

import java.util.Comparator;

import data.User;

public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getFio().compareTo(user2.getFio());
    }
}