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
        e.setProximo(this.frente); //se lista vazia, ficará nulo; se não, aponta para o primeiro elemento
        this.frente = e;
    }

    public void insereFim(int chave, T dados) {
        if (this.vazia()) { 
            this.insereInicio(chave, dados);
        }
        Elemento<T> e = new Elemento<T>(chave,dados);
        Elemento<T> atual = this.frente;
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        atual.setProximo(e);
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
        if (anterior == null) { //anterior é null quando há apenas 1 elemento
            this.frente = null;
        } else {
            anterior.setProximo(null);
        }
        return atual;        
    }

    public Elemento<T> encontrar(int chave) throws Exception { //retorna null se não encontrar
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
            if (anterior == null) { //anterior é null quando o primeiro elemento deve ser apagado
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

    public void insereAntes(Elemento<T> buscado, int chave, T dados) throws Exception { //se não achar, dispara excecao
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
            throw new Exception("chave não encontrada");
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
