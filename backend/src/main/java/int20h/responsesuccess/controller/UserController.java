package int20h.responsesuccess.controller;

import int20h.responsesuccess.entity.User;
import int20h.responsesuccess.exception.EntityNotFoundException;
import int20h.responsesuccess.model.UserRequestDto;
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
    public int createUser(final @RequestBody UserRequestDto dto) {
        User user = new User(dto);
        userService.create(user);
        return Response.SC_CREATED;
    }

    @PutMapping
    public int editUser(final @RequestBody UserRequestDto dto) {

        if (dto != null && dto.getId() != null && userService.existsById(dto.getId())) {
            User user = new User(dto);
            userService.update(user);
        } else {
            throw new EntityNotFoundException("User", dto != null && dto.getId() != null ? dto.getId().toString() : null);
        }
        return Response.SC_OK;
    }

    @GetMapping("/{id}")
    public User getUserById(final @PathVariable Long id) {
        return userService.findById(id);
    }
}
