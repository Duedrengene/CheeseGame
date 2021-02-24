import processing.core.PApplet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Furniture {

    PApplet p;
    Types types;
    String furnitureType;
    String[] furnitureTypes  ={"shopSlot","cashRegister"};
    int x,y;

    Furniture(PApplet p, Types types,String furnitureType,int x,int y){
        this.p = p;
        this.furnitureType = furnitureType;
        this.x = x;
        this.y = y;
        this.types = types;
    }

    void furnitureFunction(){
        if(furnitureType.equals( furnitureTypes[0])){
           p.rect(x,y,50,50);




        }

    }


}
