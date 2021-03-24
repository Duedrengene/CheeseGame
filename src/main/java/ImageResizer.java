import processing.core.PApplet;

public class ImageResizer {
    PApplet p;
    int width;
    int height;
    ImageLoader iL;
    float scaleH = 1;
    float scaleW = 1;


    ImageResizer(PApplet p, int width, int height, ImageLoader iL) {
        this.width = width;
        this.height = height;
        this.p = p;
        this.iL = iL;

    }
}

/*
void resize(int resizeres) {
    switch(resizeres) {


        case 1: {
            width = 1920;
            height = 1080;
            break;}
        case:2{
            width =
        }
    }
}
*/
