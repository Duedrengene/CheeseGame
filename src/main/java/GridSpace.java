import processing.core.PApplet;

import java.util.ArrayList;

public class GridSpace {

float startX,startY,width,height;
PApplet p;
GridSpace(float x, float y, float width, float height, PApplet p){
startX = x;
startY = y;
this.width = width;
this.height = height;
this.p=p;
}

void display(){
    p.rect(startX,startY,width,height);


    }

}
