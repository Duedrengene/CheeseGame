import processing.core.PApplet;

import java.util.ArrayList;

public class GridCreater {
ImageLoader imgLoad;
int gridNumber = 10;


    ArrayList<GridSpace> createGrid(int width, int height, PApplet p,ImageLoader imgLoad,Inventory inventory){
        this.imgLoad = imgLoad;

        ArrayList<GridSpace> grid = new ArrayList<>();
        for(int i =0;i<gridNumber;i++){
        grid.add(new GridSpace((width/gridNumber)*i,(height/gridNumber)*0,width/gridNumber,height/gridNumber,p,imgLoad,inventory));
        for(int i2 = 1;i2<gridNumber ;i2++)
            grid.add(new GridSpace((width/gridNumber)*i,(height/gridNumber)*i2,width/gridNumber,height/gridNumber,p,imgLoad,inventory));
        }

    return grid;




    }



}
