package com.zb.crud.controller;

import com.zb.crud.model.ProductDTO;
import com.zb.crud.repository.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/products") //  definir direccion raiz de los servicios
public class ProductController {

    @Autowired  //  facilita la inyecci[on de atributos
    private IProductDAO repository;


    //  crear un product v[alido de acuerdo al modelo
    @PostMapping("/save/product")
    public ProductDTO create(@Validated @RequestBody ProductDTO p){
        return repository.insert(p);
    }


    //  listar los products registrados
    @GetMapping("/")
    public List<ProductDTO> readAll(){
        return repository.findAll();
    }


    //  editar product
    @PutMapping("/product/update/{id}")
    public ProductDTO update(@PathVariable String id, @Validated @RequestBody ProductDTO p){
        return repository.save(p);
    }


    //  eliminar product
    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable String id){
        repository.deleteById(id);
    }

}


