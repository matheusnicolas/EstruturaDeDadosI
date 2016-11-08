import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Marmores {

	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int quantM, tentativas, cont = 1;
		String entrada = s.nextLine();
		String[] caractere = entrada.split(" ");

		quantM = Integer.parseInt(caractere[0]);
		tentativas = Integer.parseInt(caractere[1]);
		while (quantM != 0 && tentativas != 0) {
			int[] marmores = new int[quantM];
			for (int x = 0; x < marmores.length; x++) {
				marmores[x] = Integer.parseInt(s.nextLine());
			}
			
			CountingSort(marmores, 10000);
			
			
			System.out.println("CASE# " + cont + ":");
			for (int i = 0; i < tentativas; i++) {

				int chave = Integer.parseInt(s.nextLine());
				int indice = Arrays.binarySearch(marmores, chave);
				for(int x = indice; x >= 0; x--){
					if(marmores[x] == chave){
						indice = x;
					}
				}
				
				if (indice < 0) {
					System.out.println(chave + " not found");
					

				} else {
					System.out.println(chave + " found at " + (indice+1));
				}
			}
			cont++;
			entrada = s.nextLine();
			caractere = entrada.split(" ");
			quantM = Integer.parseInt(caractere[0]);
			tentativas = Integer.parseInt(caractere[1]);
		}

	}
	
	

	public static void CountingSort(int[] a, int m){
        int n = a.length;
         
        int vetorAux[] = new int[m];
         
        
        for(int i = 0; i < m; i++){
            vetorAux[i] = 0;
        }
         
        for(int i = 0; i < n; i++){
            vetorAux[a[i]]++;
        }
        
        int sum = 0;                
        for(int i = 1; i < m; i++){
            int dum = vetorAux[i];
            vetorAux[i] = sum;
            sum += dum;
        }       
        int vetorOrdenado[] = new int[n];
        for(int i = 0; i < n; i++){
            vetorOrdenado[vetorAux[a[i]]] = a[i];
            vetorAux[a[i]]++;
        }
         
        for (int i = 0; i < n; i++){
            a[i] = vetorOrdenado[i];
        }
    }
}