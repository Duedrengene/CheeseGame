import java.util.ArrayList;

public class Shop {

ArrayList<FurnitureB> furnitureBList;


    Shop(ArrayList<FurnitureB> furnitureBList){
        this.furnitureBList = furnitureBList;



    }

    void shopFunction(){
        for(int i = 0; i< furnitureBList.size(); i++){
            furnitureBList.get(i).display();



        }

    }
}