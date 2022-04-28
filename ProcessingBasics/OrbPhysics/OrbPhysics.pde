ArrayList<Orb>orbList;
Orb center;
int mode;
Boolean background;
Boolean gravity;
Boolean chained;
final int GRAVITY = 0;
final int ORBIT = 1;
final int SPRING = 2;
final float SPRING_CONSTANT = .005;
final float SPRING_LENGTH = 150;
final float SPRING_DAMPEN = .995;

void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 7);
  mode = GRAVITY;
  background = true;
  gravity = true;
  chained = false;
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
}
void draw() {
  if (background) {
    background(255);
  }
  for (Orb o : orbList) {
    if (mode == ORBIT) {
      center.attract(o);
    } 
    if (mode == SPRING){
      center.attractSpring(o);
    }
    if (gravity){
      o.gravity();
    }
    o.move();
    o.display();
  }
  if (chained){
      for (int i = 0; i < orbList.size() - 1; i++){
        orbList.get(i).attractSpring(orbList.get(i+1));
        stroke(0, 128);
        line(orbList.get(i).x, orbList.get(i).y, orbList.get(i+1).x, orbList.get(i+1).y);
      }
    }
  center.display();
  fill(255);
  noStroke();
  rect(0, 0, 160, 70);
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  if (mode == ORBIT) {
    text("Orbit", 20, 60);
  } else if (mode == GRAVITY){
    text("Bounce", 20, 60);
  } else{
    text("Spring", 20, 60);
  } 
  if (background){
    text("background", 80, 20);
  }
  if (gravity){
    text("gravity", 80, 40);
  }
  if (chained){
    text("chained", 80, 60);
  }
  
}

void keyPressed() {
  if (keyCode == 8) {
    orbList = new ArrayList<Orb>();
  } else if (keyCode == 32) {
    mode = (mode+1)%3;
  } else if (keyCode == 66) {
    background = !background;
  } else if (keyCode == 71) {
    gravity = !gravity;
  } else if (keyCode == 67){
    chained = !chained;
  }
}
