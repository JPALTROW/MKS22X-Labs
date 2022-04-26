ArrayList<Orb>orbList;
Orb center;
Boolean mode;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 7);
  mode = true;
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
}
void draw() {
  background(255);
  for (Orb o : orbList) {
    if (mode == true) {
      center.attract(o);
    } else {
      o.gravity();
    }
    o.move();
    o.display();
  }
  center.display();
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  if (mode == true){
    text("Orbit", 20, 60);
  }else{
    text("Gravity", 20, 60);
  }
}

void keyPressed() {
  if (keyCode == 8) {
    orbList = new ArrayList<Orb>();
  } else if (keyCode == 32) {
    mode = !mode;
  }
}
