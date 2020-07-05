package net.brilliant.mvp.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MegaMenuMB implements Serializable {

    private String orientation = "horizontal";
 
    public String getOrientation() {
        return orientation;
    }
 
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

}
