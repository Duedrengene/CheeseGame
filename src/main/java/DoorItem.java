import processing.core.PImage;

public class DoorItem implements Item {


        PImage image;
        ImageLoader il;
        Furniture connectedFurniture;

        FurnitureTypes type = FurnitureTypes.door;

        DoorItem(ImageLoader iL){
            image = iL.door;
            this.il = iL;
            connectedFurniture = new Door(iL.door);

        }

        public void function() {

        }




        public PImage getImage() {
            return image;
        }

        public FurnitureTypes getType(){return type; }


}
