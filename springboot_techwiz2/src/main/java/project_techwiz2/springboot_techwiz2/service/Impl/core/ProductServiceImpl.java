package project_techwiz2.springboot_techwiz2.service.Impl.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.core.Product;
import project_techwiz2.springboot_techwiz2.repository.core.ProductRepository;
import project_techwiz2.springboot_techwiz2.service.ProductService;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProduct() {
        try{
            List<Product> list = productRepository.getAllProductStatus();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getProById(int pro_id) {
        try{
            Product product = productRepository.findById(pro_id).get();
            return product;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveProduct(Product product) {
        try {
            product.setCreated(new Date());
            product.setUpdated(new Date());
            productRepository.save(product);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int pro_id) {
        try{
            Product product = productRepository.findById(pro_id).get();
            product.setStatus(3);
            product.setUpdated(new Date());
            productRepository.save(product);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        try{
            product.setUpdated(new Date());
            productRepository.save(product);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.productRepository.findPaginateProductStatus(pageable);
    }
}
