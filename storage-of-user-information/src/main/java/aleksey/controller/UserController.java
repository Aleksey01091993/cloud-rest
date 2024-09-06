package aleksey.controller;

import aleksey.dto.UserResponse;
import aleksey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{firstName}")
    public UserResponse getByFirstName(@PathVariable String firstName) {
        return userService.getByFirstName(firstName);
    }
}
