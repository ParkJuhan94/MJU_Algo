import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//BOJ제로(스택)
public class boj_10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		
		
		for(int i=0; i<K; i++) {
				int num = Integer.parseInt(in.readLine());
				
				//0일 경우, 가장 최근 수를 지운다. = pop
				if(num == 0) { 
					stack.pop();
				}
				//0이 아닐 경우, 가장 최근 수를 지운다. = push
				else {
					stack.push(num);
				}			
		}
		
		int sum = 0;
		while(!stack.empty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	
	}

}
