ArrayList<Orb>orbList;
Orb center;
void setup() {
  size(1000, 700);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 7);
  background(255);
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  orbList.add(new Orb(mouseX, mouseY, 1, 1, 20));
}
void draw() {
  for (Orb o : orbList) {
    o.move();
    o.display();
  }
  center.display();
  fill(0);
  //text(frameRate, 20, 20);
  //text(orbList.size(), 20, 40);
}
