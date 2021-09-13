package questao5;

import java.util.Scanner;
public class MainTeste {

	public static void main(String[] args) throws Exception {
		Scanner ler= new Scanner(System.in);
		
		FilaSobreLista fila= new FilaSobreLista();
		fila.Enqueue(2, true);
		fila.Enqueue(5, "Oi!");
	
		System.out.print("INSIRA NUMERO INTEIRO: ");
		fila.Enqueue(8, ler.nextInt());
		
		System.out.print("INSIRA NUMERO COM VIRGULA: ");
		fila.Enqueue(0, ler.nextDouble());
		
		while(!fila.QueueEmpty()) {
		System.out.println(fila.Dequeue());
		}	
	}
}
