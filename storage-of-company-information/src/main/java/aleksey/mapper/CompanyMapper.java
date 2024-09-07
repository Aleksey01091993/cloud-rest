package aleksey.mapper;

import aleksey.dto.CompanyResponse;
import aleksey.model.Company;

public class CompanyMapper {

    public static CompanyResponse mapOfCompany(final Company company) {
        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getBudget(),
                company.getEmployees()
        );
    }
}
