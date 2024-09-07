package aleksey.controller;

import aleksey.client.UserClient;
import aleksey.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserClient userClient;


    @GetMapping("{lastName}")
    public UserResponse getUser(@PathVariable("lastName") String lastName) {
        return userClient.findByLastName(lastName)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
