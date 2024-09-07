package aleksey.controller;

import aleksey.client.CompanyClient;
import aleksey.model.CompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyClient companyClient;


    @GetMapping("/")
    public CompanyResponse getByLastName(@RequestParam @Nullable String name,
                                   @RequestParam @Nullable Long id) {
        return companyClient.findByLastName(id, name)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
