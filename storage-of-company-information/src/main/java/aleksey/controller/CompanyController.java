package aleksey.controller;

import aleksey.dto.CompanyResponse;
import aleksey.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/")
    public CompanyResponse getByLastName(@RequestParam @Nullable String name,
                                         @RequestParam @Nullable Long id) {
        return companyService.getCompanyIdOrName(id, name);
    }

}
