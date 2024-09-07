package aleksey.client;

import aleksey.model.UserResponse;

import java.util.Optional;

public interface UserClient {
    Optional<UserResponse> findByLastName(String lastName);
}
