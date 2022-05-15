final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = .35;
static int mode = 0;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if (mode == 0) {
    orbs.add(new OrbNode(mouseX, mouseY));
  }
  if (mode == 1) {
    orbs.add(mouseX, new OrbNode(mouseX, mouseY));
  }
  if (mode == 2) {
    orbs.delete(orbs.getNodeAt(mouseX, mouseY));
  }
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("Length: "+SPRING_LENGTH, 20, 20);
  text("Dampen: "+SPRING_DAMPEN, 20, 40);
  text("Constant: "+SPRING_CONSTANT, 20, 60);
  text("Gravity: "+GRAVITY, 20, 80);
  if (mode == 0){
    text("Mode: Add" , 20, 100);
  }
  if (mode == 1){
    text("Mode: Insert" , 20, 100);
  }
  if (mode == 2){
    text("Mode: Delete" , 20, 100);
  }
}
void keyPressed() {
  if (keyCode == 32){
    mode = (mode+10)%3;
  }
  if (key == '1') {
    SPRING_CONSTANT*=1.1;
  }
  if (key == '2') {
    SPRING_CONSTANT*=.9;
  }
  if (key == '3') {
    if (SPRING_DAMPEN <= 1.0/1.1) {
      SPRING_DAMPEN*=1.1;
    }
  }
  if (key == '4') {

    SPRING_DAMPEN*=.9;
  }
  if (key == '5') {
    SPRING_LENGTH*=1.1;
  }
  if (key == '6') {

    SPRING_LENGTH*=.9;
  }
  if (key == '7') {
    GRAVITY*=1.1;
  }
  if (key == '8') {

    GRAVITY *=.9;
  }
}
