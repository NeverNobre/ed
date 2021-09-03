package heap;

public class TesteHeap {
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(10);
        try {
            h.Insert(10);
            h.Insert(20);
            h.Insert(40);
            h.Insert(15);
            h.Insert(25);
            h.Insert(50);
            h.Imprime();
            System.out.println(h.ExtractMax());
            System.out.println(h.ExtractMax());
            h.Imprime();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

