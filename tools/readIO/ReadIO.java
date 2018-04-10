package TrabalhoAlgoritmosEmGrafos.tools.readIO;

import java.io.*;
import java.util.regex.Pattern;

public class ReadIO {

    /**
     * O método converte um arquivo contendo um grafo em uma matriz
     * @param txtName nome do arquivo txt onde se encontra o grafo. Este .txt deve estar contido em uma pasta de nome instancias na raiz do programa
     * @return o grafo na forma de uma matriz n por 2 onde n é igual a quantidade de linhas no arquivo txt
     */
    public static int[][] carregarGrafo(String txtName) throws IOException {
        String path = "instancias//" + txtName;
        BufferedReader leitor = new BufferedReader(new FileReader(path));
        
        int[][] grafo = new int[countLines(path) - 1][2];
        //lé a 1 linha que contém a quantidade de vertices
        grafo[0][0] = Integer.parseInt(leitor.readLine().split(" ")[0]);
        grafo[0][1] = 1;
        
        //lé a 2 linha que não contém nada
        leitor.readLine();
        
        int i = 1;
        String par[], linha;
        //lé as demais linhas do arquivo
        while ((linha = leitor.readLine()) != null) {
            par = linha.split(" ");
            grafo[i][0] = Integer.parseInt(par[0]);
            grafo[i++][1] = Integer.parseInt(par[1]);
        }
        
        return grafo;
    }

    /**
     * O método conta as linhas de um arquivo
     * @param txtPath caminho do arquivo txt onde se encontra o grafo.
     * @return a quantidade de linhas no arquivo txt
     */
    private static int countLines(String txtPath) throws IOException {
        File arquivoLeitura = new File(txtPath);
        LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arquivoLeitura));
        linhaLeitura.skip(arquivoLeitura.length());
        int qtdLinha = linhaLeitura.getLineNumber();
        return qtdLinha;
    }
    
    /**
     * O método exibe os arquivos contendo os grafos na pasta com o nome instancias
     */
    public static void visualizarLista() {
        File dir = new File("instancias");
        File files[] = dir.listFiles();
        Pattern regex = Pattern.compile("txt_saida");
        Pattern regex2 = Pattern.compile("txt.saida");
        for (File file : files) {
            if (!regex.matcher(file.getName()).find() && !regex2.matcher(file.getName()).find())
                System.out.println(file.getName());
        }
    }
}
