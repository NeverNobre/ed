package lista;

public class TesteLista {
    
    public static void main(String[] args) {
        ListaDuplaCauda<String> l = new ListaDuplaCauda<String>();
        l.insereInicio(1, "augusto");
        l.insereInicio(2, "cesar");
        l.insereInicio(3, "julio");
        l.Imprime();
        l.insereFim(4, "nero");
        l.Imprime();
        Elemento<String> e;
        try {
            e = l.removeFim();
            l.Imprime();
            e = l.removeFim();
            l.Imprime();
            e = l.removeFim();
            l.Imprime();
            e = l.removeFim();
            l.Imprime();
            e = l.removeFim();
            l.Imprime();
        } catch (Exception exc) {
            System.out.println(exc);
        }
        try {
            l.insereInicio(1, "augusto");
            l.insereInicio(2, "cesar");
            l.insereInicio(3, "julio");
            l.insereFim(4, "nero");
            e = l.encontrar(3);
            System.out.println("Objeto com a chave procurada: " + e);
            e = l.encontrar(50);
            System.out.println("Objeto com a chave procurada: " + e);
            l.Imprime();
            l.apagar(3);
            //l.apagar(50);
            l.apagar(2);
            l.Imprime();
            //l.apagar(1);
            l.apagar(4);
            e = l.encontrar(1);
            l.insereAntes(e, 5, "caligula");
            l.insereAntes(e, 6, "constantino");
            e = l.encontrar(6);
            l.insereAntes(e, 8, "claudio");
            l.insereAntes(e, 10, "flavio");
            l.Imprime();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
