import java.util.ArrayList;

public class Shop {

ArrayList<Furniture> furnitureList;


    Shop(ArrayList<Furniture> furnitureList){
        this.furnitureList = furnitureList;



    }

    void shopFunction(){
        for(int i = 0;i<furnitureList.size();i++){
            furnitureList.get(i).display();



        }

    }
}