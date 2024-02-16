import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        doTask();
    }

    static void doTask (){
        int punktMenu = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Сколько объектов вы хотите создать? ");
        int numOfObjects = in.nextInt();
        General[] object = new General[numOfObjects];
        for (int i=0;i<numOfObjects;i++){
            System.out.println("\nКакой объект вы хотите добавить?");
            System.out.println("1 - сериал, 2 - серия фильмов");
            System.out.print("Ваш выбор: ");
            int o=in.nextInt();
            if (o==1){
                System.out.print("\nНазвание сериала: ");
                in.nextLine();
                String nameOfMiniSeries = in.nextLine();
                System.out.print("Количество серий: ");
                int numOfEpisodes = in.nextInt();
                int[] timeOfEachEpisode = new int[numOfEpisodes];
                for (int j=0;j<numOfEpisodes;j++){
                    System.out.print("Длительность "+(j+1)+ " серии (в минутах): ");
                    timeOfEachEpisode[j]=in.nextInt();
                }
                System.out.print("Средняя длительность титров (в минутах): ");
                int timeOfTitles = in.nextInt();
                try {
                    object[i]=new MiniSeries(nameOfMiniSeries,timeOfEachEpisode,timeOfTitles);
                }
                catch (MiniSeries.CapacityZeroException e){
                    System.out.print("Исключение: " +e.getMessage());
                }
                catch (MiniSeries.IllegalArgumentException e){
                    System.out.print("Исключение: " +e.getMessage());
                }
            }
            if (o==2){
                System.out.print("\nНазвание серии фильмов: ");
                in.nextLine();
                String nameOfMovieSeries = in.nextLine();
                System.out.print("Количество фильмов: ");
                int numOfMovies = in.nextInt();
                int[] timeOfEachMovie = new int[numOfMovies];
                for (int j=0;j<numOfMovies;j++){
                    System.out.print("Длительность "+(j+1)+ " фильма (в минутах): ");
                    timeOfEachMovie[j]=in.nextInt();
                }
                System.out.print("Средняя длительность титров (в минутах): ");
                int timeOfTitles = in.nextInt();
                try {
                    object[i]=new Movies(nameOfMovieSeries,timeOfEachMovie,timeOfTitles);
                }
                catch (Movies.CapacityZeroException e){
                    System.out.print("Исключение: " +e.getMessage());
                }
                catch (Movies.IllegalArgumentException e){
                    System.out.print("Исключение: " +e.getMessage());
                }
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("1.Полная информация по каждому объекту");
        System.out.println("2.Вывод серии фильмов и сериала с одинаковой длительностью");
        System.out.println("3.Сортировка по типу объекта");
        System.out.println("0.Выход");
        System.out.println("---------------------------------------");
        do{
            System.out.println("\n-------------------------");
            System.out.print("Выберите пункт меню: ");
            punktMenu = in.nextInt();
            switch (punktMenu) {
                case (1):
                    for (int i = 0; i < numOfObjects; i++) {
                        System.out.print(object[i].toString() + "\n");
                    }
                    System.out.println("-------------------------");
                    break;
                case (2):
                    int[] totalTimes = new int[numOfObjects];
                    for (int i = 0; i < numOfObjects; i++) {
                        totalTimes[i] = object[i].getTotalTime();
                    }
                    ArrayList<ArrayList<General>> similar = new ArrayList<>();
                    for (int i=0;i<numOfObjects;i++){
                        int numOfSimilar =0;
                        ArrayList<General> list = new ArrayList<>();
                        for (int j = i+1;j<numOfObjects;j++){
                            if (totalTimes[i] == totalTimes[j]){
                                if (numOfSimilar==0){
                                    list.add(object[i]);
                                    numOfSimilar++;
                                }
                                list.add(object[j]);
                                numOfSimilar++;
                            }
                        }
                        if (numOfSimilar!=0) {
                            similar.add(list);
                        }
                    }
                    System.out.print("\nОбъекты с одинаковой общей длительностью:\n");
                    for (int i = 0; i < similar.size(); i++) {
                        ArrayList<General> list = similar.get(i);
                        for (int j=0;j<list.size();j++) {
                            System.out.print(list.get(j).toString() + "\n");
                        }
                        System.out.println();
                    }
                    System.out.println("-------------------------");
                    break;
                case (3):
                    int numOfMiniSeries=0;
                    int numOfMovieSeries = 0;
                    for (int i=0;i<numOfObjects;i++) {
                        if (object[i].getClass()==MiniSeries.class){
                            numOfMiniSeries++;
                        }
                        else numOfMovieSeries++;
                    }
                    General[] onlyMiniSeries = new General[numOfMiniSeries];
                    General[] onlyMovieSeries = new General[numOfMovieSeries];
                    int s=0;
                    int m=0;
                    for (int i=0;i<numOfObjects;i++){
                        if (object[i].getClass()==MiniSeries.class){
                            onlyMiniSeries[m]=object[i];
                            m++;
                        }
                        else {
                            onlyMovieSeries[s] = object[i];
                            s++;
                        }
                    }
                    if (onlyMiniSeries[0]!=null){
                        System.out.println("\n~~~ Мини-сериалы ~~~");
                        for (int i=0;i<numOfMiniSeries;i++){
                            System.out.print(onlyMiniSeries[i].toString() + "\n");
                        }
                    }
                    else System.out.println("\n~~~ Мини-сериалов нет ~~~");
                    if (onlyMiniSeries[0]!=null){
                        System.out.println("\n~~~ Серии фильмов ~~~");
                        for (int i=0;i<numOfMovieSeries;i++){
                            System.out.print(onlyMovieSeries[i].toString() + "\n");
                        }
                    }
                    else System.out.println("\n~~~ Серий фильмов нет ~~~");
                    System.out.println("-------------------------");
                    break;
            }
        }
        while (punktMenu != 0);
    }
}