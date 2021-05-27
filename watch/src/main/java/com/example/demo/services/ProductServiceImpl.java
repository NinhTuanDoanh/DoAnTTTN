package com.example.demo.services;

import com.example.demo.Model.dto.ProductsDto;
import com.example.demo.Model.mapper.ProductMapper;
import com.example.demo.entity.ProductImage;
import com.example.demo.entity.Products;
import com.example.demo.repository.ProductImageRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

@Component
public class ProductServiceImpl implements ProductService{
    public static final String BASE_IMAGE_URL="assets/img/product/";
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Override
    public List<Products> listProducts() {
        Pageable paging= (Pageable) PageRequest.of(0,12);
        Page<Products> pagedResult = productRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Products>();
        }
    }

    @Override
    public List<Products> listAdminProducts() {
        List<Products> products=productRepository.findAll();
        return  products;
    }

    @Override
    public void save(Products products) {
         productRepository.save(products);
    }

    @Override
    public Products getProductById(Long id) {

        return productRepository.findById(id).get();
    }

    @Override
    public Products getInfor(Long id) {
        Products products= productRepository.findById(id).get();
        return products;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Products> listProductsPageable(int pageNo, int pageSize) {
        Pageable paging= (Pageable) PageRequest.of(pageNo-1,pageSize);
        return this.productRepository.findAll(paging);

    }

    //admin
    @Override
    public String createProductByAdmin(ProductsDto productsDto, MultipartFile[] files) {
        String result = "addproduct";
        String error = null;
        Products product = null;
        System.out.println(productsDto);
        try {
            Products productEntity = ProductMapper.toProductDto(productsDto);
            // save product to db
            productEntity = productRepository.save(productEntity);
            createImagesInProduct(files,productEntity.getProductid());
            result = "redirect:/productmanager";
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public List<Products> getRelatedProduct(Long manufac) {
        return productRepository.findAllByManufacturer(manufac);
    }

    public void createImagesInProduct(MultipartFile[] files, Long productId) {

        try {
            List<ProductImage> images = new ArrayList<>();
            int i = 0;
            int length = files.length;
            String fileName;
            // get product by id in db
            Products product = productRepository.findById(productId).orElseGet(null);
            if (ObjectUtils.isEmpty(product)) {
                throw new Exception();
            }

            for (i = 0; i < length; i++) {

                ProductImage image = new ProductImage();
                StringBuilder imagePath = new StringBuilder();
                // get file name in file
                fileName = files[i].getOriginalFilename();
                // set image path
                imagePath.append(UUID.randomUUID().toString());
                imagePath.append(fileName.substring(fileName.length() - 8));


                File convFile = new File("src/main/resources/static/assets/img/product/" + imagePath.toString());
                if (convFile.createNewFile()) {
                    FileOutputStream fos = new FileOutputStream(convFile);
                    fos.write(files[i].getBytes());
                    fos.close();
                }

                // set data to list image
                image.setUrl(BASE_IMAGE_URL + imagePath.toString());
                image.setProducts(product);

                images.add(image);
            }
//            // delete all image of product
//            imagesRepository.deleteAll(imagesRepository.findByProduct(product));
//
            // save list image in db
            productImageRepository.saveAll(images);
//
//            // update info product
//            product.setImage(images.get(0).getPath());
//
//            // save product
//            productRepository.save(product);
        } catch (Exception e) {

        }
    }



}
