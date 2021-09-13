package questao6;

import lista.Elemento;
import lista.ListaDuplaCauda;

public class ListaOrdenada<T> {
	private ListaDuplaCauda lista;
	
	public ListaOrdenada(){
		lista= new ListaDuplaCauda();
	}
	
	@SuppressWarnings("unchecked")
	public void Adiciona(int chave, T dados) throws Exception{
		if (this.lista.vazia()) {
			this.lista.insereInicio(chave, dados);
			}
		
		else if (lista.getInicio().getChave()>chave) 
				lista.insereInicio(chave, dados);
			else {
				Elemento<T> atual= lista.getInicio();	
				if(atual.getProximo()==null) 
					lista.insereFim(chave, dados);
				
				else {
					while(atual.getProximo()!=null) {
						if(atual.getProximo().getChave()>chave) {	
							atual.getProximo().setAnterior(new Elemento(chave,dados));
							atual.getProximo().getAnterior().setProximo(atual.getProximo());
							atual.setProximo(atual.getProximo().getAnterior());
							atual.getProximo().setAnterior(atual);
							return;
						}
						atual=atual.getProximo();
					}
					this.lista.insereFim(chave, dados);
				}
		}
		return;
	}
	
	@SuppressWarnings("unchecked")
    public void Imprime() throws Exception{
        System.out.println("==========");
        Elemento<T> atual = lista.getInicio();
        while (atual != null) {
            System.out.print(atual);
            System.out.println("| ");
            atual = atual.getProximo();
        }
        System.out.println("");
    }
}
