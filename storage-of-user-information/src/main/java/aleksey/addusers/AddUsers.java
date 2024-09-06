package aleksey.addusers;

import aleksey.model.User;
import aleksey.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class AddUsers {
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.saveAll(
                IntStream.rangeClosed(1, 5)
                        .mapToObj(i -> User.builder()
                                .firstName("firstName №" + i)
                                .lastName("lastName №" + i)
                                .numberPhone(1234567 + i)
                                .build())
                        .toList()

        );
    }
}
