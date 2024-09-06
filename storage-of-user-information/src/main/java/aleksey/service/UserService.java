package aleksey.service;

import aleksey.dto.UserResponse;
import aleksey.mapper.UserMapper;
import aleksey.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getByFirstName(String firstName) {
        return UserMapper.mapOfUser(userRepository.findByFirstName(firstName)
        .orElseThrow(() -> new RuntimeException("User not found")));
    }



}
