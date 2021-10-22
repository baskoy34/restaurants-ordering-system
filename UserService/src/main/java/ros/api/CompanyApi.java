package ros.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ros.services.CompanyService;

@RequestMapping("/company")
@RestController
@RequiredArgsConstructor
public class CompanyApi {

}
