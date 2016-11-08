import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
public class josephus {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		List<Integer> pessoas = new LinkedList<Integer>();
		int quantRepetica = Integer.parseInt(input.nextLine());
		
		for(int i = 0; i < quantRepetica; i++){
			String entrada = input.nextLine();
			int p = entrada.indexOf(" ");
			int quantidadePessoas = Integer.parseInt(entrada.substring(0, p));
			int salto = Integer.parseInt(entrada.substring(p+1));
			preencherLista(pessoas, quantidadePessoas);
			int contador = 0;
			while(pessoas.size() > 1){
				for(int k = 0; k < pessoas.size(); k++){
					if(contador == salto){
						pessoas.remove(k);
						contador = 0;
					}else{
						contador++;
					}
				}
			}System.out.println(pessoas.get(0));
			
		}
		
		
		
	}
	private static void preencherLista(List<Integer> listaPessoas, int quantPessoas){
		for(int i = 0; i < quantPessoas; i++){
			listaPessoas.add(i+1);
		}
	}
}
