package TrabalhoAlgoritmosEmGrafos.tools.algoritmos.DepthFirstSearch;

public class Vertice {

    private Cor cor;
    private int f;
    private int d;

    public Vertice() {
        cor = Cor.BRANCO;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
 
}
