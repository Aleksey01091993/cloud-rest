package aleksey.addcompany;

import aleksey.model.Company;
import aleksey.repository.CompanyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class AddCompany {
    private final CompanyRepository companyRepository;

    @PostConstruct
    public void init() {
        companyRepository.saveAll(
                IntStream.rangeClosed(1, 5)
                        .mapToObj(i -> Company.builder()
                                .name("name №" + i)
                                .budget(10.1 + i)
                                .employees(
                                        List.of(i, 6, 7, 8, 9)
                                )
                                .build())
                        .toList()

        );
    }
}
