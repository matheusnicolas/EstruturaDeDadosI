import java.io.IOException;
import java.util.Scanner;
public class sorteaParesImpares {

	private static final Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		
		int quantidade, numero, contPar = 0, contImpar = 0;
		
		quantidade = s.nextInt();
		int[] totalNum = new int[quantidade];
		for(int x = 0; x < quantidade; x++){
			numero = s.nextInt();
			if(numero % 2 == 0){
				contPar++;
			}else if(numero % 2 != 0){
				contImpar++;
			}
			totalNum[x] = numero;
		}
		metodosSort(totalNum);
		
		int[] totalPar = new int[contPar];
		int[] totalImpar = new int[contImpar];
		int indiceP = 0, indiceI = 0;
		for(int i = 0; i < totalNum.length; i++){
			if(totalNum[i] % 2 == 0){
				totalPar[indiceP] = totalNum[i];
				indiceP++;
			}else if(totalNum[i] % 2 != 0){
				totalImpar[indiceI] = totalNum[i];
				indiceI++;
			}
		}
		
		for(int x: totalPar){
			System.out.println(x);
		}
		
		for(int y = totalImpar.length - 1; y >= 0; y--){
			System.out.println(totalImpar[y]);
		}
		
}
	
	public static void metodosSort(int[] vetor) {
			quickSort(vetor, 0, vetor.length - 1);
		}

		private static void quickSort(int[] vetor, int inicio, int fim) {
			if (inicio < fim) {
				int posicaoPivo = separar(vetor, inicio, fim);
				quickSort(vetor, inicio, posicaoPivo - 1);
				quickSort(vetor, posicaoPivo + 1, fim);
			}
		}

		private static int separar(int[] vetor, int inicio, int fim) {
			int pivo = vetor[inicio];
			int i = inicio + 1, f = fim;
			while (i <= f) {
				if (vetor[i] <= pivo)
					i++;
				else if (pivo < vetor[f])
					f--;
				else {
					int troca = vetor[i];
					vetor[i] = vetor[f];
					vetor[f] = troca;
					i++;
					f--;
				}
			}
			vetor[inicio] = vetor[f];
			vetor[f] = pivo;
			return f;
		}
}
