import processing.sound.*;
public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;
  SoundFile file;

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
    ellipse(x, y, 2*radius, 2*radius);
  }

  void move() {
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x = x + xSpeed;
    y = y + ySpeed;
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    
    if(x < radius){
      xSpeed*=-1.0;
      x = radius;
    }else if(x > width - radius){
      xSpeed*=-1.0;
      x = abs(radius-width);
    }else if(y < radius){
      ySpeed*=-1.0;
      y = radius;
    }else if(y > height - radius){
      ySpeed*=-1.0;
      y = abs(radius - height);
    }
    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
    ySpeed += .5;
  }
}
