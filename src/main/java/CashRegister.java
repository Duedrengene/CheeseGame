import processing.core.PImage;

public class CashRegister extends Furniture {


    CashRegister(PImage img){
        this.img = img;


    }

    void function(Main m){
        for (int i=0;i<m.grid.size();i++){
            System.out.println();

            if(m.grid.get(i).furnitureGridType == FurnitureTypes.shopCounter){

                switch(m.grid.get(i).furniture.itemType){
                    case primadonna:{
                        m.player.money += 100;


                    }break;
                    case cheddar:{
                        m.player.money += 50;

                    }break;
                    case pizzaTopping:{
                        m.player.money += 10;



                    }break;

                }
                m.grid.get(i).furniture.itemType = Items.empty;
                m.grid.get(i).furniture.itemImg = null;

            }

        }



    }

}
