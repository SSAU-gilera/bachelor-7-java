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
        System.out.print("Сколько объектов вы хотите создать? ");
        int numOfObjects = in.nextInt();
        General[] object = new General[numOfObjects];
        for (int i = 0; i < numOfObjects; i++) {
            System.out.println("\nКакой объект вы хотите добавить?");
            System.out.println("1 - сериал, 2 - серия фильмов");
            System.out.print("Ваш выбор: ");
            int o = in.nextInt();
            if (o == 1) {
                System.out.print("\nНазвание сериала: ");
                in.nextLine();
                String nameOfMiniSeries = in.nextLine();
                System.out.print("Количество серий: ");
                int numOfEpisodes = in.nextInt();
                int[] timeOfEachEpisode = new int[numOfEpisodes];
                for (int j = 0; j < numOfEpisodes; j++) {
                    System.out.print("Длительность " + (j + 1) + " серии (в минутах): ");
                    timeOfEachEpisode[j] = in.nextInt();
                }
                System.out.print("Средняя длительность титров (в минутах): ");
                int timeOfTitles = in.nextInt();
                try {
                    object[i] = new MiniSeries(nameOfMiniSeries, timeOfEachEpisode, timeOfTitles);
                } catch (MiniSeries.CapacityZeroException e) {
                    System.out.print("Исключение: " + e.getMessage());
                } catch (MiniSeries.IllegalArgumentException e) {
                    System.out.print("Исключение: " + e.getMessage());
                }
            }
            if (o == 2) {
                System.out.print("\nНазвание серии фильмов: ");
                in.nextLine();
                String nameOfMovieSeries = in.nextLine();
                System.out.print("Количество фильмов: ");
                int numOfMovies = in.nextInt();
                int[] timeOfEachMovie = new int[numOfMovies];
                for (int j = 0; j < numOfMovies; j++) {
                    System.out.print("Длительность " + (j + 1) + " фильма (в минутах): ");
                    timeOfEachMovie[j] = in.nextInt();
                }
                System.out.print("Средняя длительность титров (в минутах): ");
                int timeOfTitles = in.nextInt();
                try {
                    object[i] = new Movies(nameOfMovieSeries, timeOfEachMovie, timeOfTitles);
                } catch (Movies.CapacityZeroException e) {
                    System.out.print("Исключение: " + e.getMessage());
                } catch (Movies.IllegalArgumentException e) {
                    System.out.print("Исключение: " + e.getMessage());
                }
            }
        }
//        General currentObj = null;
//        System.out.println("\n---------------------------------------");
//        System.out.println("\nНазвания всех объектов:");
//        for (int i = 0; i < numOfObjects; i++) {
//            System.out.print((i + 1) + " - " + object[i].getName() + "\n");
//        }
//        do {
//            System.out.print("Введите объект, с которым хотите работать: ");
//            int currentName = in.nextInt();
//            currentObj = object[currentName - 1];
//            if (currentObj == null) {
//                System.out.print("Такого объекта не существует");
//            }
//        }
//        while (currentObj == null);
        System.out.println("\n---------------------------------------");
        System.out.println("1.Запись в байтовый поток");
        System.out.println("2.Чтение из байтового потока");
        System.out.println("3.Запись в символьный поток");
        System.out.println("4.Чтение из символьного потока");
        System.out.println("5.Сериализация объекта");
        System.out.println("6.Десериализация объекта");
        System.out.println("0.Выбор другого объекта");
        System.out.println("---------------------------------------");
        do {
            System.out.println("\n-------------------------");
            System.out.print("Выберите пункт меню: ");
            punktMenu = in.nextInt();
            switch (punktMenu) {
                case (1):
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream("byte.bin");
                        for (int i=0;i<numOfObjects;i++){
                            WorkWithStreams.outputGeneral(object[i], fileOutputStream);
                        }
                        //WorkWithStreams.outputGeneral(currentObj, fileOutputStream);
                        fileOutputStream.close();
                    } catch (IOException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    }
                    System.out.println("Объекты записаны в байтовый поток");
                    System.out.println("-------------------------");
                    break;
                case (2):
                    FileInputStream fileInputStream = null;
                    try {
                        fileInputStream = new FileInputStream("byte.bin");
                        for (int i=0;i<numOfObjects;i++){
                            General current = WorkWithStreams.inputGeneral(fileInputStream);
                            System.out.println(current);
                        }
                        //General current = WorkWithStreams.inputGeneral(fileInputStream);
                        //System.out.println(current);
                        fileInputStream.close();
                    } catch (IOException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    } catch (MiniSeries.CapacityZeroException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    }
                    System.out.println("-------------------------");
                    break;
                case (3):
                    try {
                        FileWriter fileWriter = new FileWriter("symbol.txt");
                        for (int i=0;i<numOfObjects;i++){
                            WorkWithStreams.writeGeneral(object[i], fileWriter);
                        }
                        //WorkWithStreams.writeGeneral(currentObj, fileWriter);
                        fileWriter.close();
                    } catch (IOException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    }
                    System.out.println("Объекты записаны в символьный поток");
                    System.out.println("-------------------------");
                    break;
                case (4):
                    FileReader fileReader = null;
                    try {
                        fileReader = new FileReader("symbol.txt");
                        for (int i=0;i<numOfObjects;i++){
                            General current = WorkWithStreams.readGeneral(fileReader);
                            System.out.println(current);
                        }
                        //General current = WorkWithStreams.readGeneral(fileReader);
                        //System.out.println(current);
                        fileReader.close();
                    } catch (IOException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    } catch (MiniSeries.CapacityZeroException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    }
                    System.out.println("-------------------------");
                    break;
                case (5):
                    FileOutputStream fileOutputStream1 = null;
                    try {
                        fileOutputStream1 = new FileOutputStream("serialization.bin");
                        for (int i=0;i<numOfObjects;i++){
                            WorkWithStreams.serializeGeneral(object[i], fileOutputStream1);
                        }
                        //WorkWithStreams.serializeGeneral(currentObj, fileOutputStream1);
                        fileOutputStream1.close();
                    } catch (IOException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    }
                    System.out.println("Объекты сериализованы");
                    System.out.println("-------------------------");
                    break;
                case (6):
                    FileInputStream fileInputStream1 = null;
                    try {
                        fileInputStream1 = new FileInputStream("serialization.bin");
                        for (int i=0;i<numOfObjects;i++){
                            General current = WorkWithStreams.deserializeGeneral(fileInputStream1);
                            System.out.println(current);
                        }
                        //General current = WorkWithStreams.deserializeGeneral(fileInputStream1);
                        //System.out.println(current);
                        fileInputStream1.close();
                    } catch (IOException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    } catch (ClassNotFoundException e) {
                        System.out.print("Исключение: " + e.getMessage());
                    }
                    System.out.println("-------------------------");
                    break;
            }
        }
        while (punktMenu != 0);
    }
}



