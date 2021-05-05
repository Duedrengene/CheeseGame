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


    void functions(Main m){

        switch (location) {

            case shop: {
                shop.shopFunction(m);
                gUI.displayShop();

            }
            break;

            case dungeon:{
                dungeon.functions();

            }break;

        }



    }

    void changeLocation(LocationType location){
        this.location = location;


    }




}
