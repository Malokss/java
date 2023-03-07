package hello;

import animals.Animal;
import mirko.Mirko;

public class HelloWorld {
	public static void main(String[] args)  {
		//lokalne varijable a i mirkec se ne koriste
		Animal a = new Animal();
		Mirko mirkec = new Mirko();
		System.out.println("Now accessing HelloWorld");
	}
}