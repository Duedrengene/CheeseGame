import processing.core.PApplet;

public class GridSpace {


    float x,y,width,height;
    PApplet p;
    boolean pressed = false;

    boolean hasFurniture ;

    Items itemGridType = Items.empty;
    FurnitureTypes furnitureGridType = FurnitureTypes.empty;
    Furniture furniture;
    Item item;
    ImageLoader imgLoad;
    Inventory inventory;


    void changeGridType(Items newGridType) {

    }

    void pressed(boolean check,float mX,float mY){
        if(check) {
            if(((mX <(x+width)) && ((x< mX)) )&& ((mY < y + height) && (mY > y))){
                function();
            }


        }

    }


    void function(){

    }


    void display(){

if(hasFurniture) {
    if (furnitureGridType != FurnitureTypes.empty)
        furniture.display(p, x, y);
    else
        p.rect(x,y,width,height);

}else{
    if (itemGridType != Items.empty)
        item.display(p, x, y);
    else
        p.rect(x,y,width,height);

}







    }
}
