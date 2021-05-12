public class Location {

    Shop shop;
    Dungeon dungeon;
    GUI gUI;
    Deathrealm deathrealm;
    StartMenu startMenu;


    Location(Shop shop,Dungeon dungeon,GUI gUI,Deathrealm deathrealm,StartMenu startMenu){
    this.shop = shop;
    this.dungeon = dungeon;
    this.gUI = gUI;
    this.deathrealm = deathrealm;
    this.startMenu = startMenu;

    }


    LocationType location = LocationType.menu;


    void functions(Main m){

        switch (location) {

            case shop: {
                shop.shopFunction(m);
                gUI.displayShop();

            }
            break;

            case dungeon:{
                dungeon.functions();
                gUI.displayDungeon();

            }break;

            case deathrealm:{
                deathrealm.deathrealmFunctions();

            }
           break;

            case menu:{

                startMenu.functions();

            }

            }
        }





    void changeLocation(LocationType location){
        this.location = location;


    }




}
