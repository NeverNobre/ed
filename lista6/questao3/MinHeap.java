public class MinHeap{
    
    private int size;
    private int maxSize;
    private int H[];

    public MinHeap(int max) {
        this.maxSize = max;
        this.size = 0;
        this.H = new int[max];
    }

    public int Parent(int i) {
        return (int) Math.floor((i-1)/2); //floor(i/2) para arranjo começando em 1
    }

    public int LeftChild(int i) {
        return 2*i + 1; //2i para arranjo começando em 1
    }

    public int RightChild(int i) {
        return 2*i + 2; //2i+2 para arranjo começando em 1
    }

    public void Swap(int i, int j) {
        int tmp = H[i];
        H[i] = H[j];
        H[j] = tmp;
    }

    public void ChangeUp(int i) {
        if (i>0 && H[Parent(i)]>H[i]) {
            Swap(i,Parent(i));
            ChangeUp(Parent(i));
        }
    }

    public void ChangeDown(int i) {
        int minIndex = i;
        int l = LeftChild(i);
        if (l <= size-1 && H[l] < H[minIndex]) {
            minIndex = l;
        }
        int r = RightChild(i);
        if (r <= size-1 && H[r] < H[minIndex]) {
            minIndex= r;
        }
        if (i != minIndex) {
            Swap(i,minIndex);
            ChangeDown(minIndex);
        }
    }

    public int getMinx() {
        if (size > 0) {
            return H[0];
        } else {
            return -1;
        }
    }    

    public void Insert (int p) throws Exception {
        if (size == maxSize) {
            throw new Exception("heap cheia");
        }
        H[size] = p;
        size++;
        ChangeUp(size-1);
    }

    public int ExtractMin() {
        int result = H[0];
        H[0] = H[size-1];
        size = size - 1;
        ChangeDown(0);
        return result;
    }

    public void Remove (int i) {
        H[i] = Integer.MAX_VALUE;
        ChangeUp(i);
        ExtractMin();
    }

    public void ChangeValue(int i, int p) {
        int oldp = H[i];
        H[i] = p;
        if (p > oldp) {
            ChangeDown(i);
        } else {
            ChangeUp(i);
        }
    }

    public void Imprime() {
        System.out.print("[");
        for (int i=0; i < size; i++) {
            System.out.print(this.H[i]+" ");
        }
        System.out.println("]");
    }

}
