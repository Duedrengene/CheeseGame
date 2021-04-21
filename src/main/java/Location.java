public class Location {

    Shop shop;
    Dungeon dungeon;

    Location(Shop shop,Dungeon dungeon){
    this.shop = shop;
    this.dungeon = dungeon;


    }


    LocationType location = LocationType.dungeon;


    void functions(){

        switch (location) {

            case shop: {
                shop.shopFunction();


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
