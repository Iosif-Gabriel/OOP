public class Matrice {
    int rand;
    int coloane;
    Complex[][] matrice;

    public Matrice(int rand, int coloane, Complex[][] matrice) {
        this.rand = rand;
        this.coloane = coloane;
        this.matrice=matrice;
    }

    public int getLinii() {
        return rand;
    }

    public void setLinii(int linii) {
        this.rand = linii;
    }

    public int getColoane() {
        return coloane;
    }

    public void setColoane(int coloane) {
        this.coloane = coloane;
    }

    public Complex[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(Complex[][] matrice) {
        this.matrice = matrice;
    }

    public Matrice adunareMatrice(Matrice altaMatrice){
        if(this.coloane==altaMatrice.coloane && this.rand==altaMatrice.rand && altaMatrice!=null){
            Matrice rez=new Matrice(this.rand,this.coloane,this.matrice);
            for(int i=0;i<this.coloane;i++){
                for(int j=0;j<this.rand;j++){
                    rez.matrice[i][j]=this.matrice[i][j].adunare(altaMatrice.matrice[i][j]);
                }

            }
            return rez;
        }

        return null;
    }

    public Matrice scadereMatrice(Matrice altaMatrice){
        if(this.coloane==altaMatrice.coloane && this.rand==altaMatrice.rand && altaMatrice!=null){
            Matrice rez=new Matrice(this.rand,this.coloane,this.matrice);
            for(int i=0;i<this.coloane;i++){
                for(int j=0;j<this.rand;j++){
                    rez.matrice[i][j]=this.matrice[i][j].scadere(altaMatrice.matrice[i][j]);
                }

            }
            return rez;
        }

        return null;
    }

    public Matrice inmultireMatrice(Matrice altaMatrice){
        if(this.coloane==altaMatrice.coloane && this.rand==altaMatrice.coloane){
            Matrice rez=new Matrice(rand,coloane,matrice);
            for(int i=0;i<this.rand;i++){
                for(int j=0;j<this.coloane;j++){
                    rez.matrice[i][j]=new Complex(0,0);
                    for(int k=0;k<this.rand;k++){
                        rez.matrice[i][j]=rez.matrice[i][j].adunare(matrice[i][k].inmultire(altaMatrice.matrice[k][j]));
                    }
                }
            }
            return rez;
        }
        return null;
    }
    public Matrice inmultireScalarMatrice(int val){
        Matrice rez=new Matrice(this.rand,this.coloane,this.matrice);
        for(int i=0;i<this.coloane;i++){
            for(int j=0;j<this.rand;j++){
                rez.matrice[i][j]=this.matrice[i][j].produsScalar(val);
            }
        }
        return rez;
    }

    public void afisare(){

        for(int i=0;i<this.coloane;i++){
            for(int j=0;j<this.rand;j++){
                System.out.print(Math.abs(matrice[i][j].getRealPart())+"+"+Math.abs(matrice[i][j].getImaginaryPart())+"i     ");
            }
            System.out.println(" \n");
        }
    }

}