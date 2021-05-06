public class Location {

    Shop shop;
    Dungeon dungeon;
    GUI gUI;
    Deathrealm deathrealm;

    Location(Shop shop,Dungeon dungeon,GUI gUI,Deathrealm deathrealm){
    this.shop = shop;
    this.dungeon = dungeon;
    this.gUI = gUI;
    this.deathrealm = deathrealm;

    }


    LocationType location = LocationType.dungeon;


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

            case deathrealm:{
                deathrealm.deathrealmFunctions();
            }
           break;
            }
        }





    void changeShop(LocationType location){
        this.location = location;


    }




}
