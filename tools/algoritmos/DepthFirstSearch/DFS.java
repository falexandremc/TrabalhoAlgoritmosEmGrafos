package TrabalhoAlgoritmosEmGrafos.tools.algoritmos.DepthFirstSearch;

import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        //teste 1
        //ReadIO.visualizarLista();
        //String arquivo=new Scanner(System.in).nextLine();
        //int [][]matriz=ReadIO.readFile(arquivo);
        //int [][]grafo=GrafosCriador.paraMatrizDeAdjacencia(matriz);
        //

        //teste 2
        int[][] grafo = new int[5][5];
        // A B C D E
        // 0 1 2 3 4
        grafo[0][2] = 1;
        grafo[1][2] = 1;
        grafo[2][0] = 1;
        grafo[2][1] = 1;
        grafo[2][3] = 1;
        grafo[2][4] = 1;
        grafo[3][2] = 1;
        grafo[3][4] = 1;
        grafo[4][2] = 1;
        grafo[4][3] = 1;
        //
        DFS(grafo, grafo.length);
    }

    private static void DFS(int[][] grafo, int i) {     
        Vertice[] lista = new Vertice[i];
        for (int j = 0; j < i; j++)
            lista[j] = new Vertice();
        
        Stack<Integer> pilha = new Stack<>();
        pilha.push(maxVertex(grafo));
        int v, time = 0;
        while (!pilha.isEmpty()) {
            v = pilha.peek();
            pilha.pop();
            if (lista[v].getCor() == Cor.BRANCO) {
                lista[v].setD(time++);
                lista[v].setCor(Cor.CINZA);
            }

            for (int j = 0; j < lista.length; j++)
                if (grafo[v][j] == 1)
                    if (lista[j].getCor() == Cor.BRANCO)
                        pilha.push(j);
        }

    }

    private static int maxVertex(int[][] grafo) {
        int pos = 0, max = 0, cont = 0;
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++)
                if (grafo[i][j] == 1)
                    cont++;
            if (i == 0) {
                max = cont;
                pos = 0;
            } else if (max < cont) {
                max = cont;
                pos = i;
            }
            cont = 0;
        }
        return pos;
    }

}
