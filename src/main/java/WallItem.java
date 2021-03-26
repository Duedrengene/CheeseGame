import processing.core.PImage;

public class WallItem implements Item {

    PImage image;

    WallItem(ImageLoader iL){
    image = iL.wall;


    }

    public void function() {

    }




    public PImage getImage() {
        return image;
    }
}
