import processing.core.PApplet;

import java.util.ArrayList;

public class GridCreater {

int gridNumber = 10;


    ArrayList<GridSpace> createGrid(int width, int height, PApplet p){
        ArrayList<GridSpace> grid = new ArrayList<>();
        for(int i =0;i<gridNumber;i++){
        grid.add(new GridSpace((width/gridNumber)*i,(height/gridNumber)*0,width/gridNumber,height/gridNumber,p));
        for(int i2 = 1;i2<gridNumber ;i2++)
            grid.add(new GridSpace((width/gridNumber)*i,(height/gridNumber)*i2,width/gridNumber,height/gridNumber,p));;
        }

    return grid;




    }



}
