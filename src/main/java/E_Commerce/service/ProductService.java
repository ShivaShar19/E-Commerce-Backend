package E_Commerce.service;

import E_Commerce.dto.ProductRequest;
import E_Commerce.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductRequest request);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);

    List<Product> searchProducts(String keyword);

}
