package main.calculator.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import main.calculator.decimal.CalcEngine;



public class CalcEngineSet extends CalcEngine {
	
	Set<String> setA = new HashSet<String>();
	Set<String> setB = new HashSet<String>();
	Set<String> setResult = new HashSet<String>();
	
	public CalcEngineSet() {
		super();
	}
	
	public Set<String> parseStringToSet(String input){
		Set<String> out = new HashSet<String>();
		Scanner scanner = new Scanner(input).useDelimiter(",");
		while (scanner.hasNext()) {
			String in = scanner.next();
			out.add(in);
		}
		scanner.close();
		return out;
	}
	
	public void setSet(String input, String setName) throws IllegalArgumentException{
		Set<String> out = new HashSet<String>();
		Scanner scanner = new Scanner(input).useDelimiter(",");
		while (scanner.hasNext()) {
			String in = scanner.next();
			out.add(in);
		}
		if(setName.equals("setA")) setA.addAll(out); 
		switch(setName) {
			case "setA" 	-> setA.addAll(out);
			case "setB" 	-> setB.addAll(out);
			case "setResult"-> setResult.addAll(out);
		}
		scanner.close();
	}
	
	public int sizeOfSet(String setName) {
		switch(setName) {
		 	case "setA" 	-> {return setA.size();}
		 	case "setB" 	-> {return setB.size();}
		 	case "setResult"-> {return setResult.size();}
		} return 0;
	}
	
	public void clear(String setName) {
		switch (setName) {
			case "setA" 	-> {if(setA!=null)setA.clear();}
			case "setB" 	-> {if(setB!=null)setB.clear();}
			case "setResult"-> {if(setResult!=null)setResult.clear();}
			case "all"		-> {if(setA!=null)setA.clear();
								if(setB!=null)setB.clear();
								if(setResult!=null)setResult.clear();
								}
		}
	}
	
	public Set<String> union(){
		setResult.addAll(setA);
		setResult.addAll(setB);
		return setResult;
	}
	
	public Set<String> intersection(){
		for (String elem : setB) {
			if(setA.contains(elem)) setResult.add(elem);
		}
		return setResult;
	}
	
	public Set<String> subtraction(){
		setResult.addAll(setA);
		setResult.removeAll(setB);
		return setResult;
	}
	
	public void pushResultTo(String setName){
		if(setName.equals("setA")) {clear("setA"); setA.addAll(setResult); parseStringToSet(removeFirstAndLast(setA.toString()));}
		if(setName.equals("setB")) {clear("setB"); setB.addAll(setResult); parseStringToSet(removeFirstAndLast(setA.toString()));}
	}

	public Set<String> getSet(String setName){
		Set<String> out = new HashSet<String>();
		switch(setName) {
			case "setA" 	-> out=setA;
			case "setB" 	-> out=setB;
			case "setResult"-> out=setResult;
		}
		return out;
	}

	public String removeSpacebars(String in) {
		return in.replaceAll(" ", "");
	}
	
	public String removeFirstAndLast(String in) {
		if(in.charAt(0)=='[' && in.charAt(in.length()-1)==']')
		return (String) in.subSequence(1, in.length()-1);
		else return in;
	}

	public Set<String> powerSet(String setName){
		String[] sAr = new String[getSet(setName).size()];
		int i=0;
		for(String elem : getSet(setName)) {
			sAr[i]=elem;
			i++;
		}
		int size = sAr.length;	//size of set
		int powerSize = (int) Math.pow(2, size); // 2^size = number of pow elements
		
		for(int j=0; j<powerSize; j++) {
			String bin= Integer.toBinaryString(j); //convert to binary
			while(bin.length() < size) bin = "0" + bin; //adds 0 to bin to match the format
			Set<String> tempSet = new HashSet<String>(); //new Temp set
			for(int k= 0;k< size;k++){
				if(bin.charAt(k) == '1')tempSet.add(sAr[k]); //for every 1 -> add element
			}
			setResult.add(tempSet.toString());
		}
		return setResult;
	}

	
}
