import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        doTask();
    }

    static void doTask() {

        General general;
        WorkWithStreams.setFactory(new MoviesFactory());
        general = WorkWithStreams.createInstance();

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
            for (Iterator<Integer> iterator = general.iterator(); iterator.hasNext(); ) {
                System.out.println(iterator.next());
            }
            for(Integer i: general){
                System.out.println(i);
            }
        }
        else if (punktMenu == 2) {
            System.out.print("\n");
            General unmodGeneral=WorkWithStreams.unmodifiableGeneral(general);
            try {
                System.out.printf("Введите новое название: ");
                String newName = in.next();
                System.out.print("\n");
                unmodGeneral.setName(newName);
            }
            catch (UnsupportedOperationException e){
                System.out.println("Этот объект нельзя изменять");
            }
        }
        else if (punktMenu == 3) {
            System.out.println(general.toString());
        }
        else if (punktMenu == 0){
            return;
        }
    }
}



