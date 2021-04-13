import processing.core.PImage;

public class WallItem implements Item {

    PImage image;
    ImageLoader il;
    Furniture connectedFurniture;

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
}
