public class Location {

    Shop shop;
    Dungeon dungeon;
    GUI gUI;

    Location(Shop shop,Dungeon dungeon,GUI gUI){
    this.shop = shop;
    this.dungeon = dungeon;
    this.gUI = gUI;

    }


    LocationType location = LocationType.shop;


    void functions(){

        switch (location) {

            case shop: {
                shop.shopFunction();
                gUI.displayShop();

            }
            break;

            case dungeon:{
                dungeon.functions();

            }break;

        }



    }

    void changeShop(LocationType location){
        this.location = location;


    }




}
