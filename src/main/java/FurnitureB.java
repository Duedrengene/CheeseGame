import processing.core.PApplet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FurnitureB {

    PApplet p;
    Types furnitureType;
    ArrayList<GridSpace> grid = new ArrayList();
    int x,y;

    FurnitureB(PApplet p, Types furnitureType, int x, int y){
        this.p = p;
        this.furnitureType = furnitureType;
        this.x = x;
        this.y = y;
    }


    void display(){
        if(furnitureType == Types.shopCounter){
        p.rect(x,y,50,50);


        }


    }

    void furnitureFunction(){
        if(furnitureType == Types.shopCounter){
           p.rect(x,y,50,50);




        }

    }


}
