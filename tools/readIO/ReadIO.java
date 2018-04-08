package TrabalhoAlgoritmosEmGrafos.tools.readIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadIO {
	
	public static int[][] carregarGrafo(String textName){
		int arestas[][];
		String num1,num2;
		String par[]=new String[2];
		String path="instancias//"+textName;
		int i=1;
		try {
			BufferedReader leitor=new BufferedReader(new FileReader(path));
			String linha;
			arestas=new int[countLines(path)-1][2];
			arestas[0][0]=Integer.parseInt(leitor.readLine().split(" ")[0]);
			arestas[0][1]=1;
			leitor.readLine();
			while ((linha = leitor.readLine()) != null) {
			     par=linha.split(" ");
			     num1=par[0];
			     num2=par[1];
			     arestas[i][0]=Integer.parseInt(num1);
			     arestas[i][1]=Integer.parseInt(num2);
			     //System.out.println(arestas[i][0]+" "+arestas[i][1]);
			     i++;
			}
			leitor.close();
			return arestas;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	private static int countLines(String textName) {
		try {
			File arquivoLeitura = new File(textName);
			LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arquivoLeitura));
			linhaLeitura.skip(arquivoLeitura.length());
			int qtdLinha = linhaLeitura.getLineNumber();
			return qtdLinha;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	public static void visualizarLista() {
		File dir=new File("instancias");
		File files[]=dir.listFiles();
		Pattern regex=Pattern.compile("txt_saida");
		Pattern regex2=Pattern.compile("txt.saida");
		for (File file : files) {
			if(!regex.matcher(file.getName()).find() && !regex2.matcher(file.getName()).find()) {
				System.out.println(file.getName());
				
			}
		}
		
	}
	public static void main(String[] args) {
		visualizarLista();
		String arquivo=new Scanner(System.in).nextLine();
		carregarGrafo(arquivo);
	}

}
