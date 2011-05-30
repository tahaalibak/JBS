import java.util.*;
public class maze {

	//fields
	private int m;
	private int n;
	private LinkedList<LinkedList<Integer>> maze;
	
	
	//constructors
	public maze(int m, int n){
		this.m = m;
		this.n = n;
	}
	
	//methods
	public void load(String key){
		LinkedList<LinkedList<Integer>> maze = new LinkedList<LinkedList<Integer>>();
		int temp;
		int i = 0;
		for(int k=-1; i<key.length() && k<n; k++){
			LinkedList<Integer> row = new LinkedList<Integer>();
			for(int j=0; j<m; j++){
				if(key.charAt(i)=='0'){
					temp = 0;
				}
				else{
					temp = 1;
				}
				row.add(temp);
				i++;
			}
			maze.add(row);
		}
		this.maze = maze;
	}
	
	public int getM(){
		return this.m;
	}
	
	public int getN(){
		return this.n;
	}
	
	public LinkedList<Integer> getRow(int i){
		return this.maze.get(i-1);
	}
	
	public void display(){
		for(int i = 1; i<=n; i++){
			for(int j=0; j<this.getRow(i).size(); j++){
				System.out.print(this.getRow(i).get(j));
			}
			System.out.println();
		}
	}
	
	public boolean solve(int begX, int begY, int endX, int endY){
		LinkedList<Integer> neighbors = new LinkedList<Integer>();
		LinkedList<Integer> traversed = new LinkedList<Integer>();
		neighbors.add(begX);
		neighbors.add(begY);
		traversed.addAll(neighbors);
		int check = 0;
		boolean answer;
		while(check==0){
			if(neighbors.size()==0){
				check = 2;
			}
			else{
				LinkedList<Integer> temp = new LinkedList<Integer>();
				temp.addAll(neighbors);
				neighbors.clear();
				int x;
				int y;
				int z;
				for(int i = 0; i<temp.size();){
					if(temp.get(i)!=0 && this.maze.get(temp.get(i)-1).get(temp.get(i+1))==0){
						x = temp.get(i)-1;
						y = temp.get(i+1);
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					if(temp.get(i)+1<this.maze.size() && this.maze.get(temp.get(i)+1).get(temp.get(i+1))==0){
						x = temp.get(i)+1;
						y = temp.get(i+1);	
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					if(temp.get(i+1)!=0 && this.maze.get(temp.get(i)).get(temp.get(i+1)-1)==0){
						x = temp.get(i);
						y = temp.get(i+1)-1;
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					if(temp.get(i+1)<this.maze.get(0).size() && this.maze.get(temp.get(i)).get(temp.get(i+1)+1)==0){
						x = temp.get(i);
						y = temp.get(i+1)+1;
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					i = i+2;
				}
				for(int i = 0; i<neighbors.size();){
					if(neighbors.get(i)==endX && neighbors.get(i+1)==endY){
						check = 1;
					}
					i = i+2;
				}
				traversed.addAll(temp);
				temp.clear();
			}
		}
		if (check == 1){
			answer = true;
		}
		else{
			answer = false;
		}
		return answer;
	}
	
	public boolean trace(int begX, int begY, int endX, int endY){
		LinkedList<Integer> neighbors = new LinkedList<Integer>();
		LinkedList<Integer> traversed = new LinkedList<Integer>();
		LinkedList<LinkedList<Integer>> record = new LinkedList<LinkedList<Integer>>();
		neighbors.add(begX);
		neighbors.add(begY);
		traversed.addAll(neighbors);
		int check = 0;
		boolean answer;
		while(check==0){
			if(neighbors.size()==0){
				check = 2;
			}
			else{
				LinkedList<Integer> temp = new LinkedList<Integer>();
				temp.addAll(neighbors);
				neighbors.clear();
				int x;
				int y;
				int z;
				for(int i = 0; i<temp.size();){
					if(temp.get(i)!=0 && this.maze.get(temp.get(i)-1).get(temp.get(i+1))==0){
						x = temp.get(i)-1;
						y = temp.get(i+1);
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					if(temp.get(i)+1<this.maze.size() && this.maze.get(temp.get(i)+1).get(temp.get(i+1))==0){
						x = temp.get(i)+1;
						y = temp.get(i+1);	
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					if(temp.get(i+1)!=0 && this.maze.get(temp.get(i)).get(temp.get(i+1)-1)==0){
						x = temp.get(i);
						y = temp.get(i+1)-1;
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					if(temp.get(i+1)<this.maze.get(0).size() && this.maze.get(temp.get(i)).get(temp.get(i+1)+1)==0){
						x = temp.get(i);
						y = temp.get(i+1)+1;
						z = 0;
						for(int j = 0; j<traversed.size();){
							if(traversed.get(j)==x && traversed.get(j+1)==y){
								z++;
							}
							j = j+2;
						}
						if (z==0){
							neighbors.add(x);
							neighbors.add(y);
						}
					}
					i = i+2;
				}
				for(int i = 0; i<neighbors.size();){
					if(neighbors.get(i)==endX && neighbors.get(i+1)==endY){
						check = 1;
					}
					i = i+2;
				}
				traversed.addAll(temp);
				record.add(temp);
			}
		}
		if (check == 1){
			answer = true;
			LinkedList<Integer> path_temp = new LinkedList<Integer>();
			LinkedList<String> path = new LinkedList<String>();
			path_temp.add(endX);
			path_temp.add(endY);
			Collections.reverse(record);
			for(int i = 0; i<record.size(); i++){
				LinkedList<Integer> temp = new LinkedList<Integer>();
				LinkedList<Integer> temp_2 = new LinkedList<Integer>();
				temp.add(endX);
				temp.add(endY);
				int l = 0;
				temp_2.addAll(neighborFinder(temp));
				for(int j=0; j<record.get(i).size() && l!=1;){
					for(int k = 0; k<temp_2.size() && l!=1;){
						if(temp_2.get(k)==record.get(i).get(j) && temp_2.get(k+1)==record.get(i).get(j+1)){
							path_temp.add(temp_2.get(k));
							endX=temp_2.get(k);
							path_temp.add(temp_2.get(k+1));
							endY=temp_2.get(k+1);
							l=1;
						}
						k = k+2;
					}
					j = j+2;
				}
			}
			for(int i = 0; i<path_temp.size();){
				path.add("("+path_temp.get(i)+","+path_temp.get(i+1)+")");
				i++;
				i++;
			}
			Collections.reverse(path);
			System.out.println(path);	
		}
		else{
			answer = false;
			System.out.println("No Path Found.");
		}
		
		return answer;
	}
	
	public LinkedList<Integer> neighborFinder(LinkedList<Integer> neighbors){
		LinkedList<Integer> temp = new LinkedList<Integer>();
		temp.addAll(neighbors);
		neighbors.clear();
		int x;
		int y;
		for(int i = 0; i<temp.size();){
			if(temp.get(i)!=0 && this.maze.get(temp.get(i)-1).get(temp.get(i+1))==0){
				x = temp.get(i)-1;
				y = temp.get(i+1);
				neighbors.add(x);
				neighbors.add(y);
			}
			if(temp.get(i)+1<this.maze.size() && this.maze.get(temp.get(i)+1).get(temp.get(i+1))==0){
				x = temp.get(i)+1;
				y = temp.get(i+1);	
				neighbors.add(x);
				neighbors.add(y);
			}
			if(temp.get(i+1)!=0 && this.maze.get(temp.get(i)).get(temp.get(i+1)-1)==0){
				x = temp.get(i);
				y = temp.get(i+1)-1;
				neighbors.add(x);
				neighbors.add(y);
			}
			if(temp.get(i+1)<this.maze.get(0).size() && this.maze.get(temp.get(i)).get(temp.get(i+1)+1)==0){
				x = temp.get(i);
				y = temp.get(i+1)+1;
				neighbors.add(x);
				neighbors.add(y);
			}
			i = i+2;
		}
		return neighbors;
	}
	
	public void redesign(){
		Random generator = new Random();
		for(int i = 1; i<this.maze.size()-1; i++){
			for(int j= 1; j<this.maze.get(i).size()-1; j++){
				this.maze.get(i).remove(j);
				this.maze.get(i).add(j, 1);
			}
		}
		int begX=1;
		int begY=1;
		int endX=1;
		int endY=1;
		while (begX==endX && begY==endY){
			if (n-(generator.nextInt(n-2)+1)>(n/2)){
				begX=n-2;
			}
			else{
				begX=1;
			}
			if (m-(generator.nextInt(m-2)+1)>(m/2)){
				begY=m-2;
			}
			else{
				begY=1;
			}
			if (n-(generator.nextInt(n-2)+1)>(n/2)){
				endX=n-2;
			}
			else{
				endX=1;
			}
			if (m-(generator.nextInt(m-2)+1)>(m/2)){
				endY=m-2;
			}
			else{
				endY=1;
			}
		}
		LinkedList<Integer> old = new LinkedList<Integer>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		LinkedList<Integer> temp_2 = new LinkedList<Integer>();
		old.add(this.maze.size()-1);
		old.add(this.maze.get(0).size()-1);
		temp_2.add(begX);
		temp_2.add(begY);
		int attempt = 0;
		this.maze.get(begX).remove(begY);
		this.maze.get(begX).add(begY, 0);
		while(this.solve(begX,begY,endX,endY)!=true && attempt!= 5){
			LinkedList<LinkedList<Integer>> temp_3 = new LinkedList<LinkedList<Integer>>();
			temp_3.addAll(randomNeighborWallFinder(temp_2));
			if (temp_3.get(1).get(0)!=5){	
				temp.clear();
				temp.addAll(temp_3.get(0));
				int x=temp.get(0);
				int y=temp.get(1);
				old.addAll(temp);
				this.maze.get(x).remove(y);
				this.maze.get(x).add(y, 0);
				temp_2.clear();
				temp_2.addAll(temp);
			}
			else{
				attempt=5;
			}
		}
		if(attempt==5){
			attempt = 0;
			this.redesign();
		}
	}
	
	public LinkedList<LinkedList<Integer>> randomNeighborWallFinder(LinkedList<Integer> neighbors){
		LinkedList<Integer> temp = new LinkedList<Integer>();
		temp.addAll(neighbors);
		neighbors.clear();
		int x;
		int y;
		for(int i = 0; i<temp.size();){
			if(temp.get(i)>1 && this.maze.get(temp.get(i)-1).get(temp.get(i+1))==1){
				x = temp.get(i)-1;
				y = temp.get(i+1);
				neighbors.add(x);
				neighbors.add(y);
			}
			if(temp.get(i)+1<this.maze.size()-1 && this.maze.get(temp.get(i)+1).get(temp.get(i+1))==1){
				x = temp.get(i)+1;
				y = temp.get(i+1);	
				neighbors.add(x);
				neighbors.add(y);
			}
			if(temp.get(i+1)>1 && this.maze.get(temp.get(i)).get(temp.get(i+1)-1)==1){
				x = temp.get(i);
				y = temp.get(i+1)-1;
				neighbors.add(x);
				neighbors.add(y);
			}
			if(temp.get(i+1)+1<this.maze.get(0).size()-1 && this.maze.get(temp.get(i)).get(temp.get(i+1)+1)==1){
				x = temp.get(i);
				y = temp.get(i+1)+1;
				neighbors.add(x);
				neighbors.add(y);
			}
			i = i+2;
		}
		int X;
		int Y;
		int attempt = 0;
		int stopper = 0;
		Random generator = new Random();
		do{
			if(neighbors.size()>0){	
				int random = generator.nextInt(neighbors.size());
				if (random%2==0){
					X =neighbors.get(random);
					Y =neighbors.get(random+1);
				}
				else{
					Y =neighbors.get(random);
					X =neighbors.get(random-1);
				}
				temp.clear();
				temp.add(X);
				temp.add(Y);
				attempt++;
				if(this.maze.get(X).get(Y+1)==1 && this.maze.get(X).get(Y-1)==1){
					stopper=1;
				}
				if(this.maze.get(X+1).get(Y)==1 && this.maze.get(X-1).get(Y)==1){
					stopper=1;
				}
			}
			else{
				attempt=5;
			}
		}while(stopper!=1 && attempt<5);
		LinkedList<LinkedList<Integer>> returner = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> attempt_number = new LinkedList<Integer>();
		attempt_number.add(attempt);
		returner.add(temp);
		returner.add(attempt_number);
		return returner;
	}
		
	public static boolean overlapCheck(LinkedList<Integer> one, LinkedList<Integer> two){
		int checkDigit = 0;
		boolean check;
			for (int i = 0; i<one.size();){
				for (int j = 0; j<two.size();){
					if (one.get(i)==two.get(j) && one.get(i+1)==two.get(j+1)){
						checkDigit = 1;
					}
					j++;
					j++;
				}
				i++;
				i++;
			}
		if (checkDigit == 1){
			check = true;
		}
		else{
			check = false;
		}
		return check;
	}
}
