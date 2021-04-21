import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class ToolBar {

    PApplet p;

    PVector position;

    ArrayList<Item> itemList = new ArrayList<>();

    int width = 100;
    int height = 100;
    boolean selected = false;
    int toolBarCount;
    ToolBar(ArrayList<Item> itemList, int toolBarCount, PApplet p){
        this.p =p;
        this.toolBarCount = toolBarCount;
        this.itemList = itemList;
         this.position = new PVector((p.width / 2) - 300+((1+toolBarCount)*100),p.height - 101);
    }


    void displayToolBar(){

        p.strokeWeight(5);
        if(selected) {
            p.stroke(0, 255, 0);
        }else p.stroke(0,0,0);

        if (itemList.size()-1 < toolBarCount)
            p.fill(255, 255, 255);
        p.rect(position.x, position.y, width, height);
        p.noFill();
            p.stroke(0);
            p.strokeWeight(0);

            if(itemList.size() >toolBarCount) {
                p.image(itemList.get(toolBarCount).getImage(), position.x, p.height - 101);
            }
    }
/*
boolean checkClicked(int x,int y){
        if(){}
            else

        return  false;
}
*/

}
