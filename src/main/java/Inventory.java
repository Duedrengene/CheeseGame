import processing.core.PApplet;

import javax.tools.Tool;
import java.util.ArrayList;

public class Inventory {

    PApplet p;
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<ToolBar> toolBarList = new ArrayList<>();

    Inventory(PApplet p){
        this.p = p;

        for(int i = 0;i< 5;i++ ){
            toolBarList.add(new ToolBar(itemList, i,p));

        }

    }




    void add(Items item,int number){


    }

    void remove(Items item,int number){


    }

    void prepareMove(){

    }

    void move(int from,int to){



    }

    void display(){
        for(int i = 0; i< toolBarList.size();i++)
        toolBarList.get(i).displayToolBar();



    }

    void open(){




    }










}
