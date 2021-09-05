package lista4quest9;

import java.util.Stack;
/*
 *	problema das N Rainhas usando pilha e backtracking
 * 
 *  Estrat�gia:
 *  0 - Se a pilha ficar vazia, n�o h� mais a��es, ent�o encerre o m�todo executar.  
 *  1 - colocamos uma Rainha na posicao i=0 da linha j=1.
 *  	do tabuleiro, adicionando i ao topo da pilha.
 *  2- se o topo mostra uma posicao segura, passe para a proxima linha, tamb�m come�ando da posicao i=0,
 *  	se n�o for uma posicao segura, tente a posicao i+1, atualizando 
 *  o topo da pilha. 
 *  3- Caso nao haja mais posicoes na linha, o topo � removido,
 *  	e ao novo topo da pilha � adicionado 1, retomando a opera��o 2 
 *  
 */

public class NRainhas {
	private int N;
	private Stack<Integer> ultimoEstado;
	
	public NRainhas(int N) {
		this.N=N;
		this.ultimoEstado=new Stack<Integer>();
		Executar();
	}
	public void Executar () {
		this.ultimoEstado.add(0); 		//	para inicializa��o da pilha apenas
		int nSolucao=0;					//	numero da solu��o
		// while (true) repetir� at� que a linha 39 seja verdade
		while (true) {
			/*
			 * Enquanto houver estouro positivo na posi��o tabuleiro, volte para a linha anterior
			 * e tente novamente na pr�xima posi��o.
			 */
			while(this.ultimoEstado.peek()==N) {			
				ultimoEstado.pop();					//	remova o excesso
				if(this.ultimoEstado.empty())		//	verifique se a pilha est� vazia
					return;
				ultimoEstado.set(this.ultimoEstado.size()-1, this.ultimoEstado.lastElement()+1);
			}
			
			if(this.PosicaoSegura(this.ultimoEstado.size()-1, this.ultimoEstado.peek())) 
				this.ultimoEstado.add(0);
			else 
				ultimoEstado.set(this.ultimoEstado.size()-1, this.ultimoEstado.lastElement()+1);
			
			if (this.ultimoEstado.size()==N+1) { 	// 	se a pilha alcan�ar o tamanho do tabuleiro, � uma solu��o
				nSolucao++;
				this.ultimoEstado.pop(); 			//	remova o excesso
				ImprimaTabuleiro(nSolucao);
				ultimoEstado.set(this.ultimoEstado.size()-1, this.ultimoEstado.lastElement()+1);
			} 
		}
	}
	public boolean PosicaoSegura(int i, int j) {
		int a, b;
		
		// verifique se a posi��o na linha j� existia anteriormente na pilha
		// se verdade, ent�o aquela rainha est� atacando esta posi��o 
		for(int k=0; k<i; k++) { 
			if(this.ultimoEstado.elementAt(k)==j) {
				return false;  		//n�o � seguro
			}
		}
		
		/* 
		 * verifique se acerta alguma rainha nas diagonais inferiores,
		 * j� que com a pilha subindo n�o podem existir rainhas em cima.
		 * as express�es  de compara��o i==a+b-j e i==a-b+j v�m da equa��o
		 * modular a= -|b-j|+i, com i e j sendo as coordenadas da posi��o
		 *  
		*/
		for (a=0;a<i;a++) {
			b=this.ultimoEstado.elementAt(a);
			if(i==a+b-j||i==a-b+j)
				return false; //n�o � seguro
		}
		
		return true; 		// como h� apenas uma rainha por linha na pilha e		 				 
							// passou nos testes anteriores, ent�o � seguro;
	}
	public void ImprimaTabuleiro(int a) {
		System.out.println("Solu��o "+a+":\n");
		for(int i=0; i<N;i++) {
			for (int j=0; j<N; j++) {
				if (j==this.ultimoEstado.elementAt(i))
					System.out.print("R\t");
				else 
					System.out.print("-\t");
				}
			System.out.println("");
			}
		System.out.println("");
	}
}
