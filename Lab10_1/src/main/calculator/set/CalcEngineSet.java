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
	
	private Set<String> parseStringToSet(String input){
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
		// no idea what this is supposed to be doing
	}
	
	public int sizeOfSet(String setName) {
		if(setName.equals("setA")) return setA.size();
		else return setB.size();
	}
	
	public void clear() {
		setA.clear();
		setB.clear();
		setResult.clear();
	}
	
	public Set<String> union(){
		Set<String> out = new HashSet<String>(setA);
		String setBStr =removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
			out.add(input);	
		}
		scanner.close();
		return out;
	}
	
	public Set<String> intersection(){
		Set<String> out = new HashSet<String>();
		String setBStr=removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
			if(setA.contains(input)) out.add(input);
		}
		scanner.close();
		return out;
	}
	
	public Set<String> subtraction(){
		HashSet out = new HashSet(setA);
		String setBStr=removeFirstAndLast(setB.toString());
		Scanner scanner = new Scanner(setBStr).useDelimiter(", ");
		while (scanner.hasNext()) {
			String input = scanner.next();
			if(setA.contains(input)) out.remove(input);
		}
		scanner.close();
		return out;
	}
	
	public String removeFirstAndLast(String in) {
		if(in.charAt(0)=='{' && in.charAt(in.length()-1)=='}' || in.charAt(0)=='[' && in.charAt(in.length()-1)==']')
		return (String) in.subSequence(1, in.length()-1);
		else return in;
	}
	
	public void pushResultTo(String setName){
		if(setName.equals("setA")) setA=setResult;
		else setB=setResult;
	}
	
	
//	public static void main(String[] args) {
//
//		new CalcEngineSet().run();
//	}
//	
//	
//	
//	public void run() {
//		String inA="A,{E},B,C";
//		String inB="B,C,{},F";
//		setA=parseStringToSet(inA);
//		setB=parseStringToSet(inB);
//		System.out.println("SetA= "+setA);
//		System.out.println("SetB= "+setB);
//		setResult=union();
//		System.out.println("Result union= "+setResult);
//		setResult=intersection();
//		System.out.println("Result intersection= "+setResult);
//		setResult=subtraction();
//		System.out.println("Result subtraction= "+setResult);
//		pushResultTo("setA");
//		System.out.println("SetA after push= "+setA);
//	}
}
