public class Location {

    Shop shop;
    Dungeon dungeon;

    Location(Shop shop,Dungeon dungeon){
    this.shop = shop;
    this.dungeon = dungeon;


    }


    LocationType location = LocationType.shop;


    void functions(){
    if(location == LocationType.shop){
        shop.shopFunction();



    }




    }





}
