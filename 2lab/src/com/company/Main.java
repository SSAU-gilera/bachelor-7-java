package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        doTask();
    }

    static void doTask (){
        int punktMenu = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину вектора: ");
        int length = in.nextInt();
        MyVector vector1 = new MyVector(length);
        MyVector vector2 = new MyVector(length);
        MyVector vector3 = new MyVector(length);
        vector1.newVector();
        System.out.println("---------------------------------------");
        System.out.println("1.Просмотр элемента");
        System.out.println("2.Изменение элемента");
        System.out.println("3.Длина вектора");
        System.out.println("4.Поиск min и max элемента");
        System.out.println("5.Сортировка вектора по возрастанию");
        System.out.println("6.Евклидовая норма");
        System.out.println("7.Умножение вектора на число");
        System.out.println("8.Сложение векторов");
        System.out.println("9.Скалярное произведение");
        System.out.println("0.Выход");
        System.out.println("---------------------------------------");
        do{
            System.out.println("\n-------------------------");
            System.out.print("Выберите пункт меню: ");
            punktMenu = in.nextInt();;
            switch (punktMenu){
                case (1):
                    System.out.print("Какой элемент вы хотите посмотреть? ");
                    int i = in.nextInt();
                    double gElem = vector1.getElem(i);
                    System.out.println(i + " элемент - " + gElem);
                    System.out.println("-------------------------");
                    break;
                case (2):
                    System.out.print("Какой элемент вы хотите изменить? ");
                    i = in.nextInt();
                    System.out.print("Введите новый элемент: ");
                    double sElem = in.nextDouble();
                    vector1.setElem(i,sElem);
                    System.out.println(i + " элемент - " + sElem);
                    System.out.println("-------------------------");
                    break;
                case (3):
                    int l = vector1.getLength();
                    System.out.println("Длина вектора - " + l);
                    System.out.println("-------------------------");
                    break;
                case (4):
                    double max = vector1.getMaxElem();
                    double min = vector1.getMinElem();
                    System.out.println("Максимальный элемент - " + max);
                    System.out.println("Минимальный элемент - " + min);
                    System.out.println("-------------------------");
                    break;
                case (5):
                    System.out.print("Исходный вектор:\n");
                    vector1.writeVector(vector1);
                    vector1.sortVector();
                    System.out.println("-------------------------");
                    break;
                case (6):
                    double norma = vector1.normVector();
                    System.out.println("Евклидова норма вектора: " + norma);
                    System.out.println("-------------------------");
                    break;
                case (7):
                    System.out.print("На какое число хотите умножить? ");
                    int num = in.nextInt();
                    vector1.multVector(num);
                    System.out.println("-------------------------");
                    break;
                case (8):
                    System.out.print("Какой вектор хотите прибавить?\n");
                    vector2.newVector();
                    System.out.print("Исходный вектор:\n");
                    vector1.writeVector(vector1);
                    System.out.print("Итоговый вектор:\n");
                    vector3 = MyVector.sumVector(vector1,vector2);
                    vector3.writeVector(vector3);
                    System.out.println("-------------------------");
                    break;
                case (9):
                    System.out.print("Введите новый вектор\n");
                    vector2.newVector();
                    double scalar = MyVector.scalarVector(vector1,vector2);
                    System.out.println("Скалярное произведение: " + scalar);
                    System.out.println("-------------------------");
                    break;
            }
        }
        while (punktMenu != 0);
    }
}

