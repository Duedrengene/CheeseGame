public class PizzaTopping extends Item{

    PizzaTopping(ImageLoader imgLoad){
        img = imgLoad.pizzatopping;
        this.il = imgLoad;
        connectedFurniture = new Wall(imgLoad.wall);
        itemType = Items.pizzaTopping;

    }

    public void function() {

    }


}
