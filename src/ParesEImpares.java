import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ParesEImpares {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);int valor=input.nextInt();
		ArrayList<Integer>impares= new ArrayList<Integer>();
		ArrayList<Integer>pares= new ArrayList<Integer>();
		for(int k=0;k<valor;k++){
			int numero=input.nextInt();
			if((numero%2)!=0){
				impares.add(numero);
			}
			else{
				pares.add(numero);
			}
		}
		Collections.sort(pares);
		for(int i: pares){
			System.out.println(i);
		}
		Collections.sort(impares);
		for(int k=impares.size()-1;k>=0;k--){
			System.out.println(impares.get(k));
		}


	}

}
