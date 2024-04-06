package hibermvc.dao;

import hibermvc.entity.User;

import java.util.List;

public interface UserDao {

    User        getUserById(int id);
    List<User>  getAllUsers();
    void        saveUser(User employee);
    void        deleteUser(int id);
}
