import java.util.Scanner;
import java.util.ArrayList;
public class teste {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		String [] linha = entrada.nextLine().split(" ");
		while(!linha[0].contains("0") || !linha[1].contains("0") || !linha[2].contains("0")){
			int n = Integer.parseInt(linha[0]);
			int k = Integer.parseInt(linha[1]);
			int m = Integer.parseInt(linha[2]);
			ArrayList <Integer> lista = new ArrayList<Integer>();
			for(int x = 0; x < n; x++){
				lista.add(x+1);
			}
			int indiceK = 0;
			int indiceM = n-1;
			String string = "";
			int valorM = 0;
			int contM;
			int contK;
			while(lista.size() != 0){
				contM = 0;
				contK = 0;
				indiceK = indiceK + k - 1;
				while (indiceK >= n) indiceK = indiceK - n;
				
				indiceM = indiceM - m + 1;
				
				while (indiceM < 0) indiceM = n + indiceM;
				
				valorM = lista.get(indiceM);
				
				if (indiceK < indiceM) contM++;
				if (indiceM < indiceK) contK++;
				if (indiceM == indiceK){
					if (lista.get(indiceK) > 9) string += " ";
					else string += "  ";
					string += lista.get(indiceK);
					indiceM--;
					lista.remove(indiceK);
					if(lista.size() > 0) string += ",";
					n--;
				}
				else {
					if (lista.get(indiceK) > 9) string += " ";
					else string += "  ";
					string += lista.get(indiceK);
					if(lista.get(indiceM) > 9) string += " ";
					else string += "  ";
					string += lista.get(indiceM);
					
					lista.remove(indiceK);
					for(int x = 0; x < lista.size(); x++){
						if (lista.get(x) == valorM){
							lista.remove(x);
							break;
						}
					}
					contM++;
					indiceM = indiceM - contM;
					indiceK = indiceK - contK;
					if (lista.size() > 0) string += ",";
					n = n-2;
				}	
			}
			System.out.println(string);
			linha = entrada.nextLine().split(" ");
		}
	}
	
	
	

}