package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17298_자료구조 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> trash = new Stack<>();
		Stack<Integer> res = new Stack<>();
		for(int i=0;i<N;i++) 
			stack.push(Integer.parseInt(st.nextToken()));
		
		outer:for(int i=0;i<N;i++) {
			if(!trash.isEmpty()) {
				if(stack.peek()<trash.peek()) {
					res.push(trash.peek());
					trash.push(stack.pop());
				}
				else {
					while(!trash.isEmpty()) {
						if(stack.peek()>=trash.peek())
							trash.pop();
						else {
							res.push(trash.peek());
							trash.push(stack.pop());
							continue outer;
						}
					}
					res.push(-1);
					trash.push(stack.pop());
				}
			}
			else {
				res.push(-1);
				trash.push(stack.pop());
			}
		}
		while(!res.isEmpty())
			sb.append(res.pop()).append(" ");
		System.out.println(sb);
	}

}
