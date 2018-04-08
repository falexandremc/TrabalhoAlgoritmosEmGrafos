package TrabalhoAlgoritmosEmGrafos.tools.grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import TrabalhoAlgoritmosEmGrafos.tools.readIO.ReadIO;

public class GrafosCriador {

    public static int[][] paraMatrizDeAdjacencia(int[][] grafo) {
        int qtnVertices = grafo[0][0];
        int[][] g = new int[qtnVertices][qtnVertices];
        for (int[] i : grafo) {
            if (i[0] != qtnVertices) {
                g[i[0]][i[1]] = 1;
            }
        }
        /*
	for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
	}
         */
        return g;
    }

    public static LinkedList<LinkedList<Integer>> paraListaDeAdjacencia(int[][] grafo) {

        LinkedList<LinkedList<Integer>> listaDeAdjacencia = new LinkedList<>();

        for (int i = 0; i < grafo[0][0]; i++) {
            listaDeAdjacencia.add(new LinkedList<>());
        }

        for (int i = 1; i < grafo.length; i++) {
            listaDeAdjacencia.get(grafo[i][0]).add(grafo[i][1]);
        }

        return listaDeAdjacencia;
        /*
        for (int i = 1; i < listaDeAdjacencia.size(); i++){
            System.out.print(i+" = ");
            for (Integer integer : listaDeAdjacencia.get(i))
                System.out.print(integer+", ");
            System.out.println("");
        }
        */
    }

    public static void main(String[] args) {
        ReadIO.visualizarLista();
        String arquivo = new Scanner(System.in).nextLine();
        int[][] matriz = ReadIO.carregarGrafo(arquivo);
        paraListaDeAdjacencia(matriz);
        paraMatrizDeAdjacencia(matriz);
    }
}
