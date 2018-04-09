package TrabalhoAlgoritmosEmGrafos.tools.grafos;

import java.util.LinkedList;

public class GrafosCriador {
    /**
     * @param grafo um grafo
     * @return um grafo na forma de matriz de adjacencia
     **/
    public static int[][] paraMatrizDeAdjacencia(int[][] grafo) {
        int qntVertices = grafo[0][0];
        int[][] g = new int[qntVertices][qntVertices];
        for (int[] i : grafo)
            if (i[0] != qntVertices)
                g[i[0]][i[1]] = 1;
        return g;
    }
    
    /**
     * @param grafo um grafo
     * @return um grafo na forma de lista de adjacencia
     **/
    public static LinkedList<LinkedList<Integer>> paraListaDeAdjacencia(int[][] grafo) { 
        LinkedList<LinkedList<Integer>> listaDeAdjacencia = new LinkedList<>();
        for (int i = 0; i < grafo[0][0]; i++)
            listaDeAdjacencia.add(new LinkedList<>());
        for (int i = 1; i < grafo.length; i++)
            listaDeAdjacencia.get(grafo[i][0]).add(grafo[i][1]);
        return listaDeAdjacencia;
    }
}
