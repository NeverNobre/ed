package questao5;

import lista.Elemento;
import lista.ListaDuplaCauda;

public class FilaSobreLista<T> {

	private ListaDuplaCauda lista;
	
	public FilaSobreLista() {
		this.lista=new ListaDuplaCauda();
	}
	
	public void Enqueue(int chave, T dados) {
		this.lista.insereFim(chave, dados);
	}
	
	public Elemento Dequeue() throws Exception{
		return this.lista.removeInicio();
	}
	
	public boolean QueueFull() {
		return false;		//a lista cresce indefinidademente, QueueFull nunca pode ser true
	}
	
	public boolean QueueEmpty() {
		return lista.vazia();
	}
}
