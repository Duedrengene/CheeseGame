import processing.core.PApplet;

import java.util.ArrayList;

public class GridSpace {

float x,y,width,height;
PApplet p;
boolean pressed = false;


GridSpace(float x, float y, float width, float height, PApplet p){
this.x = x;
    this.y = y;
this.width = width;
this.height = height;
this.p=p;
}

void display(){


    if (pressed){
    p.fill(255,0,0);
    //p.println(x+" "+y);

    }else{
        p.fill(255);

    }

    p.rect(x,y,width,height);


    }

    void pressed(boolean check,float mX,float mY){
    if(check) {
    if(((mX <(x+width)) && ((x< mX)) )&& ((mY < y + height) && (mY > y))){
        pressed = true;
    } }
        else{ pressed = false;


    }

    }



}
