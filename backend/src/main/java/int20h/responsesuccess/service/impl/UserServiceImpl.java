package int20h.responsesuccess.service.impl;

import int20h.responsesuccess.repository.UserRepository;
import int20h.responsesuccess.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
}
