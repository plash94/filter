package pojo;

import java.util.List;

/**
 * Created by shiva.b on 08/11/16.
 */
public class FilterRequestObject {
    private List<String> brandList;
    private List<String> colorList;
    private List<String> waistList;

    public List<String> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<String> brandList) {
        this.brandList = brandList;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }

    public List<String> getWaistList() {
        return waistList;
    }

    public void setWaistList(List<String> waistList) {
        this.waistList = waistList;
    }
}
