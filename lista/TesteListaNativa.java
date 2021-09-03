package lista;

import java.util.LinkedList;

public class TesteListaNativa {

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<String>();
        l.isEmpty();
        l.addLast("a");
        l.addFirst("b");
        l.addLast("d");
        l.addFirst("c");
        l.removeLast();
        System.out.println(l);
    }
    
}
