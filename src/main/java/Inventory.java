import processing.core.PApplet;

import javax.tools.Tool;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Inventory {

    PApplet p;
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<Item> furnitureList = new ArrayList<>();
    ArrayList<ToolBar> toolBarList = new ArrayList<>();
    ArrayList<ToolBar> buildBarList = new ArrayList<>();
    ArrayList<ToolBar> useBarList = new ArrayList<>();
    ToolBar selected;

    Inventory(PApplet p){
        this.p = p;

        for(int i = 0;i< 5;i++ ){
            toolBarList.add(new ToolBar(itemList, i,p));
            buildBarList.add(new ToolBar(furnitureList, i,p));
        }

    }


    void selector(boolean pressed,int mouseX,int mouseY,Inventory inventory ){
     //   if(pressed)

}

    void add(Items item,int number){


    }

    void remove(Items item,int number){


    }

    void prepareMove(){

    }

    void move(int from,int to){



    }

    void display(boolean buildMode){
        if (buildMode)
            useBarList = buildBarList;
        else useBarList = toolBarList;


        for(int i = 0; i< toolBarList.size();i++)
        useBarList.get(i).displayToolBar();
    }

    void open(){




    }










}
