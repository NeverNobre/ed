package questao6;

import java.util.Scanner;
public class ListaOrdenadaTeste {
	
	public static void main(String[] args) throws Exception {
		Scanner ler= new Scanner(System.in);
		ListaOrdenada lista= new ListaOrdenada();
		
		lista.Adiciona(5, 5);
		lista.Adiciona(3, 20);
		lista.Adiciona(6, "quack");
		lista.Adiciona(4, 8.20);
		lista.Adiciona(6, 6);
		lista.Imprime();
		
	}
}
