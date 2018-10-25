import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by hash on 9/3/16.
 */
public class Julia {
    int  width=800; //default width and height given by user.*/
    int height=800;
   /* double real_new = 0;
    double imag_new =0.6;*/
    double Comlex_real; // real part of constant c(user input).
    double Complex_imag;// imainary part of constant c(user input). 
    int itar;           // number of itaration (this also given by user)


    public Julia(double Comlex_real, double Complex_imag,int itar){
        this.Comlex_real=Comlex_real;
        this.Complex_imag=Complex_imag;
        this.itar=itar;
    }

    public Julia(double Comlex_real, double Complex_imag){  // Constructer without number of itaraion 
        this.Comlex_real=Comlex_real;
        this.Complex_imag=Complex_imag;
    }



    BufferedImage canvas1 = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	// method for draw julia set
    public void JuliaDraw(){
	    try {
		    for ( int i = 0; i < width; i++) {
		        for (int j = 0; j < height; j++) {
		            double real1 = (i - width / 2.0) / (width / 2); // map pixel value  from canvas1 to complex plane (real part)
		            double imag1 = (j - height / 2.0) / (height / 2);// map pixel value  from canvas1 to complex plane (imaginry part)

		            Complex zj = new Complex(real1, imag1); // Create Complex plane using mapped point.
		            int itaration = 0;
		            //z.show();
		            while (real1*real1+imag1*imag1<=4 && itaration <itar ) { // checking condition about abs(zj)<2 and number of itaration times.
		                //z = z.multiply(z);
		                double r_new= real1*real1 -imag1*imag1 + Comlex_real; 
		                imag1 = 2*real1*imag1 +Complex_imag;                 // each itaration ,assigning new imaginry part.
		                real1 = r_new;					// each itaration,assigning new real part.
		                itaration++;
		            }
		            if(itaration%10==1){
		                canvas1.setRGB(i, j,0x99FFCC );  // give colors for each itaraion range.
		            }
		            else if(itaration%10==2){
		                canvas1.setRGB(i, j,0x66FFFF );
		            }
		            else if(itaration%10==3){
		                canvas1.setRGB(i, j,0x3399FF );
		            }
		            else if(itaration%10==4){
		                canvas1.setRGB(i, j,0x0000FF );
		            }
		            else if(itaration%10==5){
		                canvas1.setRGB(i, j,0x6600CC );
		            }
		            else if(itaration%10==6){
		                canvas1.setRGB(i, j,0x990099 );
		            }
		            else if(itaration%10==7){
		                canvas1.setRGB(i, j,0x660033 );
		            }
		            else if(itaration%10==8){
		                canvas1.setRGB(i, j,0x99004C );
		            }
		            else if(itaration%10==9){
		                canvas1.setRGB(i, j,0xCC00CC );
		            }

		            //canvas.setRGB(i, j, 19 - 19 - 70);
		        }
		     }
		    ImageIO.write(canvas1, "png", new File("Julia.png")); // draw julia map.
		    JFrame frame=new JFrame("Julia");
		    frame.setSize(width,height);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.add(new JLabel(new ImageIcon("Julia.png")));
		    frame.setVisible(true);
		}
		catch (Exception e){
		    System.out.println(e);
		}

	   }

}
