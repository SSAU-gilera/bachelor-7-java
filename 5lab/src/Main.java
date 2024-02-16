import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        doTask();
    }

    static void doTask() {
        int punktMenu = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("\n---------------------------------------");
        System.out.println("1.Задание 1");
        System.out.println("2.Задание 2");
        System.out.println("3.Задание 3");
        System.out.println("0.Выход");
        System.out.println("---------------------------------------");
        System.out.println("\n-------------------------");
        System.out.print("Выберите пункт меню: ");
        punktMenu = in.nextInt();
        if (punktMenu == 1) {
            System.out.print("\n");
            General general = new MiniSeries();
            ThreadWrite threadWrite = new ThreadWrite(general);
            ThreadRead threadRead = new ThreadRead(general);
            threadWrite.setPriority(10);
            threadRead.setPriority(1);
            threadWrite.start();
            threadRead.start();
            System.out.println("\nИТОГОВЫЙ ОБЪЕКТ " + general.toString());
        }
        if (punktMenu == 2) {
            System.out.print("\n");
            General general = new MiniSeries();
            GeneralSynchronizer generalSynchronizer = new GeneralSynchronizer(general);
            Thread threadWrite = new Thread(new ThreadWriteRunnable(generalSynchronizer));
            Thread threadRead = new Thread(new ThreadReadRunnable(generalSynchronizer));
            threadWrite.start();
            threadRead.start();
        }
        if (punktMenu == 3) {
            System.out.print("\n");
            General general = new MiniSeries();
            GeneralSynchronizer generalSynchronizer = new GeneralSynchronizer(WorkWithStreams.synchronizedGeneral(general));
            Thread threadWrite = new Thread(new ThreadWriteRunnable(generalSynchronizer));
            Thread threadRead = new Thread(new ThreadReadRunnable(generalSynchronizer));
            threadWrite.start();
            threadRead.start();
        }
    }
}



