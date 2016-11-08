import java.io.IOException;
import java.util.Scanner;
public class jogoMatematico {
 
    public static void main(String[] args) throws IOException {
 		
 		int N, x, y, total;
        Scanner s = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		N = s.nextInt();
		
		for(int i = 0; i < N; i++){
			
			String entrada = s2.next();
			
			String[] pegaCaractere = entrada.split("");
			x = Integer.parseInt(pegaCaractere[1]);
			String letra = pegaCaractere[2];
			y = Integer.parseInt(pegaCaractere[3]);
			
			
			if(x == y){
				total = x * y;

			}else if(letra.equals(letra.toUpperCase())){
				total = y - x;

			}else{
				total = y + x;
			}
			System.out.println(total);
		}

		s.close();
		s2.close();
	}
		
}