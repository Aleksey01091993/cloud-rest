package aleksey.model;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        Integer numberPhone
) {
}
