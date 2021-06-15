import java.util.HashSet;
import java.util.Scanner;

public class restartOne {
	public static void main(String[] args) {
		String inA="{A, {E}, B, C}";
		String inB="{B, C, {}}";
		//System.out.println(removeFirstAndLast(inA));
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		setA=addInput(inA);
		setB=addInput(inB);
		System.out.println("setA= "+setA);
		System.out.println("setB= "+setB);
		//System.out.println("setA= "+removeFirstAndLast(setA.toString()));
		//if(inA.charAt(0)=='{')System.out.println("true");
		String x = addSet(setA.toString(), setB.toString()).toString();
		System.out.println("HashsetAdd: "+ x);
		x=addBrackets(x);
		System.out.println("HashsetAdd: "+ x);
		//System.out.println(contains(setA, "B"));
		System.out.println("Subtraction: "+ subtractSet(setA, setB));
		System.out.println("Intersection: "+ intersectSet(setA, setB));
		System.out.println("Power Set: "+ powerSet(setB));
		System.out.println("Power Set2: "+ powerSet2(setB,setB.size()));

	}
	
	
	public static HashSet addSet(String setA, String setB) {
		HashSet out = new HashSet();
		setA=removeFirstAndLast(setA);
		Scanner scanner = new Scanner(setA).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
				//System.out.println(input);
			out.add(input);
				//System.out.println("Set is: "+out);
			String test = out.toString();
				//System.out.println("Set is: "+test);	
		}
		setB=removeFirstAndLast(setB);
		Scanner scanner2 = new Scanner(setB).useDelimiter(", ");
		while (scanner2.hasNext()) {
			String input2 = scanner2.next();
				//System.out.println(input);
			out.add(input2);
				//System.out.println("Set is: "+out);
			String test2 = out.toString();
				//System.out.println("Set is: "+test);	
		}
		return out;
	}
	
	public static String removeFirstAndLast(String in) {
		if(in.charAt(0)=='{' && in.charAt(in.length()-1)=='}' || in.charAt(0)=='[' && in.charAt(in.length()-1)==']')
		return (String) in.subSequence(1, in.length()-1);
		else return in;
	}
	
	public static HashSet addInput(String in) {
		HashSet out = new HashSet();
		in=removeFirstAndLast(in);
		Scanner scanner = new Scanner(in).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
				//System.out.println(input);
			out.add(input);
				//System.out.println("Set is: "+out);
			String test = out.toString();
				//System.out.println("Set is: "+test);	
		}
		return out;
	}
	
	public static String addBrackets(String in) {
		String out="{";
		out+=removeFirstAndLast(in)+"}";
		return out;
	}
	
//	public static boolean contains(HashSet set, String in) {
//		if(set.contains(in))return true;
//		return false;
//	}
	
	public static HashSet subtractSet(HashSet setA, HashSet setB) {
		HashSet out = new HashSet(setA);
		//out.add((setA.toString()));
		//System.out.println("Out: "+out);
		//out=removeFirstAndLast(out.toString());
		String setBStr=removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
				//System.out.println(input);
			if(setA.contains(input)) out.remove(input);
			
				//System.out.println("Set is: "+out);
			String test = out.toString();
				//System.out.println("Set is: "+test);	
		}
		//System.out.println(setA);
		return out;
	}
	
	public static HashSet intersectSet(HashSet setA, HashSet setB) {
		HashSet out = new HashSet();
		String setBStr=removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
//				System.out.println(input);
//				System.out.println(setA);
			if(setA.contains(input)) out.add(input);
			
				//System.out.println("Set is: "+out);
			//String test = out.toString();
				//System.out.println("Set is: "+test);	
		}
		return out;
	}
	
	public static HashSet powerSet(HashSet setA) {
		HashSet out = new HashSet();
		out.add("{}");
		String in=removeFirstAndLast(setA.toString());
		Scanner scanner = new Scanner(in).useDelimiter(", ");
		//Scanner scanner2=scanner;
		while (scanner.hasNext()) {
			String input = scanner.next();
				//System.out.println(input);
			out.add("{"+input+"}");
			Scanner scanner2=new Scanner(in).useDelimiter(", ");
			while (scanner2.hasNext()) {
				String input2 = scanner2.next();
				out.add("{"+input+", "+input2+"}");
			}
				//System.out.println("Set is: "+out);
			String test = out.toString();
				//System.out.println("Set is: "+test);	
		}
		return out;
	}
	
	public static HashSet powerSet2(HashSet setA, int size) {
		HashSet out = new HashSet();
		
		long setSize=(long)Math.pow(2, size);
		String in = removeFirstAndLast(setA.toString());
		System.out.println("In: "+in);
		String str="";
		String[] input = null;
		int counter=0;
		Scanner scanner = new Scanner(in).useDelimiter(", ");
		while (scanner.hasNext()) {
			counter++;
			
			input[counter] = scanner.next();
		}
		for(int i = 0; i<setSize;i++) {
			for(int j = 0; j<size;j++) {
				if((i & (1<<j))>0) {
					str+=input[j];
				}
				
			}
			out.add("{"+str+"}");
			str="";
		}
		
		return out;
	}
}
