package com.pluralsight;


import java.util.ArrayList;

public class AssetManager {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        Vehicle myCar = new Vehicle("Car", "2022-09-05",30000, "Jeep Wrangler", 2022,5000);
        Vehicle secondCar = new Vehicle("Car", "2019-05-23",7000, "Toyota Prius", 2010,110000);

        House home = new House("Home", "2023-08-15", 355000,"1000 Zen St.", 2,2500, 7000);
        House beachHouse = new House("Beach House", "2023-11-21", 475000,"1000 Willow St.", 1,3500, 10000);
//
        assets.add(myCar);
        assets.add(secondCar);
        assets.add(home);
        assets.add(beachHouse);


        for (Asset asset : assets) {
            System.out.printf("Description: %s | Date Acquired: %s | Original Cost: %.2f \n", asset.getDescription(), asset.getDateAcquired(), asset.getOriginalCost());
        }
        for (Asset asset : assets) {
            if(asset instanceof House) {
                System.out.printf("House Address: %s \n", ((House) asset).getAddress());
            }else if(asset instanceof Vehicle){
                System.out.printf("Vehicle: %d %s \n",((Vehicle) asset).getYear(),((Vehicle) asset).getMakeModel());
            }
            }


    }
}
