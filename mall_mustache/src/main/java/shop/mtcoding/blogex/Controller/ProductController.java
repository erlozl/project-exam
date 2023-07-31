package shop.mtcoding.blogex.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blogex.model.Product;
import shop.mtcoding.blogex.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/regist")
    public String registPage() {
        return "regist";
    }

    @GetMapping("/product/{id}")
    public String detailPage(@PathVariable Integer id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @PostMapping("/product")
    public String regist(String name, Integer price, Integer qty) {
        productRepository.save(name, price, qty);
        return "redirect:/";
    }

    @PostMapping("/product/update")
    public String update(Product product) {
        productRepository.update(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete")
    public String delete(Integer id) {
        productRepository.delete(id);
        return "redirect:/";
    }
}
