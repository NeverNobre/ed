package lista;

public class Elemento<T> {

    private T dados;
    private int chave;
    private Elemento<T> proximo;
    private Elemento<T> anterior;
    
    public Elemento(int chave, T dados) {
        this.dados = dados;
        this.chave = chave;
        this.proximo = null;
        this.anterior = null;
    }

    public int getChave() {
        return this.chave;
    }

    public T getDados() {
        return this.dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public void setChave(T dados) {
        this.dados = dados;
    }

    public void setProximo(Elemento<T> p) {
        this.proximo = p;
    }

    public Elemento<T> getProximo() {
        return this.proximo;
    }

    public void setAnterior(Elemento<T> p) {
        this.anterior = p;
    }

    public Elemento<T> getAnterior() {
        return this.anterior;
    }

    public String toString() {
        return "Chave: " + getChave() + ", Dados: " + getDados();
    }

}
