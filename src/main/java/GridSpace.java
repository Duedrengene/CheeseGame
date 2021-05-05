import processing.core.PApplet;

public class GridSpace {

float x,y,width,height;
PApplet p;
boolean pressed = false;

FurnitureTypes gridType = FurnitureTypes.empty;
Furniture furniture;
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

switch (gridType) {

    case empty:{

        furniture = null;

    }break;

    case door:{
        furniture= new Door(imgLoad.door);

    }break;

    case cashRegister:{
        furniture= new CashRegister();

    }break;

    case shopCounter:{
        furniture = new ShopCounter();
    }break;

    case wall:{}
    furniture = new Wall(imgLoad.wall);

}

}
    void pressed(boolean check,float mX,float mY,Inventory inventory){
        if(check) {
            if(((mX <(x+width)) && ((x< mX)) )&& ((mY < y + height) && (mY > y))){
                for (int i = 0; i<inventory.buildBarList.size();i++ )
                    if(inventory.buildBarList.get(i).selected == true)
                        if(gridType != inventory.furnitureList.get(i).getType())
             changeGridType(inventory.furnitureList.get(i).getType());
                        else
                            changeGridType(FurnitureTypes.empty);
             }


        }

    }

void display(){


if(gridType != FurnitureTypes.empty)
    furniture.display(p,x,y);
else
    p.rect(x,y,width,height);






    }







    }






