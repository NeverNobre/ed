package lista;

public class ListaSimples<T> {

    protected Elemento<T> frente;
    
    public ListaSimples() {
        this.frente = null;
    }

    public boolean vazia() {
        if (this.frente == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insereInicio(int chave, T dados) {
        Elemento<T> e = new Elemento<T>(chave,dados);
        e.setProximo(this.frente); //se lista vazia, ficar√° nulo; se n√£o, aponta para o primeiro elemento
        this.frente = e;
    }
    
    public void insereEm(int posicao, Elemento<T> e) throws Exception{
    	if (posicao<0) throw new Exception("PosiÁ„o Inv·lida");
    	if (posicao==0) {
    		e.setProximo(this.frente);
    		this.frente=e;
    	} else {
    		Elemento<T> atual=this.frente;
    		int i=1;
    		if (1==posicao) {
				e.setProximo(atual.getProximo());
				atual.setProximo(e);
				return;
			}
    		while (posicao>i) {
    			if (i==posicao) {
    				e.setProximo(atual.getProximo());
    				atual.setProximo(e);
    				return;
    			}
    			i++;
    			atual=atual.getProximo();
    		}
    		throw new Exception("PosiÁ„o Inv·lida");
    	}
    	
    	
    }

    public void insereFim(int chave, T dados) {
        if (this.vazia()) { 
            this.insereInicio(chave, dados);
        } else {
            Elemento<T> e = new Elemento<T>(chave,dados);
            Elemento<T> atual = this.frente;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(e);    
        }
    }

    public Elemento<T> getInicio() throws Exception {
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        return this.frente;
    }

    public Elemento<T> getFim() throws Exception {
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> atual = this.frente;
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public Elemento<T> removeInicio() throws Exception { //retorna, removendo
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> e = this.frente;
        this.frente = this.frente.getProximo();
        return e;
    }

    public Elemento<T> removeFim() throws Exception { //retorna, removendo
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> anterior = null;
        Elemento<T> atual = this.frente;
        while (atual.getProximo() != null) {
            anterior = atual;
            atual = atual.getProximo();
        }
        if (anterior == null) { //anterior √© null quando h√° apenas 1 elemento
            this.frente = null;
        } else {
            anterior.setProximo(null);
        }
        return atual;        
    }

    public Elemento<T> encontrar(int chave) throws Exception { //retorna null se n√£o encontrar
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> atual = this.frente;
        boolean achado = false;
        while (atual != null) {
            if (atual.getChave() == chave) {
                achado = true;
                break;
            } else {
                atual = atual.getProximo();
            }
        }
        if (achado) {
            return atual;
        } else {
            return null;
        }
    }

    public void apagar(int chave) throws Exception { //se n√£o achar, apagado est√°!
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> anterior = null;
        Elemento<T> atual = this.frente;
        boolean achado = false;
        while (atual != null) {
            if (atual.getChave() == chave) {
                achado = true;
                break;
            } else {
                anterior = atual;
                atual = atual.getProximo();    
            }
        }
        if (achado) {
            if (anterior == null) { //anterior √© null quando o primeiro elemento deve ser apagado
                this.frente = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
        }
    }

    public void insereApos(Elemento<T> buscado, int chave, T dados) throws Exception {
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> e = new Elemento<T>(chave,dados);
        e.setProximo(buscado.getProximo());
        buscado.setProximo(e);
    }

    public void insereAntes(Elemento<T> buscado, int chave, T dados) throws Exception { //se n√£o achar, dispara excecao
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> anterior = null;
        Elemento<T> atual = this.frente;
        boolean achado = false;
        while (atual != null) {
            if (atual == buscado) {
                achado = true;
                break;
            } else {
                anterior = atual;
                atual = atual.getProximo();    
            }
        }
        if (achado) {
            Elemento<T> e = new Elemento<T>(chave,dados);
            if (anterior == null) {
                this.insereInicio(chave, dados);
            } else {
                anterior.setProximo(e);
                e.setProximo(atual);
            }
        } else {
            throw new Exception("chave n√£o encontrada");
        }
    }

    public void Imprime() {
        System.out.println("==========");
        Elemento<T> atual = this.frente;
        while (atual != null) {
            System.out.print(atual);
            System.out.print("| ");
            atual = atual.getProximo();
        }
        System.out.println("");
    }

}
