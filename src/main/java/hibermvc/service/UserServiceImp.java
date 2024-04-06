package hibermvc.service;

import hibermvc.dao.UserDao;
import hibermvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public User getUserById(int id) {
      return userDao.getUserById(id);
   }

   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Override
   @Transactional
   public void saveUser(User user) {
      userDao.saveUser(user);
   }

   @Override
   @Transactional
   public void deleteUser(int id) {
      userDao.deleteUser(id);
   }
}
