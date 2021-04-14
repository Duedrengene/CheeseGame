import processing.core.PImage;

public class WallItem implements Item {

    PImage image;
    ImageLoader il;
    Furniture connectedFurniture;
    boolean selected = false;

    WallItem(ImageLoader iL){
    image = iL.wall;
this.il = iL;
        connectedFurniture = new Wall(iL);


    }

    public void function() {

    }




    public PImage getImage() {
        return image;
    }

    public boolean getSelected(){
        return selected;

    }
    public void setSelected(boolean check){
        if (check)
            selected = true;
            else
        selected = false;

    }

}
