package lista;

public class ListaDuplaCauda<T> extends ListaSimplesCauda<T> {

    public ListaDuplaCauda() {
        this.frente = null;
        this.fundo = null;
    }

    public void insereInicio(int chave, T dados) {
        Elemento<T> e = new Elemento<T>(chave,dados);
        if (this.vazia()) {
            this.fundo = e;
        } else {
            e.setProximo(this.frente);
            this.frente.setAnterior(e);
        }
        this.frente = e;
    }

    public void insereFim(int chave, T dados) {
        Elemento<T> e = new Elemento<T>(chave,dados);
        if (this.vazia()) {
            this.frente = e;
        } else {
            e.setAnterior(this.fundo);
            this.fundo.setProximo(e);
        }
        this.fundo = e;
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
            this.frente.setAnterior(null);
        }
        return e;
    }

    public Elemento<T> removeFim() throws Exception { //retorna, removendo
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> e = this.fundo;
        if (e == this.frente) {
            this.frente = null;
            this.fundo = null;
        } else {
            this.fundo = e.getAnterior();
            this.fundo.setProximo(null);
        }
        return e;
    }

    public void apagar(int chave) throws Exception { //se não achar, apagado está!
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        Elemento<T> e = this.encontrar(chave);
        if (e != null) {
            if (e == this.frente) {
                this.removeInicio();
            } else if (e == this.fundo) {
                this.removeFim();
            }
            else {
                Elemento<T> antecessor = e.getAnterior();
                Elemento<T> sucessor = e.getProximo();
                antecessor.setProximo(sucessor);
                sucessor.setAnterior(antecessor);
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
            Elemento<T> sucessor = buscado.getProximo();
            e.setProximo(sucessor);
            sucessor.setAnterior(e);    
            e.setAnterior(buscado);
            buscado.setProximo(e);    
        }
    }

    public void insereAntes(Elemento<T> buscado, int chave, T dados) throws Exception {
        if (this.vazia()) {
            throw new Exception("lista vazia");
        }
        if (buscado == this.frente) {
            this.insereInicio(chave, dados);
        } else {
            Elemento<T> e = new Elemento<T>(chave,dados);
            Elemento<T> antecessor = buscado.getAnterior();
            e.setAnterior(antecessor);
            antecessor.setProximo(e);    
            e.setProximo(buscado);
            buscado.setAnterior(e);  
        }
    }
    
    //getInicio, vazia, encontrar, getFim não mudam

}
