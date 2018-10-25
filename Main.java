

public class Main {

    public static void main(String[] args) {

        if(args[0].equals("Mandelbrot")  ){
            try {
                double x_min = Double.parseDouble(args[1]); // taking command line inputuser (input) for draw Mandelbrot set.
                double x_max = Double.parseDouble(args[2]);
                double y_min = Double.parseDouble(args[3]);
                double y_max = Double.parseDouble(args[4]);
                int itrat = Integer.parseInt(args[5]);
                Mandelbrot m = new Mandelbrot(x_min, x_max, y_min, y_max,itrat);
                m.MandelbrotDraw();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
         else if(args[0].equals("Julia") ){
            try {
                double complex_x = Double.parseDouble(args[1]); //taking command line input(user input) for draw julia set.
                double complex_y = Double.parseDouble(args[2]);
                int itrat = Integer.parseInt(args[3]);
                Julia j = new Julia(complex_x,complex_y,itrat);
                j.JuliaDraw();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }
}
