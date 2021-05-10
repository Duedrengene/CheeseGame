import processing.core.PImage;

public class Door extends Furniture {


Door(PImage img){
    this.img= img;


}

@Override
    void function(Main m) {

        if(m.location.location == LocationType.shop)
    m.location.location=LocationType.dungeon;
        else{
            m.location.location=LocationType.shop;


        }

    }
}
