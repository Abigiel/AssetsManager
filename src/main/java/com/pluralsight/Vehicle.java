package com.pluralsight;

import java.time.LocalDate;
import java.time.Year;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue(){
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        double value = getOriginalCost();

        int yearDiff = currentYear- getYear();

        if(yearDiff>=0 && yearDiff <= 3){
            value-= (0.03* yearDiff) * getOriginalCost();
        }
        if(yearDiff>=4 && yearDiff <= 6){
            value-= (0.06* yearDiff) * getOriginalCost();
        }
        if(yearDiff>=7 && yearDiff <= 10){
            value-= (0.08* yearDiff) * getOriginalCost();
        }
        if(yearDiff>=10){
            value-= 1000;
        }

        if(getOdometer()> 100000 && (!makeModel.toLowerCase().contains("honda"))
              && (!makeModel.toLowerCase().contains("toyota")) ){
            value-= (0.25) * getOriginalCost();
        }
        return value;

    }
}
