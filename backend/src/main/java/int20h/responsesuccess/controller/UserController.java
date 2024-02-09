package int20h.responsesuccess.controller;

import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public int createUser(final @RequestBody User user) {
        userService.create(user);
        //todo check what we should return
        return Response.SC_CREATED;
    }

    @PutMapping
    public int editUser(final @RequestBody User user) {
        if (user != null && user.getId() != null && userService.existsById(user.getId())) {
            userService.update(user);
        } else {
            //todo check if user is not null
            throw new EntityNotFoundException("User", user != null && user.getId() != null ? user.getId().toString() : null);
        }
        //todo check what we should return
        return Response.SC_OK;
    }

    @GetMapping("/{id}")
    public User getUserById(final @PathVariable Long id) {
        return userService.findById(id);
    }
}
