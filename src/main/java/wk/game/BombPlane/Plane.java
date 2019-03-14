package wk.game.BombPlane;

import java.util.ArrayList;

public class Plane {
	int head;
	ArrayList<Integer> body = new ArrayList<Integer>();
	boolean isAlive;
	boolean hasShowAll; 
	
	Plane() {
		isAlive = true;
		hasShowAll= false; 
		int b[]={0,1,10,11,8,9,18,19,80,81,90,91,88,89,98,99};
		ArrayList<Integer> no_head = new ArrayList<Integer>();
		for(int i=0;i!=16;i++)
			no_head.add(new Integer(b[i]));
		do{
			head=rand(100);
		}
		while(no_head.contains(new Integer(head)));
		char direction;
		if(head/10<2) {
			direction='n';
		} else{
			if((head/10==8)||(head/10==9)) {
				direction='s';
			} else{
				if((head%10==0)||(head%10==1)) {
					direction='w';
				} else{
					if((head%10==8)||(head%10==9)) {
						direction='e';
					} else {
						direction='a';
					}
				}
			}
		}
		make_body(direction);
	}
	
	void make_body(char direction) {
		int[] north = {head+8,head+9,head+10,head+11,head+12,head+20,head+29,head+30,head+31};
		int[] south = {head-8,head-9,head-10,head-11,head-12,head-20,head-29,head-30,head-31};
		int[] west = {head+1,head-9,head-19,head+11,head+21,head+2,head+3,head-7,head+13};
		int[] east = {head-1,head-11,head-21,head+9,head+19,head-2,head-3,head-13,head+7};
		switch (direction){
		case 'n':	fillBody(north);break;
		case 's':	fillBody(south);break;
		case 'w':	fillBody(west);break;
		case 'e':	fillBody(east);break;
		case 'a': { 
			int dirNumber;
			char[] dir;
			if (head >= 23 && head <= 26) {
				dirNumber = 3;
				dir = new char[dirNumber];
				dir[0] = 'n';
				dir[1] ='e';
				dir[2] = 'w';
				//dir = new char[dirNumber];
				//dir[] = {'n','e','w'};
			} else if (head >= 73 && head <= 76) {
				dirNumber = 3;
				dir = new char[dirNumber];
				dir[0] = 'e';
				dir[1] = 's';
				dir[2] = 'w';
				//dir = {'e','s','w'};
			} else if (head % 10 == 2 && head/10<=6 && head/10>=3) {
				dirNumber = 3;
				dir = new char[dirNumber];
				dir[0] = 'n';
				dir[1] = 's';
				dir[2] = 'w';
				//dir = {'n','s','w'};
			} else if(head % 10 == 7 && head/10<=6 && head/10>=3) {
				dirNumber = 3;
				dir = new char[dirNumber];
				dir[0] = 'n';
				dir[1] = 'e';
				dir[2] = 's';
				//dir = {'n','e','s'};
			} else if (head == 22){
				dirNumber = 2;
				dir = new char[dirNumber];
				dir[0] = 'n';
				dir[1] = 'w';
				//dir = {'n','w'};
			} else if (head == 27){
				dirNumber = 2;
				dir = new char[dirNumber];
				dir[0] = 'n';
				dir[1] = 'e';
				//dir = {'n','e'};
			} else if (head == 72){
				dirNumber = 2;
				dir = new char[dirNumber];
				dir[0] = 's';
				dir[1] = 'w';
				//dir = {'s','w'};
			} else if (head == 77){
				dirNumber = 2;
				dir = new char[dirNumber];
				dir[0] = 'e';
				dir[1] = 's';
				//dir = {'e','s'};
			} else {
				dirNumber = 4;
				dir = new char[dirNumber];
				dir[0] = 'n';
				dir[1] = 'e';
				dir[2] = 's';
				dir[3] = 'w';
				//dir = {'n','e','s','w'};
			} 
			int c=rand(dir.length);
			switch (dir[c]){
			case 'n':	fillBody(north);break;
			case 's':	fillBody(south);break;
			case 'w':	fillBody(west);break;
			case 'e':	fillBody(east);break;
			}
		}
		}	//switch	
	}
	
	 void fillBody(int[] a) {
		 for(int i=0;i!=a.length;i++) {
			 body.add(new Integer(a[i]));
		 }
	 }
	 
	//�����������{}
	int rand(int n) {
		int a = (int)(Math.random() * n);
		return a;		
	}

}
