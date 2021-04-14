import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class ToolBar {

    PApplet p;

    PVector position;

    ArrayList<Item> itemList = new ArrayList<>();

    int width = 100;
    int height = 100;
    int toolBarCount;

    boolean selected = false;

    ToolBar(ArrayList<Item> itemList, int toolBarCount, PApplet p) {
        this.p = p;
        this.toolBarCount = toolBarCount;
        this.itemList = itemList;
        this.position = new PVector((p.width / 2) - 300 + (toolBarCount * 100), p.height - 101);
        System.out.println(p.height);

    }


    void displayToolBar() {

        p.strokeWeight(5);
        p.stroke(255, 0, 0);
        p.noFill();
        if (itemList.size() > toolBarCount)
            p.fill(255, 255, 255);
        p.rect(position.x, position.y, width, height);
        p.noFill();
        p.stroke(0);
        p.strokeWeight(0);

        if (itemList.size() > toolBarCount) {
            p.image(itemList.get(toolBarCount).getImage(), position.x , position.y);
        }
    }

    boolean checkClicked(int x, int y) {
     /*   if (x < position.x + width && x > position.x &&) {
        }
*/
return false;
    }
}