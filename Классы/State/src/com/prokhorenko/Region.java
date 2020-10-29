package com.prokhorenko;

import java.util.Arrays;

public class Region {
    private District[] districts;
    private double area = 0;
    private City districtCenter;

    public Region(District[] districts, City districtCenter) {
        this.districts = districts;
        this.districtCenter = districtCenter;
        for (int i = 0; i < districts.length; i++) {
            area += districts[i].getArea();
        }
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    public City getDistrictCenter() {
        return districtCenter;
    }

    public void setDistrictCenter(City districtCenter) {
        this.districtCenter = districtCenter;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Region{" +
                "districts=" + Arrays.toString(districts) +
                ", area=" + area +
                ", districtCenter=" + districtCenter +
                '}';
    }
}
