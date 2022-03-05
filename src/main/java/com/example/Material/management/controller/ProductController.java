package com.example.Material.management.controller;
import com.example.Material.management.entity.Product;
import com.example.Material.management.service.base.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product")
    public String list(Model model){
        model.addAttribute("products",productService.findAllProduct());
        return "product";
    }
    @GetMapping("/product/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/product";
        }

        model.addAttribute("products", productService.SearchProduct(term));
        return "product";
    }

    @GetMapping("/product/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "formProduct";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", productService.findOneProduct(id));
        return "formProduct";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.deleteProduct(id);
        redirect.addFlashAttribute("successMessage", "Deleted product successfully!");
        return "redirect:/product";
    }

    @PostMapping("/product/save")
    public String save(@Valid Product product, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "formProduct";
        }
        productService.saveProduct(product);
        redirect.addFlashAttribute("successMessage", "Saved product successfully!");
        return "redirect:/product";
    }

}
