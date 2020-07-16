/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.ListDao;
import entity.Product;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author khushboo
 */
@ManagedBean
@SessionScoped
public class DisplayProductMB {
    Product product=new Product();
    private Product SelectedProduct;

    public Product getSelectedProduct() {
        return SelectedProduct;
    }

    public void setSelectedProduct(Product SelectedProduct) {
        this.SelectedProduct = SelectedProduct;
    }
    
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    public List<Product> getallProduct(){
    List<Product> plist = new ListDao().allProductList();
    return plist;
    }
    
}
