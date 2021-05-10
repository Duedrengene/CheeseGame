import processing.core.PImage;

public class Door extends Furniture {


Door(PImage img){
    this.img= img;


}

@Override
    void function(Main m) {
        m.player.buildMode = false;
        if(m.location.location == LocationType.shop) {
            m.location.location = LocationType.dungeon;
            m.player.position.x = 20;
            m.player.position.y=50;
        }
        else{
            m.location.location=LocationType.shop;
for (int i =0; i<m.grid.size();i++)
    if(m.grid.get(i).furnitureGridType == FurnitureTypes.door){
           m.player.position.x = m.grid.get(i).x+50;
           m.player.position.y = m.grid.get(i).y+50;

    }
        }

    }
}
