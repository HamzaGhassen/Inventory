package tn.ghassen.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.ghassen.inventory.entity.User;
import tn.ghassen.inventory.repository.UserRepository;
import tn.ghassen.inventory.service.UserService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {

        User existing = getUserById(id);

        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());

        existing.setEmail(user.getEmail());
        existing.setPhone(user.getPhone());
        existing.setPassword(user.getPassword());
        existing.setPhone(user.getPhone());
        existing.setRole(user.getRole());

        return userRepository.save(existing);    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}




