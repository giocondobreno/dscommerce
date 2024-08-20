package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ProductDTO findByid(@PathVariable Long id){
        ProductDTO  productDTO = this.service.findById(id);
        return productDTO;
    }

    @GetMapping()
    public List<ProductDTO> findAll(){
        List<ProductDTO> liist = this.service.findAll();
        return liist;
    }

    @GetMapping("pageable")
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<ProductDTO> liist = this.service.findAll(pageable);
        return liist;
    }

}
