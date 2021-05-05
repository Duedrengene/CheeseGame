import java.util.ArrayList;

public class Shop {

ArrayList<Furniture> furnitureList;
    ArrayList<GridSpace> grid;

    Shop(ArrayList<Furniture> furnitureList,ArrayList<GridSpace> grid){
        this.furnitureList = furnitureList;
        this.grid = grid;


    }

    void shopFunction(){/*
        for(int i = 0; i< furnitureList.size(); i++){
            furnitureList.get(i).display();
        }
*/
        for(int i=0;grid.size()>i;i++){

            grid.get(i).display();

        }

    }
}