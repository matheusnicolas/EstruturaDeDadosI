import java.util.Scanner;
import java.io.IOException;
public class ordenaçãoPorTamanho {

	private static final Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		
		int quant = Integer.parseInt(s.nextLine());
		
		for(int x = 0; x < quant; x++){
			
			String entrada = s.nextLine();
			String[] arrayCaractere = entrada.split(" ");
			BubbleSort(arrayCaractere);
			String vazio = "";
			for(int i = 0; i < arrayCaractere.length; i++){
				vazio += arrayCaractere[i] + " ";
			}
			
			System.out.println(vazio.substring(0, vazio.length() - 1));
		}
		
	}
	
	private static void BubbleSort(String[] vetor) {
		
		boolean testar = true;
		while(testar){
			testar = false;
			
			for(int i = 0; i < vetor.length - 1; i++){
				if(vetor[i].length() < vetor[i + 1].length()){
					String aux = vetor[i];
					vetor[i] = vetor[i+1];
					vetor[i+1] = aux;
					testar = true;
				}
			}
		}
		
		
	}
}
