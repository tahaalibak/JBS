public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		maze example = new maze(9,9);
		example.load("111111111100010001111010101100010101101110101100000101111011101100000101111111111");
		example.display();
		System.out.println(example.solve(1,1,7,6));
		System.out.println(example.solve(1,1,6,7));
		example.trace(1,1,7,6);
		example.trace(1,1,6,7);
		
		
		example.redesign();
		example.display();
		
		System.out.println();
		example.redesign();
		example.display();
		
		System.out.println();
		example.redesign();
		example.display();
		
		System.out.println();
		example.redesign();
		example.display();
		
		System.out.println();
		example.redesign();
		example.display();
		
	}

}
