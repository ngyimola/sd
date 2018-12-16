package dao;

import entities.User;

import java.util.List;

public interface IUserDAO {

    User loginUser(String username, String password);

    User getUser(int id);

    User addUser(User user);

    List<User> getAllUsers();

    void dummyOp();
}
