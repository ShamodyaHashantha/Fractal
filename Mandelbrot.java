import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by hash on 9/4/16.
 */
public class Mandelbrot {
    int width=800;  // initialize width and height 
    int height=800;
    public double Comp_x1; // assign real part of minimum complex value.
    public double Comp_x2; // assign real part of maximum complex value.
    public double Comp_y1; // assign imaginary part of minimum complex value.
    public double Comp_y2; // assign imaginary part of maximum complex value.
    public int itrat;      // assign number od itaration.

    public Mandelbrot(double Comp_x1,double Comp_x2,double Comp_y1,double Comp_y2,int itrat){
        this.Comp_x1=Comp_x1;
        this.Comp_x2=Comp_x2;
        this.Comp_y1=Comp_y1;
        this.Comp_y2=Comp_y2;
        this.itrat=itrat;
    }
    public Mandelbrot(double Comp_x1,double Comp_x2,double Comp_y1,double Comp_y2){ // constructer without number of itaration.
        this.Comp_x1=Comp_x1;
        this.Comp_x2=Comp_x2;
        this.Comp_y1=Comp_y1;
        this.Comp_y2=Comp_y2;

    }

    BufferedImage canvas2 = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	// method for draw Mandelbort set.
    public void MandelbrotDraw(){
        try {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    double real = Comp_x1+ ((Comp_x2-Comp_x1)/width)*i;// map pixel value  from canvas1 to complex plane (real part)
                    double imag = Comp_y1+ ((Comp_y2-Comp_y1)/height)*j;// map pixel value  from canvas1 to complex plane (imaganary part)
                    /*double real = (i - width / 2.0) / (width / 2);
                    double imag = (j - height / 2.0) / (height / 2);*/
                    double x=0,y=0;

                   /* System.out.println("real = " + real);
                    System.out.println("imag = " + imag);*/
                    Complex z = new Complex(x, y); //
                    Complex c=new Complex(real,imag);
                    int itaration = 0;
                    //z.show();
                    while (x*x+y*y<=4 && itaration < itrat) { // checking condition about abs(zj)<2 and number of itaration times.
                        /*z = z.multiply(z);
                        z=z.add(c);*/
                        double x_new= x*x -y*y + real;
                        y = 2*x*y +imag;
                        x = x_new;
                        itaration++;
                    }
                    if(itaration%10==1 ){
                        canvas2.setRGB(i, j,0x99FFCC);  // give colors for each itaraion range.
                    }
                    else if(itaration%10==2){
                        canvas2.setRGB(i, j,0x66FFFF );
                    }
                    else if(itaration%10==3){
                        canvas2.setRGB(i, j,0x3399FF );
                    }
                    else if(itaration%10==4){
                        canvas2.setRGB(i, j,0x0000FF );
                    }
                    else if(itaration%10==5){
                        canvas2.setRGB(i, j,0x6600CC);
                    }
                    else if(itaration%10==6){
                        canvas2.setRGB(i, j,0x990099 );
                    }
                    else if(itaration%10==7){
                        canvas2.setRGB(i, j,0x660033);
                    }
                    else if(itaration%10==8){
                        canvas2.setRGB(i, j,0x99004C);
                    }
                    else if(itaration%10==9){
                        canvas2.setRGB(i, j,0xCC00CC);
                    }

                    //canvas.setRGB(i, j, 19 - 19 - 70);
                }
            }
		//draw set.
            ImageIO.write(canvas2, "png", new File("Mandelbrot.png"));
            JFrame frame1=new JFrame("Mandelbrot");
            frame1.setSize(800,800);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.add(new JLabel(new ImageIcon("Mandelbrot.png")));
            frame1.setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
