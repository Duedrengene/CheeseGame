import java.util.ArrayList;

public class Shop {

    ArrayList<Furniture> furnitureList;
    ArrayList<GridSpaceDefault> grid;


    Shop(ArrayList<Furniture> furnitureList, ArrayList<GridSpaceDefault> grid) {
        this.furnitureList = furnitureList;
        this.grid = grid;


    }

    void shopFunction(Main m) {
m.player.display();
        float nearestFurniture= 75;
        int furnitureCount =-1;
        for (int i = 0; grid.size() > i; i++) {
        m.player.p.fill(0);
            grid.get(i).display();
            if(grid.get(i).furniture != null){
            float temp = grid.get(i).furniture.playerNearby(m.player,grid.get(i).x,grid.get(i).y,m.player.width,m.player.height,grid.get(i).width,grid.get(i).height);
            if (temp !=-1&&temp<nearestFurniture) {
                nearestFurniture = temp;
                furnitureCount = i;

            }

        }}
        if (m.player.activate&&furnitureCount!=-1)
            grid.get(furnitureCount).furniture.function(m);

        m.player.activate = false;

    }
}