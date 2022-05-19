static final int[] dirs = {-1, 0, 1};
static int current = 0;
Kernel[] kernels;
String[] names;
PImage car;
PImage output;

void setup() {
  size(1450, 500);
  car = loadImage("redcar.png");
  output = car.copy();
  names = new String[]{
    "Identity", "Blur", "Sharpen",
    "Outline", "Left Sobel", "Right Sobel",
    "Top Sobel", "Emboss"
  };

  kernels = new Kernel[] {
    new Kernel( new float[][] {
    {0, 0, 0},
    {0, 1, 0},
    {0, 0, 0}    }) ,
    new Kernel( new float[][] {
    {.111, .111, .111},
    {.111, .111, .111},
    {.111, .111, .111}    }) ,
    new Kernel( new float[][] {
    {0, -1, 0},
    {-1, 5, -1},
    {0, -1, 0}    }) ,
    new Kernel( new float[][] {
    {-1, -1, -1},
    {-1, 8, -1},
    {-1, -1, -1}    }) ,
    new Kernel( new float[][] {
    {1, 0, -1},
    {2, 0, -2},
    {1, 0, -1}    }) ,
    new Kernel( new float[][] {
    {-1, 0, 1},
    {-2, 0, 2},
    {-1, 0, 1}    }) ,
    new Kernel( new float[][] {
    {1, 2,  1},
    {0, 0, 0},
    {-1, -2, -1}    }),
        new Kernel( new float[][] {
    {-2, -1,  0},
    {-1, 1, 1},
    {0, 1, 2}    })
  };
  kernels[current].apply(car, output);
  image(car, 0, 0);
  image(output, car.width, 0);
}

void draw(){
}

void mouseClicked(){
  current = (current + 1 )%kernels.length;
  println(names[current]);
  kernels[current].apply(car, output);
  image(car, 0, 0);
  image(output, car.width, 0);
}
