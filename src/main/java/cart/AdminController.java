package cart;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  private final ProductService productService;

  public AdminController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/admin")
  public String getAll(Model model) {
    List<Product> products = productService.getAll();
    model.addAttribute("products", products);
    return "admin";
  }
}
