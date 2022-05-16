public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    color black = color(0);
    if (x == 0|| x == width - 1|| y == 0||y == height-1) {
      return black;
    }
    int countR = 0;
    int countB = 0;
    int countG = 0;
    for (int i : dirs) {
      for (int j : dirs) {
        countR += red(img.get(x + i, y+j)) * kernel[i+1][j+1];
        countB += blue(img.get(x + i, y+j)) * kernel[i+1][j+1];
        countG += green(img.get(x + i, y+j)) * kernel[i+1][j+1];
      }
    }
    return color(countR, countG, countB);
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        destination.set(i, j, calcNewColor(source, i, j));
      }
    }
  }
}
