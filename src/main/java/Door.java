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
            m.player.position.y=100;
            m.camera.mode = 1;
            m.enemies.clear();
            for(int i =0; i<10;i++){
            m.enemies.add(new Golem((int) m.player.p.random(1000, 3000), (int) m.player.p.random(0, 1000),  m.player.position, m.player.p, m.player,m.imgLoad));
            m.enemies.add(new CheeseDemon((int) m.player.p.random(1000, 3000), (int) m.player.p.random(0, 1000),   m.player.position, m.player.p, m.player,m.imgLoad));
            m.enemies.add(new CheeseGhast((int) m.player.p.random(1000, 3000), (int) m.player.p.random(0, 1000),   m.player.position, m.player.p, m.player,m.imgLoad));
        }}
        else{
            m.location.location=LocationType.shop;
for (int i =0; i<m.grid.size();i++)
    if(m.grid.get(i).furnitureGridType == FurnitureTypes.door){
           m.player.position.x = m.grid.get(i).x+m.grid.get(i).width/4;
           m.player.position.y = m.grid.get(i).y+m.grid.get(i).height/4;
        m.camera.mode = 0;

    }
        }

    }
}
