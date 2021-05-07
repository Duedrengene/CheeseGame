public class PizzaTopping extends Item{

    PizzaTopping(ImageLoader imgLoad){
        img = imgLoad.wall;
        this.il = imgLoad;
        connectedFurniture = new Wall(imgLoad.wall);
        type = FurnitureTypes.wall;

    }

    public void function() {

    }


}
