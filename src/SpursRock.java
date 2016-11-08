import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
public class SpursRock {

	private static final Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		String separa = "";
		List<String> todasInstanciasP = new LinkedList<String>();
		int totalTimes = Integer.parseInt(s.nextLine());
		int totalInstancias = 0;
		int[][] times = new int[totalTimes][4];
		while(totalTimes != 0){
			
			totalInstancias++;
			int totalJogos = totalTimes * (totalTimes - 1) / 2;
			for(int x = 0; x < totalTimes; x++){
				times[x][0] = x + 1;
			}
			for(int x = 0; x < totalJogos; x++){
				String entrada = s.nextLine();
				String[] caractere = entrada.split(" ");
				int inscricaoTime1 = Integer.parseInt(caractere[0]);
				int pontuacaoTime1 = Integer.parseInt(caractere[1]);
				int inscricaoTime2 = Integer.parseInt(caractere[2]);
				int pontuacaoTime2 = Integer.parseInt(caractere[3]);
				for(int y = 0; y < totalTimes; y++){
					if(inscricaoTime1 == times[y][0]){
						times[y][1] += pontuacaoTime1;
						times[y][2] += pontuacaoTime2;
						if(pontuacaoTime1 > pontuacaoTime2){
							times[y][3] += 2;
						}
					}else if(inscricaoTime2 == times[y][0]){
						times[y][1] += pontuacaoTime2;
						times[y][2] += pontuacaoTime1;
						if(pontuacaoTime2 > pontuacaoTime1){
							times[y][3] += 2;
						}
					}
				}
				
				
			}
			int menor = 0;
			int[] aux;
			for(int x = 0; x < times.length; x++){
				menor = x;
				for(int y = x + 1; y < times.length; y++ ){
					if(times[y][3] > times[menor][3]){
						aux = times[menor];
						times[menor] = times[y];
						times[y] = aux;
					}else if(times[y][3] == times[menor][3]){
						double mediaTime1 = 0;
						if(times[y][2] != 0){
							mediaTime1 = (double)times[y][1] / times[y][2];
						}else{
							mediaTime1 = times[y][1];
						}
						double mediaTime2 = 0;
						if(times[menor][2] != 0){
							mediaTime2 = (double)times[menor][1] / times[menor][2];
						}else{
							mediaTime2 = times[menor][1];
						}
						if(mediaTime1 > mediaTime2){
							aux = times[menor];
							times[menor] = times[y];
							times[y] = aux;
						}else if(mediaTime1 == mediaTime2){
							if(times[y][1] > times[menor][1]){
								aux = times[menor];
								times[menor] = times[y];
								times[y] = aux;
							}else if(times[y][1] == times[menor][1]){
								if(times[y][0] < times[menor][0]){
									aux = times[menor];
									times[menor] = times[y];
									times[y] = aux;
								}
							}
						}
					}
				}
			}
			separa = "";
			separa += "Instancia " + totalInstancias + "\n";
			for(int x = 0; x < totalTimes; x++){
				separa += times[x][0];
				if(x+1 != totalTimes){
					separa += " ";
				}
			}
			todasInstanciasP.add(separa);
			todasInstanciasP.add("");
			totalTimes = Integer.parseInt(s.nextLine());
		}
		for(int x = 0; x < todasInstanciasP.size() -1; x++){
			System.out.println(todasInstanciasP.get(x));
		}
	}
}
