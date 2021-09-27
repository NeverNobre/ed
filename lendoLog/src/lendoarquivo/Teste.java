package lendoarquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Teste {
	
	public static LinkedList<Enderecoip> listaips;
	
	public static void main(String[] args)throws Exception{
		long startTime = System.nanoTime(); //para medir tempo da execução 
		listaips= new LinkedList<>();
		
		String result[];
		
		
		BufferedReader bufferedReader= new BufferedReader(new FileReader("src/lendoarquivo/access.log"));
		long contador=0;
		String currentLine=bufferedReader.readLine();
		while(currentLine!=null) {
			contador++;
			
			result= currentLine.split(" - - ");
			adicionaNaLista(result[0]);
			
			currentLine=bufferedReader.readLine();
		}
		long estimatedTime= System.nanoTime()-startTime; //para medir tempo da execução
		System.out.println("Tempo da montagem de dados: "+estimatedTime+" nanosegundos");
		
		bufferedReader= new BufferedReader(new FileReader("src/lendoarquivo/Lista100enderecos.txt"));
		currentLine=bufferedReader.readLine();
		
		while(currentLine!=null) {
			long consultaListaInicio= System.nanoTime();
			
			int vezes= encontraip(currentLine);
			
			long consultaListaDuracao=System.nanoTime()-consultaListaInicio;
			
			System.out.println("IP "+currentLine+" apareceu "+vezes+" vezes.\n");
			System.out.println("Tempo da consulta na lista: "+consultaListaDuracao+" nanosegundos\n");
			
			currentLine=bufferedReader.readLine();
		}
		
	}
	
	public static void adicionaNaLista(String ip){		
		ListIterator<Enderecoip> listaiterada = listaips.listIterator();
		Enderecoip i;
		
		while(listaiterada.hasNext()){
			i = listaiterada.next();
			if(i.getIP().equals(ip)){
				i.addCont();
				return;
			}
		}
		listaips.add(new Enderecoip (ip));
	}
	public static int encontraip(String ip) {
		ListIterator<Enderecoip> listaiterada = listaips.listIterator();
		while(listaiterada.hasNext()){
			Enderecoip i = listaiterada.next();
			if(i.getIP().equals(ip))
				return i.getCont();			
		}
		return 0;
	}
}
