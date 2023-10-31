package com.crudjsp.demo_crud.controller;



import com.crudjsp.demo_crud.entity.Product;
import com.crudjsp.demo_crud.repoistory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
/*  @RequestMapping("/person")
    public String showPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        model.addAttribute("persons", personService.getAllPersons());
        return "person";
    }*/
@GetMapping("/")
public String listProducts(Model model) {
    List<Product> products = productRepository.findAll();
    model.addAttribute("products", products); // "products" should be added first
    model.addAttribute("product", new Product()); // Add other attributes if needed
    return "products";
}
//@GetMapping("/")
//public ModelAndView listProducts() {
//    List<Product> products = productRepository.findAll();
//    ModelAndView modelAndView = new ModelAndView("products");
//    modelAndView.addObject("products", products);
//    modelAndView.addObject("product", new Product());
//    return modelAndView;
//}
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            model.addAttribute("product", product);
        }
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products/";
    }
    @GetMapping("/example")
    public String example(Model model){
        model.addAttribute("message", "hello ,JSP!");
        return "example";
    }
}
