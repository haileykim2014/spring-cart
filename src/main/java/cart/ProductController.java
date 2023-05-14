package cart;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity<List<Product>> getAll() {
    List<Product> products = productService.getAll();
    return ResponseEntity.ok(products);
  }

  @PutMapping(value = "/products")
  public void updateProduct(@RequestBody ProductUpdateDto updateDto) {
    productService.updateProduct(updateDto);
  }

  @DeleteMapping("/products/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.delete(id);
  }
}
