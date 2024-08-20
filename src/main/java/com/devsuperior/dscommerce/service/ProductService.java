package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> productOptional = this.repository.findById(id);
        Product product = productOptional.get();
        ProductDTO productDTO = new ProductDTO(product);
        return productDTO;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        return this.repository.findAll().stream().map(x -> new ProductDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = this.repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }
}
