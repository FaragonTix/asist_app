package assistapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class manager {
	int i;
	public static ArrayList<Person> persons = reader.GetFromXml();
	public static ArrayList<Person> exp = persons;
	public static int pages=(int)Math.ceil(exp.size()/5);
	public static int currpage=0;
	public static int currobj=manager.UniqID();
	
	public static void Refetch() {
		manager.persons = reader.GetFromXml();
		manager.exp = persons;
		int b = exp.size();
		double c = (double) b/5;
		pages=(int)Math.ceil(c);
		System.out.println("pages: "+ Integer.toString(pages));
		currpage=1;
	}
	
	public static boolean IsInData(int i) {
		boolean result=false;
		
		for (Person person : manager.persons) {
			if (person.id==i) {result=true;}
		}
		return result;
	}
	
	public static int UniqID() {
		int i=mainq.getRandomNumber(0,1000000000);
		boolean s=manager.IsInData(i);
		while (s==true) {
			i=mainq.getRandomNumber(0,1000000000);
			s=manager.IsInData(i);
		}
		return i;
		}
	
	public static void SearchF(String s) {
		ArrayList<Person> searched= new ArrayList<Person>();
		for (Person person : persons) {
			if (person.GetWhole().contains(s.toLowerCase()))
			{
				searched.add(person);
			}
			exp=searched;
			int b = exp.size();
			double c = (double) b/5;
			pages=(int)Math.ceil(c);
			currpage=1;}}
	
public static<T> ArrayList<T> reverseList(ArrayList<T> list)
{
return list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), lst -> {Collections.reverse(lst);
return lst.stream();})).collect(Collectors.toCollection(ArrayList::new));}
}
	


