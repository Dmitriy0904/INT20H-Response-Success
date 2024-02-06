package int20h.responsesuccess.controller;

import int20h.responsesuccess.service.AuctionService;
import int20h.responsesuccess.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //TODO: ADD ENDPOINTS

}
