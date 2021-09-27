package lendoarquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Teste2 {

	public static void main(String[] args) throws Exception {
		long startTime= System.nanoTime();
		
		String result[];
		BufferedReader reader= new BufferedReader(new FileReader("src/lendoarquivo/access.log"));
		
		HashMap<String, Integer> frequency= new HashMap<>();
		String line= reader.readLine();
		while (line!= null) {
			result= line.split(" - - ");
			
			if (frequency.containsKey(result[0])) 
				frequency.put(result[0], frequency.get(result[0])+1);
			else
				frequency.put(result[0], 1);
			
			line= reader.readLine();
		}
		
		long finishTime= System.nanoTime()-startTime;
		System.out.println("Tempo da montagem de dados: "+finishTime+" nanosegundos");
		
		reader= new BufferedReader(new FileReader("src/lendoarquivo/Lista100enderecos.txt"));
		line=reader.readLine();
		
		while(line!=null) {
			long consultaMapaInicio=System.nanoTime();
			
			int vezes;
			if (frequency.containsKey(line))
			vezes= frequency.get(line);
			else
				vezes=0;
			
			long consultaMapaDuracao=System.nanoTime()- consultaMapaInicio;
			
			System.out.print("IP "+line+" apareceu "+vezes+" vezes. ");
			System.out.println("Tempo de consulta: "+consultaMapaDuracao+" nanosegundos\n");
			
			line= reader.readLine();
		}
	}
}
