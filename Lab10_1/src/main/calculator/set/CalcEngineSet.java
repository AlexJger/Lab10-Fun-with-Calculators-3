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
								System.out.println(setResult);
								if(setResult!=null)setResult.clear();
								System.out.println(setResult);
								}
		}
	}
	
	public Set<String> union(){
		setResult.addAll(setA);
		String setBStr =removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
			setResult.add(input);	
		}
		scanner.close();
		return setResult;
	}
	
	public Set<String> intersection(){
		String setBStr=removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
			if(setA.contains(input)) setResult.add(input);
		}
		scanner.close();
		return setResult;
	}
	
	public Set<String> subtraction(){
		setResult.addAll(setA);
		String setBStr=removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
			if(setA.contains(input)) setResult.remove(input);
		}
		scanner.close();
		return setResult;
	}
	
	public void pushResultTo(String setName){
		if(setName.equals("setA")) setA.addAll(parseStringToSet(removeFirstAndLast(setResult.toString())));
		if(setName.equals("setB")) setB.addAll(parseStringToSet(removeFirstAndLast(setResult.toString())));
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
		String setStr=removeFirstAndLast(getSet(setName).toString());
		Scanner scanner = new Scanner(setStr).useDelimiter(", ");
		String[] sAr = new String[getSet(setName).size()];
		for(int i=0; scanner.hasNext(); i++) {
			String input = scanner.next();
			sAr[i]=input;
		}
		long powerSetSize = (long) Math.pow(2, getSet(setName).size());
		String temp = "";
		for(int j=0; j<powerSetSize; j++) {
			for(int k=0; k<getSet(setName).size(); k++) {
				if((j & (1 << k))>0) {
					if(temp.isEmpty()) temp+=sAr[k];
					else temp+=","+sAr[k];
				}
			}
			setResult.add("{"+temp+"}");
			temp="";
		}
	return setResult;
	}
	
	
	
}
