package ros.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ros.dtos.ProductDto;
import ros.services.ProductServiceImpl;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
public class ProductApi {
    private final ProductServiceImpl productService;



}
