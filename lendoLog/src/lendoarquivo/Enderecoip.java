package lendoarquivo;

public class Enderecoip {
	String ip;
	int cont;

	public Enderecoip(String ip){
		this.ip = ip;
		this.cont= 1;
	}
	public String getIP(){
		return this.ip;
	}
	public int getCont(){
		return this.cont;
	}
	public void addCont(){
		this.cont=this.cont+1;
	}
}
