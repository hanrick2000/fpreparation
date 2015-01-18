package Testing;

public class SwapTwoCharactersInPlace {
public static void main(String[] args) {
	char a = 'h';
	char b = 'n';
	System.out.println("After seapping the two characters");
	swap(a,b);
	String s= "hello";
	char[] c = s.toCharArray();
	for(int start=0,end=s.length()-1;start<end;start++,end--){
		c[start] = (char) (c[start]^c[end]);
		c[end] = (char) (c[start]^c[end]);
		c[start] = (char) (c[start]^c[end]);
	}
	for(char element:c)
		System.out.print(element);
}

private static void swap(char a, char b) {
	a = (char) (a^b);
	b = (char) (a^b);
	a = (char) (a^b);
	System.out.println(a);
	System.out.println(b);
}
}
