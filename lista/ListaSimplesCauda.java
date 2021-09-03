package lista;

public class ListaSimplesCauda<T> extends ListaSimples<T> {
    
    protected Elemento<T> fundo;

    public ListaSimplesCauda() {
        this.frente = null;
        this.fundo = null;
    }

    public void insereInicio(int chave, T dados) {
        Elemento<T> e = new Elemento<T>(chave,dados);
        if (this.vazia()) {
            this.fundo = e;
        } else {
            e.setProximo(this.frente);
        }
        this.frente = e;
    }

    public void insereFim(int chave, T dados) {
        Elemento<T> e = new Elemento<T>(chave,dados);
        if (this.vazia()) {
            this.frente = e;
        } else {
            this.fundo.setProximo(e);
        }
        this.fundo = e;
    }

    public Elemento<T> getFim() throws Exception {
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        return this.fundo;
    }

    public Elemento<T> removeInicio() throws Exception { //retorna, removendo
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> e = this.frente;
        if (e == this.fundo) {
            this.frente = null;
            this.fundo = null;
        } else {
            this.frente = this.frente.getProximo();
        }
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
        if (anterior == null) { //anterior é null quando há apenas 1 elemento
            this.frente = null;
            this.fundo = null;
        } else {
            anterior.setProximo(null);
            this.fundo = anterior;
        }
        return atual;        
    }

    public void apagar(int chave) throws Exception { //se não achar, apagado está!
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
            if (atual == this.frente) {
                this.removeInicio();
            } else if (atual == this.fundo) {
                this.removeFim();
            }
            else {
                anterior.setProximo(atual.getProximo());
            }
        }
    }

    public void insereApos(Elemento<T> buscado, int chave, T dados) throws Exception {
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        if (buscado == this.fundo) {
            this.insereFim(chave, dados);
        } else {
            Elemento<T> e = new Elemento<T>(chave,dados);
            e.setProximo(buscado.getProximo());
            buscado.setProximo(e);    
        }
    }
  
    //getInicio, vazia, encontrar e InsereAntes não mudam
}
