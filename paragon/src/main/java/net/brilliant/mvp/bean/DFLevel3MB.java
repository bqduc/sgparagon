package net.brilliant.mvp.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

/**
 * Created by rafael-pestano on 22/06/17.
 */
@Named("dfLevel3MB")
@ViewScoped
public class DFLevel3MB implements Serializable {

    private String val;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void closeDialog() {
        //pass back to level 2
        PrimeFaces.current().dialog().closeDynamic(val);
    }
}
