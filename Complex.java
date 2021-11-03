public class Complex {
    public double realPart;
    public double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }



    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public Complex adunare(Complex c1){
        return new Complex(this.realPart+c1.realPart,this.imaginaryPart+c1.imaginaryPart);
    }

    public Complex scadere(Complex c1){
        return new Complex(this.realPart-c1.realPart,this.imaginaryPart-c1.imaginaryPart);
    }

    public Complex inmultire(Complex c1){
        Complex c2=new Complex(0,0);
         c2.realPart=realPart*c1.realPart-imaginaryPart*c1.imaginaryPart;
         c2.imaginaryPart=realPart*c1.imaginaryPart+imaginaryPart*c1.realPart;

        return c2;
    }

    public Complex produsScalar(int val){
        return new Complex(this.realPart*val,this.imaginaryPart*val);
    }

    public String toString(){
        if (this.imaginaryPart < 0) {
            return this.realPart + " - " + Math.abs(this.imaginaryPart) + "i";
        } else {
            return this.realPart + " + " + +this.imaginaryPart + "i";
        }
    }


}
