import processing.sound.*;
public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;
  float dist;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255), random(255), random(255));
  }




  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
    fill(c, 128);
    noStroke();
    ellipse(x, y, 2*radius, 2*radius);
    stroke(0);
    line(x, y, x+5*xSpeed, y+5*ySpeed);
  }

  void attract(Orb other) {
    dist = dist(x, y, other.x, other.y);
    other.xSpeed += 20*(x - other.x)/(dist*dist);
    other.ySpeed += 20*(y - other.y)/(dist*dist);
  }

  void gravity() {
    ySpeed += .15;
  }

  void attractSpring(Orb other) {
    dist = dist(x, y, other.x, other.y);
    float force = (dist - SPRING_LENGTH) * SPRING_CONSTANT;
    other.xSpeed += force*((x-other.x)/dist);
    other.xSpeed *= SPRING_DAMPEN;
    other.ySpeed += force*((y-other.y)/dist);
    other.ySpeed *= SPRING_DAMPEN;
  }

  void move() {
    if (mode == GRAVITY) {
      if (x < radius) {
        xSpeed*=-1.0;
        x = radius;
      } else if (x > width - radius) {
        xSpeed*=-1.0;
        x = abs(radius-width);
      } else if (y < radius) {
        ySpeed*=-1.0;
        y = radius;
      } else if (y > height - radius) {
        ySpeed*=-1.0;
        y = abs(radius - height);
      }
    }
    x = x + xSpeed;
    y = y + ySpeed;
  }
}
