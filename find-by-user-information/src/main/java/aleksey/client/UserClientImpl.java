package aleksey.client;

import aleksey.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@RequiredArgsConstructor
public class UserClientImpl implements UserClient {

    private final RestClient restClient;


    @Override
    public Optional<UserResponse> findByLastName(String lastName) {
        try {
            return Optional.ofNullable(this.restClient.get()
                    .uri("/{lastName}", lastName)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(UserResponse.class));
        } catch (HttpClientErrorException.NotFound exception) {
            return Optional.empty();
        }
    }
}
