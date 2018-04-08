package TrabalhoAlgoritmosEmGrafos.tools.algoritmos.DepthFirstSearch;

import java.util.Scanner;
import java.util.Stack;

import TrabalhoAlgoritmosEmGrafos.tools.grafos.GrafosCriador;
import TrabalhoAlgoritmosEmGrafos.tools.readIO.ReadIO;

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
        Stack<Integer> pilha = new Stack<Integer>();
        Grafo[] lista = new Grafo[i];
        int time = 0;
        for (int j = 0; j < i; j++) {
            lista[j] = new Grafo();

        }
        int vertexChoose = maxVertex(grafo);
        pilha.push(new Integer(vertexChoose));
        int v;
        while (!pilha.isEmpty()) {
            v = pilha.peek();
            pilha.pop();
            if (lista[v].getCor() == 0) {
                System.out.print(v + " ");
                lista[v].setD(time++);
                lista[v].setCor(1);
            }

            for (int j = 0; j < lista.length; j++) {
                if (grafo[v][j] == 1) {
                    if (lista[j].getCor() == 0) {
                        pilha.push(j);

                    }
                }
            }

        }

    }

    private static int maxVertex(int[][] grafo) {
        int pos = 0;
        int max = 0;
        int cont = 0;
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (grafo[i][j] == 1) {
                    cont++;
                }
            }
            if (i == 0) {
                max = cont;
                pos = 0;
            } else {
                if (max < cont) {
                    max = cont;
                    pos = i;
                }
            }
            cont = 0;
        }
        return pos;
    }

}
