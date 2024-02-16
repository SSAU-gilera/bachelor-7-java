package FirstPackage;

public class SecondClass{
private int a;
private int b;

public SecondClass(){
a = 3;
b = 4;
}

public int getA(){
return a;
}

public void setA(int val){
a = val;
}

public int getB(){
return b;
}

public void setB(int val){
b = val;
}
	
public int sum(){
return a+b;
}

}