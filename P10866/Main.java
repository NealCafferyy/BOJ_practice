package baekjoon;
import java.io.*;
import java.util.*;

public class Main {
	public class Deque {

		dequeNode front = null;
		dequeNode back = null;
		
		
		public void push_front(int num) {
			dequeNode node = new dequeNode();
			node.data = num;
			if(this.isEmpty() == 1) {
				this.front = node;
				this.back = node;
			}
			else {
				this.front.llink = node;
				node.rlink = front;
				front = node;
			}
		}
		
		public void push_back(int num) {
			dequeNode node = new dequeNode();
			node.data = num;
			if(this.isEmpty() == 1) {
				this.front = node;
				this.back = node;
			}
			else {
				this.back.rlink = node;
				node.llink = back;
				back = node;
			}
		}
		
		public int pop_front() {
			int returnData;
			if(this.isEmpty() == 1) {
				return -1;
			}
			else {
				returnData = this.front.data;
				this.front = this.front.rlink;
				if( this.front != null) {
					this.front.llink.rlink = null;
					this.front.llink = null;
				}
				return returnData;
			}
		}
		
		public int pop_back() {
			int returnData;
			if(this.isEmpty() == 1) return -1;
			else {
				returnData = this.back.data;
				this.back = this.back.llink;
				if( this.back != null) {
					this.back.rlink.llink = null;
					this.back.rlink = null;
				}
				return returnData;
			}
		}
		
		public int size() {
			int count = 0;
			dequeNode iter;
			
			if(this.isEmpty() == 1) {
				return 0;
			}
			else {
				for(iter=this.front; iter!=null; iter=iter.rlink) {
					count++;
				}
			}
			
			return count;
		}
		
		public int isEmpty() {
			if(this.front == null || this.back == null)
				return 1;
			else return 0;
		}
		
		public int front() {
			if(this.isEmpty() == 1) {
				return -1;
			}
			else {
				return this.front.data;
			}
		}
		
		public int back() {
			if(this.isEmpty() == 1) {
				return -1;
			}
			else {
				return this.back.data;
			}
		}
		
	}
	
	public class dequeNode {

		public int data;
		public dequeNode rlink;
		public dequeNode llink;
		
		dequeNode() {
			this.data = 0;
			this.rlink = null;
			this.llink = null;
		}
	}

	
	public static void main(String args[]) {
		Main dequeMain = new Main();
		Main.Deque dQ = dequeMain.new Deque();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLine;
		String cmdLine;
		int cmdNumber;
		
		try {
			firstLine = br.readLine();
			cmdNumber = Integer.parseInt(firstLine);
			for(int i=0; i<cmdNumber; i++) {
				cmdLine = br.readLine();
				StringTokenizer cmd = new StringTokenizer(cmdLine," ");
				while(cmd.hasMoreTokens()) {
					switch(cmd.nextToken()) {
					case "push_front" :
						dQ.push_front(Integer.parseInt(cmd.nextToken()));
						break;
					case "push_back" :
						dQ.push_back(Integer.parseInt(cmd.nextToken()));
						break;
					case "pop_front" :
						System.out.println(dQ.pop_front());
						break;
					case "pop_back" :
						System.out.println(dQ.pop_back());
						break;
					case "front" :
						System.out.println(dQ.front());
						break;
					case "back" :
						System.out.println(dQ.back());
						break;
					case "size" :
						System.out.println(dQ.size());
						break;
					case "empty" :
						System.out.println(dQ.isEmpty());
						break;
					}
				}
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

