void avatar(int x, int y) {
  fill(140, 84, 35);
  ellipse(x-30, y-25, 30, 25);
  ellipse(x+30, y-25, 30, 25);

  fill(209, 160, 117);
  ellipse(x-29, y-26, 23, 18);
  ellipse(x+29, y-26, 23, 18);
  fill(140, 84, 35);
  ellipse(x, y+10, 100, 80);
  fill(209, 160, 117);
  ellipse(x, y+10, 90, 70);
  fill(230, 198, 170);
  ellipse(x, y+20, 60, 30);
  fill(0);
  triangle(x-10, y+17, x+10, y+17, x, y+24);
  ellipse(x-18, y-5, 10, 10);
  ellipse(x+18, y-5, 10, 10);
  noFill();
  arc(x-5, y+24, 10, 5, 0, 3*PI/4);
  arc(x+6, y+24, 10, 5, PI/4, PI);
  fill(255);
}


int x, y;
int MODE;
void setup() {
  size(800, 800);
  MODE = 2;
  x = width/2;
  y = height/2;
}
void draw() {
  background(255);
  x = change(x);
  y = change(y);
  avatar(x, y);
  avatar(mouseX, mouseY);
}

int change(int value) {
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
   wrap back around to the other end of the screen.
   */

  switch(MODE) {
  case 0:
    return (int)(random(width));
  case 1:
    return value+(int)(random(3))-1;
  case 2:
    if (value+1 < width){
      return value+1;
    }else{
      return 0;
    }
  default:
    return width/2;
  }
}

void mouseClicked(){
  MODE=(MODE+1)%3;
}
