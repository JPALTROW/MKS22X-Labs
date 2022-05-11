final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = .35;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("Length: "+SPRING_LENGTH, 20, 20);
  text("Dampen: "+SPRING_DAMPEN, 20, 40);
  text("Constant: "+SPRING_CONSTANT, 20, 60);
  text("Gravity: "+GRAVITY, 20, 80);
}
void keyPressed() {
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
