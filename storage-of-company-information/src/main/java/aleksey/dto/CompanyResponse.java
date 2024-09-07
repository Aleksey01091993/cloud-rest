package aleksey.dto;

import java.util.List;

public record CompanyResponse(
        Long id,
        String name,
        Double budget,
        List<Integer> employees
) {
}
