import processing.core.PApplet;

import java.util.ArrayList;

public class GridCreater {
ImageLoader imgLoad;



    ArrayList<GridSpaceDefault> createGrid(int width, int height, PApplet p, ImageLoader imgLoad, Inventory inventory, int gridNumber, boolean fill , int offset){
        this.imgLoad = imgLoad;

        ArrayList<GridSpaceDefault> grid = new ArrayList<>();
        for(int i =0;i<gridNumber;i++){
        grid.add(new GridSpaceDefault(offset+(width/gridNumber)*i,offset+(offset+height/gridNumber)*0,width/gridNumber,height/gridNumber,p,imgLoad,inventory));
        for(int i2 = 1;i2<gridNumber ;i2++)
            grid.add(new GridSpaceDefault(offset+(width/gridNumber)*i,offset+(height/gridNumber)*i2,width/gridNumber,height/gridNumber,p,imgLoad,inventory));
        }

    return grid;




    }



}
