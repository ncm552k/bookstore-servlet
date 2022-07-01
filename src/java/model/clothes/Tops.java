/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clothes;

/**
 *
 * @author Admin
 */
public class Tops extends Clothes{
    private String neckLine;
    private String occasion;

    public Tops( String neckLine, String occasion) {       
        this.neckLine = neckLine;
        this.occasion = occasion;
    }

    public Tops() {
    }


    public String getNeckLine() {
        return neckLine;
    }

    public void setNeckLine(String neckLine) {
        this.neckLine = neckLine;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }
          
}
