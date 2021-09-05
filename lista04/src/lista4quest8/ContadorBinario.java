package lista4quest8;

import java.util.LinkedList;
import java.util.Queue;

public class ContadorBinario {
	private Queue<String> fila;
	private String resultado;
	
	public ContadorBinario(int n){
		fila= new LinkedList<String>();
		for (int i=1; i<=n; i++) {
			fila.add(this.NumeroParaBinario(i));
		}
		while(!fila.isEmpty())
			System.out.println(fila.poll());
		
	}
	public String NumeroParaBinario(int n) {
		this.resultado="";
		while (n>0) {
			resultado= n%2+ resultado;
			n=n/2;
		}
		return resultado;
	}
}
