package lista4quest6;

import java.util.Stack;

public class Fila{
	private Stack pilha1;
	private Stack pilha2;
	
	private boolean filaInvertida;
	
	public Fila() {
		pilha1= new Stack();
		pilha2= new Stack();
		filaInvertida=false;
	}
	public boolean QueueEmpty() {
		if (pilha2.empty()&&pilha1.empty()) {
			return true;
		} else {
			return false;
		}
	}
	public void ViraPilha() {
		if(pilha1.empty()) {
			while (!pilha2.empty()) {
			pilha1.add(pilha2.pop());
			}
		} else {
			while (!pilha1.empty()) {
				pilha2.add(pilha1.pop());
			}
		}
		this.filaInvertida=!this.filaInvertida;
	}
	
	public void Enqueue(Object obj) {
		if(this.filaInvertida) { 
			this.ViraPilha();
		}
		pilha1.add(obj);
	}
	
	public Object Dequeue() throws Exception{
		if(this.QueueEmpty()) {
			throw new Exception("Fila Vazia");
			}
		if(this.filaInvertida)
			return pilha2.pop();
		else {
			this.ViraPilha();
			return pilha2.pop();
		}
	}
	
	public void Imprime() {
		if(this.QueueEmpty()) {
			System.out.print("Fila Vazia");
			return;
		}
		if(this.filaInvertida) {
			this.ViraPilha();
		}
		System.out.println("Head: "+ pilha1.firstElement());
		System.out.println("Tail: "+ pilha1.lastElement());
		System.out.print("Dados: ");
		for(int i=0; i<this.pilha1.size(); i++) {
			System.out.print(pilha1.elementAt(i)+", ");
		}
		System.out.println("");	
	}
}
