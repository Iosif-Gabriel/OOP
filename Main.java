public class Main {
    public static void main(String[] args) {

        //Inmultrire matricilor nu vrea...chiar nu inteleg de ce..
        Complex comp=new Complex(2,0);
        Complex comp2=new Complex(1,0);
        Complex comp3=new Complex(1,0);
        Complex comp4=new Complex(1,0);
        Complex comp5=new Complex(1,0);
        Complex comp6=new Complex(1,0);
        Complex comp7=new Complex(1,0);
        Complex comp8=new Complex(1,0);
       // System.out.println(comp6.adunare(comp2).getRealPart()+"+"+"i"+comp6.adunare(comp2).getImaginaryPart());
       // System.out.println(comp8.inmultire(comp8).getRealPart()+"+"+"i"+comp8.inmultire(comp8).getImaginaryPart());

        Complex[][] matrice=new Complex[][]{{comp,comp2},{comp4,comp2}};
        Complex[][] matrice2=new Complex[][]{{comp5,comp6},{comp2,comp3}};

        //System.out.println(matrice);
        Matrice mat=new Matrice(2,2,matrice);
        Matrice mat1=new Matrice(2,2,matrice2);
        System.out.println("Matricea 1");
        mat.afisare();
        System.out.println("Matricea 2");
        mat1.afisare();
        System.out.println("inmultire");
       mat.inmultireMatrice(mat1).afisare();
//        System.out.println("suma");
//        mat.adunareMatrice(mat1).afisare();
//        System.out.println("Diferenta");
//        mat1.scadereMatrice(mat).afisare();
//        System.out.println("ProdScalar");
//        mat1.inmultireScalarMatrice(5).afisare();





    }
}

