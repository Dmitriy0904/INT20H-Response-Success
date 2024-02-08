package int20h.responsesuccess.service;

import int20h.responsesuccess.entity.User;

import java.util.List;

public interface UserService {

    void create(User user);
    void update(User user);
    User findById(Long userId);
    User findByEmail(String email);
}
