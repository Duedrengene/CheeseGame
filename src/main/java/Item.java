import processing.core.PImage;

public interface Item {

    void function();

    PImage getImage();

    boolean getSelected();

    void setSelected(boolean check);

}
