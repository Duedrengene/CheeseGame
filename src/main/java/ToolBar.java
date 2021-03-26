import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class ToolBar {

    PApplet p;

    PVector basePosition;

    ArrayList<Item> itemList = new ArrayList<>();



    int toolBarCount;
    ToolBar(ArrayList<Item> itemList, int toolBarCount, PApplet p){
        this.p =p;
        this.toolBarCount = toolBarCount;
        this.itemList = itemList;
         basePosition = new PVector((p.width / 2) - 300,p.height - 101);
    }


    void displayToolBar(){

            p.strokeWeight(5);
            p.stroke(255,0,0);
            p.rect((p.width / 2) - 300+toolBarCount*100, p.height - 101, 100, 100);
            p.stroke(0);
            p.strokeWeight(0);

            if(itemList.size() >0)
            p.image(itemList.get(toolBarCount).getImage(),basePosition.x+toolBarCount*100,basePosition.y);

    }




}
