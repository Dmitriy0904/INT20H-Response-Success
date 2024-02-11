package int20h.responsesuccess.service.impl;

import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.repository.UserRepository;
import int20h.responsesuccess.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new EntityNotFoundException("User", user.getId().toString());
        }
        userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            log.warn("Package with id = {} not found", userId);
            return new EntityNotFoundException("User", userId.toString());
        });
    }

    @Override
    public User findByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (IncorrectResultSizeDataAccessException exception) {
            throw new EntityNotFoundException("User", email);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
