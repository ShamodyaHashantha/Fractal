public class Complex {
    private double real;  // assign 2 real and imaginary parts of camplex number.
    private double imag;


    public Complex(double real,double imag){
        this.real=real;
        this.imag=imag;
    }

    public Complex add(Complex z){
        return new Complex(this.real+z.real,this.imag+z.imag);
    }

    public Complex sub(Complex z){

        return new Complex(this.real-z.real,this.imag-z.imag);
    }

    public Complex multiply(Complex z){

        return new Complex(this.real*z.real,this.imag*z.imag); // return new complex Object.
    }

    public Complex squre(){
        return new Complex(Math.pow(this.real,2.0),Math.pow(this.imag,2.0));
    }

    public double abs(){

        return  Math.sqrt(Math.pow(this.real,2.0)+Math.pow(this.imag,2.0));
    }

    public void show( ){
        System.out.println(real+"+"+imag+"i");// show proper format of complex number.
    }




}