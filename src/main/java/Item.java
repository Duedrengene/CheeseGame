import processing.core.PImage;

public interface Item {

    void function();

    PImage getImage();

    FurnitureTypes getType();
}
