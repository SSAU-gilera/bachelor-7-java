package com.company;
import java.util.Scanner;

public class MyVector {
    Scanner in = new Scanner(System.in);
    private int n;
    private double[] vec;
    public MyVector(int n){
        this.n =n;
        this.vec = new double[n];
    }
    public void newVector (){
        for (int i = 0; i < n; i++) {
            int a=i+1;
            System.out.print("Введите " + a + " элемент: ");
            vec[i] = in.nextDouble();
        }
    }

    public void writeVector(MyVector vector){
        for (int i=1;i<=n;i++)
        {
            System.out.println(vector.getElem(i));
        }
    }
    public double getElem(int i){
        return vec[i-1];
    }
    public void setElem(int i, double elem){
        this.vec[i-1]= elem;
    }
    public int getLength(){
        return vec.length;
    }
    public double getMaxElem(){
        double max = vec[0];
        for (int i=1;i<n;i++){
            if (max<vec[i]) max=vec[i];
        }
        return max;
    }
    public double getMinElem(){
        double min = vec[0];
        for (int i=1;i<n;i++){
            if (min>vec[i]) min=vec[i];
        }
        return min;
    }
    private void swap(double[] array, int i1, int i2) {
        double tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
    public void sortVector(){
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i]=vec[i];
        }
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < n; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i-1);
                    needIteration = true;
                }
            }
        }
        System.out.print("Отсортированный вектор:\n");
        for (int i=0;i<n;i++)
        {
            System.out.println(array[i]);
        }
    }
    public double normVector(){
        double norma=0;
        for (int i=0;i<n;i++){
           norma+=vec[i]*vec[i];
        }
        norma = Math.sqrt(norma);
        return norma;
    }
    public void multVector(int num){
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i]=vec[i]*num;
        }
        System.out.print("Умножение вектора на " +num + ":\n");
        for (int i=0;i<n;i++)
        {
            System.out.println(array[i]);
        }
    }
    public static MyVector sumVector(MyVector vector1, MyVector vector2){
        MyVector vector = new MyVector(vector1.getLength());
        for (int i=1;i<=vector.getLength();i++)
        {
            vector.setElem(i,vector1.getElem(i)+vector2.getElem(i));
        }
        return vector;
    }
    public static double scalarVector (MyVector vector1, MyVector vector2){
        double scalar=0;
        for (int i=1;i<=vector1.getLength();i++)
        {
            scalar+=vector1.getElem(i)+vector2.getElem(i);
        }
        return scalar;
    }
}
