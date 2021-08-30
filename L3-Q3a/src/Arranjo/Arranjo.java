package Arranjo;

public class Arranjo<T> {

    private T[] Data;
    
    @SuppressWarnings("unchecked")
    public Arranjo(int tam) {
        this.Data = (T[]) new Object[tam];
    }

    public T Get(int i) {
        return this.Data[i];
    }

    public void Set(int i, T obj) {
        this.Data[i] = obj;
    }

    public void Imprime() {
        System.out.print("[");
        for (int i=0; i < this.Data.length; i++) {
            System.out.print(this.Data[i]+" ");
        }
        System.out.println("]");
    }
    public void InsiraDado(T obj) throws Exception{
    	int length=Data.length;
    	int ultimoNull=-1; 				 //ultimo indice nao ocupado
    	
    	for(int i=length-1; i>=0; i--) { //procure de baixo para cima no arranjo
    		if (Data[i]==null) {	 	 //caso encontre uma posicao nao ocupada
    			ultimoNull=i;			 //atribua o indice ao ultimoNull
    			break;					 //e interrompa for
    		}
    	}
    	if (ultimoNull==-1) {		  	 //se ultimoNull nao foi atualizado
    		throw new Exception("Todas posições ocupadas!");
    	}
    	else { 						 	 //se foi atualizado
    		Data[ultimoNull]=obj;     	 //coloque o dado na ultima posicao nao ocupada
    	}
    }
    public void InsiraDadoPrimeiraPosicao(T obj) throws Exception{
    	InsiraDadoNaPosicao(0, obj);	
    }
    public void InsiraDadoNaPosicao(int posicao, T obj) throws Exception{
    	if(posicao<0||posicao>=Data.length) //considere posicao==indice
    		throw new Exception("Fora do escopo");
    	
    	T temp1=obj;								// temp1 e temp2 servindo para auxiliar 
    	T temp2=obj;								// no movimento dos dados
    	int length=Data.length;
    	
    	if(Data[length-1]==null)					// se for possivel adicionar objeto
    		for (int i=posicao; i<length; i++) {	// parta da posicao desejada			
    			if(i%2==0) {						// o par if-else garante o uso alternado
    				temp1=Data[i];					// de temp1 e temp2, movendo todos os
    				Data[i]=temp2;					// dados subsequentes do aranjo "para baixo"
    			} else {
    				temp2=Data[i];
    				Data[i]=temp1;
    			}
    		}
    	else										// se nao for possivel, dispare excecao
    		throw new Exception("Arranjo Cheio!");
    }
	
    public T RetorneUltimaPosicaoOcupada() throws Exception{
    	T obj=null;
    	int length= Data.length;
    	int ultimaPosicaoOcupada=-1;
		
    	for(int i=length-1; i>=0; i--) {// procure "de baixo para cima"
			if(Data[i]!=null) {			// se encontar posicao nao ocupada
				ultimaPosicaoOcupada=i;	// so pode ser a ultima posicao ocupada
				break;
			}
		}
		
    	if (ultimaPosicaoOcupada!=-1) {		// caso ultimaPosicaoOcupada tenha atualizado
    		obj=Data[ultimaPosicaoOcupada];	// atribua seu valor ao obj
			Data[ultimaPosicaoOcupada]=null;// remova seu valor do arranjo
			return obj;						// retorne seu valor
			}
    	else								// caso nao tenha atualizado, lance uma excecao
			throw new Exception("Arranjo vazio!");
	}
	public T RetornePrimeiraPosicao() throws Exception{
		return RetorneDaPosicao(0);			// retorne do indice/posicao zero
	}
	
	public T RetorneDaPosicao(int posicao) throws Exception{
		if(posicao<0||posicao>=Data.length)			//	tenha certeza que a posicao seja valida 
    		throw new Exception("Fora do escopo");
		
		T temp1=null;
    	T temp2=null;	//iniciados com null para inserir null na ultima posicao do arranjo
    	
    	if (Data[posicao]==null)					// dispare excecao se nao houver dado na posicao
    		throw new Exception("Sem dado na posicao");
    	
    	T aSerRetornado=Data[posicao];				// guarde o dado requisitado antes de manipular o arranjo
    	
    	int length=Data.length;
    	for (int i=length-1; i>=posicao; i--) {		// varra o arranjo "de baixo para cima" ate a posicao pedida
    		if(i%2==0) {
   				temp1=Data[i];
   				Data[i]=temp2;
   			} else {
    			temp2=Data[i];
    			Data[i]=temp1;
    		}
   		}
		return aSerRetornado;
	}
}