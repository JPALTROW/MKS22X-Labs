public class OrbNode {
  float x, y;
  float dx, dy;
  float radius;
  color c;
  OrbNode next, prev;
  public OrbNode() {
  }
  public OrbNode(float x_, float y_) {
    this(x_, y_, 0.0, 0.0, 30.0);
  }
  public OrbNode(float x_, float y_, float dx_, float dy_, float radius_ ) {
    x = x_;
    y = y_;
    dx = dx_;
    dy = dy_;
    radius = radius_;
    c = color(random(255), random(255), random(255), 200);
  }
  /**
   *complete this method
   */
  void display() {
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    if (next != null){
      line(x, y+.1, next.x, next.y - .1);
    }
    if (prev != null){
      line(x, y+.1, prev.x, prev.y - .1);
    }
    //If next or previous exist, draw lines to them! (aim for slightly off center)
    /*you write this part*/
  }

  void springAttract(OrbNode other) {
    float dist = dist(x, y, other.x, other.y) ;
    float force = (dist - SPRING_LENGTH) * SPRING_CONSTANT;
    float displacex = (x - other.x) ;
    float displacey = (y - other.y) ;
    other.dx += displacex * force / dist;
    other.dy += displacey * force / dist;
    other.dx*= SPRING_DAMPEN;
    other.dy*= SPRING_DAMPEN;
  }

  /**
   *complete this method
   */
  void move() {
    //have prev and next apply spring force to this node;
    /*you write this part*/
    if (next != null){
      next.springAttract(this);
    }
    if (prev != null){
      prev.springAttract(this);
    }
    //apply velocity to position
    x+=dx;
    y+=dy;
    //apply gravity
    dy+=0.35;
  }
  
 
}

public class FixedOrbNode extends OrbNode {
  void move() {
  }
  FixedOrbNode(float x_, float y_) {
    x = x_;
    y = y_;
    radius = 30;
    c = color(0);
  }
}
