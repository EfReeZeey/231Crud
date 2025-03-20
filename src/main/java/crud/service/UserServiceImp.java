package crud.service;

import crud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import crud.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(int id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
