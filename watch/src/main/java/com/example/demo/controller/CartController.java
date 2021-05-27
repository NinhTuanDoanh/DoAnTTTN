package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Products;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String viewAdd(ModelMap modelMap, HttpSession session, @RequestParam("id") Long productId){
        HashMap<Long, Cart> cartItems=(HashMap<Long, Cart>) session.getAttribute("myCartItems");
        int price;
        if(cartItems ==null){
            cartItems=new HashMap<>();
        }
        Products products=productService.getProductById(productId);
        if(products !=null){
            if(cartItems.containsKey(productId)){
                Cart item=cartItems.get(productId);
                item.setProduct(products);
                item.setQuantity(item.getQuantity() +1);
                cartItems.put(productId,item);
            }
            else {
                Cart item = new Cart();
                item.setProduct(products);
                item.setQuantity(1);
                cartItems.put(productId, item);
            }
        }

        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "redirect:/cart";
    }
    @GetMapping("/sub")
    public String viewUpdate(ModelMap modelMap, HttpSession session) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return "redirect:/cart";
    }
    @GetMapping("/remove")
    public String viewRemove(ModelMap mm, HttpSession session, @RequestParam("id") long productId) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productId)) {
            cartItems.remove(productId);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "redirect:/cart";
    }

    @GetMapping("update")
    public String updateToCart(Model model, HttpSession session,
      @RequestParam("flag") int flag, @RequestParam("id") Long id)
    {
        HashMap<Long, Cart> cartItems=(HashMap<Long, Cart>) session.getAttribute("myCartItems");
        Products products=productService.getProductById(id);
        if(cartItems.containsKey(id)){
            Cart item = cartItems.get(id);
            if(flag==0) {

                item.setQuantity(item.getQuantity() - 1);

            }else if(flag==1){
                item.setQuantity(item.getQuantity() + 1);
            }
            cartItems.put(id, item);
        }
        return "redirect:/cart";
    }
    private double totalPrice(HashMap<Long, Cart> cartItems) {
        int count = 0;
        for (Map.Entry<Long, Cart> list : cartItems.entrySet()) {
            if(list.getValue().getProduct().getSale()==0) {
                count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
            }else{
                count+=((list.getValue().getProduct().getPrice()*(100-list.getValue().getProduct().getSale()))/100)*list.getValue().getQuantity();
            }
        }
        return count;
    }
    @GetMapping("/clear")
    public String clear(HttpSession session){
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        cartItems.clear();
        return "redirect:/cart";
    }
}
