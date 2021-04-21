import processing.core.PApplet;

public class GridSpace {

float x,y,width,height;
PApplet p;
boolean pressed = false;

FurnitureTypes gridType = FurnitureTypes.empty;
ImageLoader imgLoad;


GridSpace(float x, float y, float width, float height, PApplet p, ImageLoader imgLoad,Inventory inventory){
this.x = x;
    this.y = y;
this.width = width;
this.height = height;
this.p=p;
this.imgLoad = imgLoad;

}


void changeGridType(FurnitureTypes newGridType){

gridType = newGridType;



}
    void pressed(boolean check,float mX,float mY,Inventory inventory){
        if(check) {
            if(((mX <(x+width)) && ((x< mX)) )&& ((mY < y + height) && (mY > y))){
                for (int i = 0; i<inventory.toolBarList.size();i++ )
                    if(inventory.toolBarList.get(i).selected == true)
                        if(gridType != inventory.itemList.get(i).getType())
             changeGridType(inventory.itemList.get(i).getType());
                        else
                            changeGridType(FurnitureTypes.empty);
             }


        }

    }

void display(){







    switch(gridType){
        case empty:{
            p.rect(x,y,width,height);

        }break;

        case door:{
            p.image(imgLoad.door,x,y,width,height);

        }break;

        case wall:{
            p.image(imgLoad.wall,x,y,width,height);

        }break;

        case shopCounter:{
            p.image(imgLoad.shopCounter,x,y,width,height);

        }break;

        case cashRegister:{
            p.image(imgLoad.cashRegister,x,y,width,height);

        }break;



    }







    }





}
