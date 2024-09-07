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

    public UserResponse getByLastName(String lastName) {
        return UserMapper.mapOfUser(userRepository.findByLastName(lastName)
        .orElseThrow(() -> new RuntimeException("User not found")));
    }



}
