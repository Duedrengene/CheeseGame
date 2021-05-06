public class PizzaTopping extends Item{

    PizzaTopping(ImageLoader iL){
        img = iL.wall;
        this.il = iL;
        connectedFurniture = new Wall(iL.wall);
        type = FurnitureTypes.wall;

    }

    public void function() {

    }


}
