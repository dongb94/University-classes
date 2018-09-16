import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PermutationGraphs {
	
	static int relation[] = new int[100000];
	
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("Permutation_input2.txt"))));
		Scanner in = new Scanner(new FileInputStream("Permutation_input2.txt"));
		in.next();
		int T = in.nextInt();
		
		for(int noc =0 ; noc < T; noc++){
			int n = in.nextInt();
			int buffer[] = new int[n];
			for(int i = 0; i< n; i++){
				buffer[in.nextInt()-1] = i;
			}
			for(int i = 0; i< n; i++){
				relation[i] = buffer[in.nextInt()-1];
			}
			System.out.println(divide(0,n));
		}
	}
	
	static int divide(int min, int max){
		if(max==min){
			return 0;
		}else{
			int edge = 0;
			edge += divide(min,(max+min)/2)+divide(((min+max)/2)+1,max);
			int lp = min;
			int rp = ((max+min)/2)+1;
			int[] temp = new int[max-min+1];
			int index=0;
			while(rp <= max){
				if(relation[lp] > relation[rp]){
					temp[index++] = relation[rp++];
					edge += ((max+min)/2)-lp+1;
				}else{
					temp[index++] = relation[lp++];
					if(lp > (max+min)/2){
						break;
					}
				}
			}
			for(int i=0; i<temp.length; i++){
				relation[i+min]=temp[i];
			}
			return edge;
		}
	}
}

