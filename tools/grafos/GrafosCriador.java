package TrabalhoAlgoritmosEmGrafos.tools.grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import TrabalhoAlgoritmosEmGrafos.tools.readIO.ReadIO;
public class GrafosCriador {
	public static int[][] paraMatrizDeAdjacencia(int [][]grafos) {
		int g=grafos[0][0];
		int [][]grafo=new int[g][g];
		for(int[] i:grafos) {
			if(i[0]!=g)grafo[i[0]][i[1]]=1;
		}
		/*
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo.length; j++) {
				System.out.print(grafo[i][j]+" ");
			}
			System.out.println();
		}
		*/
		return grafo;
	}
	public static void paraListaDeAdjacencia(int [][]grafos) {
		int g=grafos[0][0];//quantidade de vertices do grafo

		LinkedList<LinkedList<Integer>> grafo=new LinkedList<>();
		for (int i = 0; i < g; i++) {
			grafo.add(new LinkedList<>());
		}
	}
	public static void main(String[] args) {
		ReadIO.visualizarLista();
		String arquivo=new Scanner(System.in).nextLine();
		int [][]matriz=ReadIO.carregarGrafo(arquivo);
		paraListaDeAdjacencia(matriz);
	}
}
