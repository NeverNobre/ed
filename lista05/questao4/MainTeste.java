package questao4;

import java.util.Scanner;
public class MainTeste {

	public static void main(String[] args) throws Exception {
		Scanner ler= new Scanner(System.in);
		
		PilhaSobreLista pilha= new PilhaSobreLista();
		pilha.Push(2, true);
		pilha.Push(5, "Oi!");
		
		System.out.print("INSIRA NUMERO INTEIRO: ");
		pilha.Push(8, ler.nextInt());
		
		System.out.print("INSIRA NUMERO COM VIRGULA: ");
		pilha.Push(0, ler.nextDouble());
		
		while(!pilha.Empty()) {
		System.out.println(pilha.Pop());
		}
	}
}
