/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import dao.ListDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author khushboo
 */
@ManagedBean
@SessionScoped
public class CartHandlerMB {
    List<CartBind> cartList = new ArrayList<CartBind>();
    
    String productname;
    int productid;
    int quantity=1;
    double prize;
    double total;
    int cartsize;
    String item="item";
    String selectedzone;
    
    Map<Integer, CartBind> map = new HashMap<Integer, CartBind>();

    public String getSelectedzone() {
        return selectedzone;
    }

    public void setSelectedzone(String selectedzone) {
        this.selectedzone = selectedzone;
    }
    
    
    

    public List<CartBind> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartBind> cartList) {
        this.cartList = cartList;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
    
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Map<Integer, CartBind> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartBind> map) {
        this.map = map;
    }

    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String processCart(int qty){
    
    CartBind cb = new CartBind();
    
    quantity=qty;
    cb.setProductname(productname);
        System.out.println(quantity+"------------");
    cb.setQuantity(quantity);
    cb.setPrize(prize);
    cb.setTotal(quantity*prize);
    cartList.add(cb);
    
    map.put(productid, cb);
    cartsize = cartList.size();
    
    if(cartsize>1){
    item="items";
    }
    return null;
    }
    
    public List<SelectItem> getZoneName(){
    
    List<SelectItem> zonename = new ListDao().zoneList();
    return zonename;
    }
  
}
