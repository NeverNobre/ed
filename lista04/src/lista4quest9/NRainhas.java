package lista4quest9;

import java.util.Stack;
/*
 *	problema das N Rainhas usando pilha e backtracking
 * 
 *  Estratégia:
 *  0 - Se a pilha ficar vazia, não há mais ações, então encerre o método executar.  
 *  1 - colocamos uma Rainha na posicao i=0 da linha j=1.
 *  	do tabuleiro, adicionando i ao topo da pilha.
 *  2- se o topo mostra uma posicao segura, passe para a proxima linha, também começando da posicao i=0,
 *  	se não for uma posicao segura, tente a posicao i+1, atualizando 
 *  o topo da pilha. 
 *  3- Caso nao haja mais posicoes na linha, o topo é removido,
 *  	e ao novo topo da pilha é adicionado 1, retomando a operação 2 
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
		this.ultimoEstado.add(0); 		//	para inicialização da pilha apenas
		int nSolucao=0;					//	numero da solução
		// while (true) repetirá até que a linha 39 seja verdade
		while (true) {
			/*
			 * Enquanto houver estouro positivo na posição tabuleiro, volte para a linha anterior
			 * e tente novamente na próxima posição.
			 */
			while(this.ultimoEstado.peek()==N) {			
				ultimoEstado.pop();					//	remova o excesso
				if(this.ultimoEstado.empty())		//	verifique se a pilha está vazia
					return;
				ultimoEstado.set(this.ultimoEstado.size()-1, this.ultimoEstado.lastElement()+1);
			}
			
			if(this.PosicaoSegura(this.ultimoEstado.size()-1, this.ultimoEstado.peek())) 
				this.ultimoEstado.add(0);
			else 
				ultimoEstado.set(this.ultimoEstado.size()-1, this.ultimoEstado.lastElement()+1);
			
			if (this.ultimoEstado.size()==N+1) { 	// 	se a pilha alcançar o tamanho do tabuleiro, é uma solução
				nSolucao++;
				this.ultimoEstado.pop(); 			//	remova o excesso
				ImprimaTabuleiro(nSolucao);
				ultimoEstado.set(this.ultimoEstado.size()-1, this.ultimoEstado.lastElement()+1);
			} 
		}
	}
	public boolean PosicaoSegura(int i, int j) {
		int a, b;
		
		// verifique se a posição na linha já existia anteriormente na pilha
		// se verdade, então aquela rainha está atacando esta posição 
		for(int k=0; k<i; k++) { 
			if(this.ultimoEstado.elementAt(k)==j) {
				return false;  		//não é seguro
			}
		}
		
		/* 
		 * verifique se acerta alguma rainha nas diagonais inferiores,
		 * já que com a pilha subindo não podem existir rainhas em cima.
		 * as expressões  de comparação i==a+b-j e i==a-b+j vêm da equação
		 * modular a= -|b-j|+i, com i e j sendo as coordenadas da posição
		 *  
		*/
		for (a=0;a<i;a++) {
			b=this.ultimoEstado.elementAt(a);
			if(i==a+b-j||i==a-b+j)
				return false; //não é seguro
		}
		
		return true; 		// como há apenas uma rainha por linha na pilha e		 				 
							// passou nos testes anteriores, então é seguro;
	}
	public void ImprimaTabuleiro(int a) {
		System.out.println("Solução "+a+":\n");
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
