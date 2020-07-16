 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Product;
import entity.SubCategory;
import java.util.List;
import javax.faces.model.SelectItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.NewHibernateUtil;

/**
 *
 * @author khushboo
 */
public class ListDao {
        public List catList() {
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList = session.createQuery("SELECT al.catName FROM Category al").list();
        cList.toString();
        session.close();

        return cList;
    }
        
    public List<Category> catListByName(String name) {
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList = session.createQuery("SELECT al FROM Category al where lower(catName)='" + name.toLowerCase() + "'").list();
        cList.toString();
        session.close();

        return cList;
    }
        
     public List<SubCategory> SubcatListByName(String name) {
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<SubCategory>cList = session.createQuery("SELECT al FROM SubCategory al where lower(subCatName)='" + name.toLowerCase() + "'").list();
        cList.toString();
        session.close();

        return cList;
    }
     
    public List subcatList(String name) {
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<SubCategory> cList = session.createQuery("SELECT al.subCatName FROM SubCategory al where al.category.catId IN (SELECT a.catId FROM Category a where lower(a.catName)='" + name.toLowerCase() + "')").list();
        cList.toString();
        session.close();

        return cList;
    }
        
   
        
                /**    public List subcatList(String name) {
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList = session.createQuery("SELECT al.subCatName FROM SubCategory al where al.category.catId IN (SELECT a.catId FROM Category a where lower(a.catName)='" + name.toLowerCase() + "')").list();
        cList.toString();
        session.close();

        return cList;
    }*/
        
    public List allProductList(){
        SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Product> cList = session.createQuery("SELECT al FROM Product al").list();
        cList.toString();
        session.close();

        return cList;
    }

    public List<SelectItem> zoneList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**public List<Product> allProductList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
            
    
}
