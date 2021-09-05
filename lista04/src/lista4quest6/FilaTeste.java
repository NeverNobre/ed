package lista4quest6;
import java.util.Stack;

public class FilaTeste {

	public static void main(String[] args) {
		Fila AAA=new Fila();
		AAA.Enqueue("obrigado");
		AAA.Enqueue("alimento");
		AAA.Enqueue(false);
		AAA.Enqueue(123);
		AAA.Imprime();
		try{System.out.println("sai da fila: "+AAA.Dequeue());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		AAA.Imprime();
	}

}
