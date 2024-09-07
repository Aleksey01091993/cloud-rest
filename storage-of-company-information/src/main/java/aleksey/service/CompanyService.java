package aleksey.service;

import aleksey.dto.CompanyResponse;
import aleksey.mapper.CompanyMapper;
import aleksey.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;


    public CompanyResponse getCompanyIdOrName(Long id, String name) {
        return CompanyMapper.mapOfCompany(
                companyRepository.findByIdOrName(id, name)
                        .orElseThrow(() -> new RuntimeException("company not found"))
        );
    }


}
