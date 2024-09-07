package aleksey.client;

import aleksey.model.CompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@RequiredArgsConstructor
public class CompanyClientImpl implements CompanyClient {

    private final RestClient restClient;


    @Override
    public Optional<CompanyResponse> findByLastName(Long id, String name) {
        try {
            return Optional.ofNullable(this.restClient.get()
                    .uri("/?name={name}&id={id}", name, id)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(CompanyResponse.class));
        } catch (HttpClientErrorException.NotFound exception) {
            return Optional.empty();
        }
    }
}
