package Java_Basics;

public class g_arrays {

  public static void main(String[] args) {
    // 2D Array demonstration
    int[][] a = {
      { 1, 2, 3, 4, 5 },
      { 6, 7, 8, 9, 10 },
      { 11, 12, 13, 14, 15 },
    };
    
    System.out.println("2D Array:");
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    
    // 3D Array declaration
    int[][][] b = new int[10][10][10];
    System.out.println("\n3D Array size: " + b.length + "x" + b[0].length + "x" + b[0][0].length);
    
    // 4D Array declaration
    int[][][][] c = new int[10][10][10][10];
    System.out.println("4D Array size: " + c.length + "x" + c[0].length + "x" + c[0][0].length + "x" + c[0][0][0].length);
  }
}
