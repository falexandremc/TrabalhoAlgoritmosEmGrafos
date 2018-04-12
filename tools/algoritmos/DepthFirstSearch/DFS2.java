package TrabalhoAlgoritmosEmGrafos.tools.algoritmos.DepthFirstSearch;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import TrabalhoAlgoritmosEmGrafos.tools.grafos.GrafosCriador;
import TrabalhoAlgoritmosEmGrafos.tools.readIO.ReadIO;
import java.io.IOException;
import java.util.Collections;

public class DFS2 {

    private static int maxVertexAuxiliar = 0;
    private static int time;

    @SuppressWarnings({"null"})
    //ok
    public static Vertice[] DFS(int[][] grafo) {
        long initialTime = System.currentTimeMillis();
        Vertice vertices[] = new Vertice[grafo.length];
        for (int i = 0; i < grafo.length; i++) {
            vertices[i] = new Vertice();
            //System.out.println(i+":"+vertices[i].getCor());
        }
        Stack<Integer> pilha = new Stack<>();
        int vertex = maxVertex(grafo);
        pilha.push(vertex);
        time = 1;
        vertices[vertex].setCor(Cor.CINZA);
        vertices[vertex].setD(time++);
        Integer u, v;
        while (!pilha.isEmpty()) {
            u = pilha.peek();
            v = adj(u, vertices, grafo);
            if (v != null) {
                if (vertices[v].getCor() == Cor.BRANCO) {
                    vertices[v].setCor(Cor.CINZA);
                    vertices[v].setD(time++);
                    pilha.push(v);
                }
            } else {
                vertices[u].setCor(Cor.PRETO);
                vertices[u].setF(time++);
                pilha.pop();
            }
        }
        System.out.printf("Tempo(em s): %.4f\n", ((System.currentTimeMillis() - initialTime) / 1000.0));
        return vertices;
    }
    //fix me

    public static Vertice[] DFS(LinkedList<LinkedList<Integer>> grafo) {
        long initialTime = System.currentTimeMillis();
        Vertice vertices[] = new Vertice[grafo.size()];
        for (int i = 0; i < grafo.size(); i++) {
            vertices[i] = new Vertice();
            //System.out.println(i+":"+vertices[i].getCor());
        }
        Stack<Integer> pilha = new Stack<>();
        int vertex = maxVertexAuxiliar;
        pilha.push(vertex);
        time = 1;
        vertices[vertex].setCor(Cor.CINZA);
        vertices[vertex].setD(time++);
        Integer u, v;
        while (!pilha.isEmpty()) {
            u = pilha.peek();
            v = adj(u, vertices, grafo);
            if (v != null) {
                if (vertices[v].getCor() == Cor.BRANCO) {
                    vertices[v].setCor(Cor.CINZA);
                    vertices[v].setD(time++);
                    pilha.push(v);
                }
            } else {
                vertices[u].setCor(Cor.PRETO);
                vertices[u].setF(time++);
                pilha.pop();
            }
        }

        System.out.printf("Tempo(em s): %.4f\n", ((System.currentTimeMillis() - initialTime) / 1000.0));
        return vertices;
    }

    public static Integer adj(int u, Vertice[] vertices, LinkedList<LinkedList<Integer>> grafo) {
        LinkedList<Integer> lista = grafo.get(u);
        Collections.sort(lista);
        for (Integer i : lista) {
            if (vertices[i].getCor() == Cor.BRANCO) {
                return i;
            }
        }
        return null;
    }
    //ok

    public static Integer adj(int u, Vertice[] vertices, int[][] adjacentes) {
        for (int a = 0; a < vertices.length; a++) {
            if (adjacentes[u][a] == 1 && vertices[a].getCor() == Cor.BRANCO) {
                return a;
            }
        }
        return null;
    }

    //ok
    private static int maxVertex(int[][] grafo) {
        int pos = 0;
        int max = 0;
        int cont = 0;

        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (grafo[i][j] == 1) {
                    cont++;
                }
                if (grafo[j][i] == 1) {
                    cont++;
                }
            }

            if (max < cont) {
                max = cont;
                pos = i;
            }

            cont = 0;
        }
        System.out.println(pos);
        return pos;
    }

    public static void main(String[] args) throws IOException {

//		ReadIO.visualizarLista();
//		String arquivo=new Scanner(System.in).nextLine();
//		int [][]matriz=ReadIO.carregarGrafo(arquivo);
//		int [][]grafo=GrafosCriador.paraMatrizDeAdjacencia(matriz);
//		int o=0;
//
//		for (Vertice v : DFS(grafo)) {
//			System.out.println(o+":"+v.getD()+"/"+v.getF());
//			o++;
//		}
        ReadIO.visualizarLista();
        String arquivo = new Scanner(System.in).nextLine();
        int[][] matriz = ReadIO.carregarGrafo(arquivo);
        LinkedList<LinkedList<Integer>> grafo = GrafosCriador.paraListaDeAdjacencia(matriz);
        //DFS(grafo);
        int o = 0;
        maxVertexAuxiliar = maxVertex(GrafosCriador.paraMatrizDeAdjacencia(matriz));
        for (Vertice v : DFS(grafo)) {
            System.out.println(o + ":" + v.getD() + "/" + v.getF());
            o++;
        }
    }
}
