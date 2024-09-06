package aleksey.mapper;

import aleksey.dto.UserResponse;
import aleksey.model.User;

public class UserMapper {

    public static UserResponse mapOfUser(final User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getFirstName(),
                user.getNumberPhone()
        );
    }
}
