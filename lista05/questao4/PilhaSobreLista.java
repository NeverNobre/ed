package questao4;

import lista.ListaDuplaCauda;
import lista.Elemento;

public class PilhaSobreLista<T> {
	private ListaDuplaCauda lista;
	
	public PilhaSobreLista() {
		this.lista= new ListaDuplaCauda();
	}
	
	public void Push(int chave, T dados) {
		this.lista.insereInicio(chave, dados);;
	}
	
	public Elemento Pop(){
		try {
			return this.lista.removeInicio();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Elemento Top(){
		try {
			return this.lista.getInicio();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean Empty(){
		return lista.vazia();
	}
	
}
