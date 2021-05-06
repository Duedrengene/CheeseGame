import processing.core.PApplet;

import java.util.ArrayList;

public class Inventory {

    PApplet p;

    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<Item> itemToolBarList = new ArrayList<>();
    ArrayList<Item> furnitureList = new ArrayList<>();
    ArrayList<ToolBar> toolBarList = new ArrayList<>();
    ArrayList<ToolBar> buildBarList = new ArrayList<>();
    ArrayList<ToolBar> useBarList = new ArrayList<>();
    ArrayList<GridSpaceDefault> inventoryGrid = new ArrayList<>();

    ToolBar selected;




    Inventory(PApplet p){
        this.p = p;

        for(int i = 0;i< 5;i++ ){
            toolBarList.add(new ToolBar(itemToolBarList, i,p));
            buildBarList.add(new ToolBar(furnitureList, i,p));
        }
    }


    void selector(boolean pressed,int mouseX,int mouseY,Inventory inventory ){
     //   if(pressed)

}

    void add(Item item,int number){

    for(int i=0;i<number;i++)
        itemList.add(item);

    }

    void remove(Item item,int number){

        for(int i =itemList.size()-1;i>=0;i--){

            if(itemList.get(i) == item){
                itemList.remove(i);
                number--;
            }
            if (number == 0) break;
        }

    }



    void move(int from, int to, ArrayList<Item> itemList){
        Item temp = itemList.get(to);
         itemList.set(to,itemList.get(from));
        itemList.set(from,temp);


    }

    void display(boolean buildMode,Player player,ArrayList<GridSpaceDefault> inventoryGridList){
        if(player.inventoryOpen) {
            p.fill(255);
            for(int i = 0; i<inventoryGridList.size();i++)
            inventoryGridList.get(i).display();

        }
            else{
            if (buildMode)
                useBarList = buildBarList;
            else useBarList = toolBarList;


            for (int i = 0; i < toolBarList.size(); i++)
                useBarList.get(i).displayToolBar();
        }

    }

    void open(Player player){

        player.immobile = true;
        player.inventoryOpen = true;



    }


    void close(Player player){

        player.immobile = false;
        player.inventoryOpen = false;


    }










}
