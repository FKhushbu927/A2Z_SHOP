
package addhandler;

import dao.AddDao;
import dao.ListDao;
import entity.Product;
import entity.SubCategory;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author khushboo
 */
@ManagedBean
@SessionScoped
public class ProductMB {
    Product product=new Product();
    SubCategory subcat=new SubCategory();
    String subcatname;
    String catname="";
    List<SubCategory> listSubCat;
    UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }
    
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public List<SubCategory> getListSubCat() {
        return listSubCat;
    }

    public void setListSubCat(List<SubCategory> listSubCat) {
        this.listSubCat = listSubCat;
    }
    
        public String addProduct() {
            upload();

        listSubCat = new ListDao().SubcatListByName(subcatname);
        
        //System.out.println(listCat.get(0).getCatId());
        
        //category.setCatId(listCat.get(0).getCatId());
        subcat.setSubCatId(listSubCat.get(0).getSubCatId());
        product.setSubCategory(subcat);
        
        /**subcat.setSubCatName(subcat.getSubCatName());
        subcat.setSubCatDesc(subcat.getSubCatDesc());*/
        
        product.setProName(product.getProName());
        product.setProQty(product.getProQty());
        product.setProPrize(product.getProPrize());
        product.setProUrl(product.getProUrl());
        product.setProDesc(product.getProDesc());
        
        boolean status = new AddDao().addProduct(product);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved ", ""));
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data Not Saved ", ""));

        }

        return null;
    }
        
        public void upload(){
            if (file != null) {
                try {
                    FacesContext context = FacesContext.getCurrentInstance();
                    ServletContext servletcontext = (ServletContext) context.getExternalContext().getContext();
                    String dbpath = servletcontext.getRealPath("/");
                    String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                    String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                    String mainURLPath = buildcut.substring(0, buildcut.lastIndexOf("\\"));

                    InputStream inputstrim = file.getInputstream();
                    String path = mainURLPath+"\\A2Z_Shop\\web\\resources\\images\\"+file.getFileName();
                    
                    File destFile=new File(path);
                    if(!destFile.exists()){
                        FileUtils.copyInputStreamToFile(inputstrim, destFile);
                    
                    }
                    product.setProUrl(file.getFileName().toString());
                  
                } catch (Exception e) {
                              e.printStackTrace();
                }
            }


}
        
    public List<SelectItem> getSubCategoryName() {
        List<SelectItem> subcatname = new ListDao().subcatList(catname);
        return subcatname;
    }
    
    
    
}
