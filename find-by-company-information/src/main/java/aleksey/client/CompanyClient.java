package aleksey.client;

import aleksey.model.CompanyResponse;

import java.util.Optional;

public interface CompanyClient {
    Optional<CompanyResponse> findByLastName(Long id, String name);
}
