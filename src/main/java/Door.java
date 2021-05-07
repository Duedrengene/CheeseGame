import processing.core.PImage;

public class Door extends Furniture {


Door(PImage img){
    this.img= img;


}

@Override
    void function(Main m) {

    if(!m.player.buildMode)
    m.location.location=LocationType.dungeon;

    }
}
