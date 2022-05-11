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
}
void keyPressed() {
  if (key == '1') {
    SPRING_CONSTANT+=.001;
  }
  if (key == '2') {
    if (SPRING_CONSTANT > .001) {
      SPRING_CONSTANT-=.001;
    }
  }
  if (key == '3') {
    if (SPRING_DAMPEN <= .999) {
      SPRING_DAMPEN+=.001;
    }
  }
  if (key == '4') {
    if (SPRING_DAMPEN >= .001) {
      SPRING_DAMPEN-=.001;
    }
  }
  if (key == '5') {
    SPRING_LENGTH+=1;
  }
  if (key == '6') {
    if (SPRING_LENGTH >= 1) {
      SPRING_LENGTH-=1;
    }
  }
  if (key == '7') {
    GRAVITY+=.01;
  }
  if (key == '8') {
    if (GRAVITY >= .01) {
      GRAVITY -= .01;
    }
  }
}
