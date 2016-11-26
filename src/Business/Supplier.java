/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

/**
 *
 * @author PedroJosé
 */
public class Supplier implements Serializable{
    private String supplierName;
    private boolean logo;
    private String pathToImg;

    public Supplier() {
    }

    public Supplier(String supplierName, boolean logo, String base64Logo) {
        this.supplierName = supplierName;
        this.logo = logo;
        this.pathToImg = base64Logo;
    }
    
    
    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @return the logo
     */
    public boolean isLogo() {
        return logo;
    }

    /**
     * @return the base64Logo
     */
    public String getPathToImg() {
        return pathToImg;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(boolean logo) {
        this.logo = logo;
    }

    /**
     * @param pathToImg the base64Logo to set
     */
    public void setPathToImg(String pathToImg) {
        this.pathToImg = pathToImg;
    }
    
}
