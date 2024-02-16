import java.io.*;
import java.io.Serializable;

public class Movies implements General, Serializable{

    private static final long serialVersionUID = 1L;

    private String nameOfMovieSeries;
    private int[] timeOfEachMovie;
    private int timeOfTitles;

    public Movies(String nameOfMovieSeries, int[] timeOfEachMovie, int timeOfTitles)
            throws CapacityZeroException, IllegalArgumentException{
        this.nameOfMovieSeries = nameOfMovieSeries;
        this.timeOfEachMovie = timeOfEachMovie;
        if (timeOfEachMovie.length<=0){
            throw new CapacityZeroException("В серии фильмов не может быть меньше 1 фильма");
        }
        this.timeOfTitles = timeOfTitles;
        if (timeOfTitles < 1){
            throw new IllegalArgumentException("Титры не могут быть меньше минуты");
        }
    }

    public Movies() {
        this.nameOfMovieSeries = "Серия фильмов";
        this.timeOfEachMovie = new int[]{90, 90};
        this.timeOfTitles = 10;
    }

    public String getName() {
        return nameOfMovieSeries;
    }

    public void setName(String nameOfMovieSeries) {
        this.nameOfMovieSeries = nameOfMovieSeries;
    }

    public int getEachTime(int movieNum) {
        return timeOfEachMovie[movieNum - 1];
    }

    public void setEachTime(int movieNum, int timeOfMovie) {
        this.timeOfEachMovie[movieNum - 1] = timeOfMovie;
    }

    public int getTotalNum(String nameOfMovieSeries) {
        return timeOfEachMovie.length;
    }

    public int getTimeOfTitles() {
        return timeOfTitles;
    }

    public void setTimeOfTitles(int timeOfTitles) {
        this.timeOfTitles = timeOfTitles;
    }

    public int getTotalTime() {
        int[] timeWithoutTitles = new int[timeOfEachMovie.length];
        int totalTime =0;
        for (int i = 0; i < timeOfEachMovie.length; i++) {
            timeWithoutTitles[i] = timeOfEachMovie[i] - timeOfTitles;
            totalTime+=timeWithoutTitles[i];
        }
        return totalTime;
    }

    public void output(OutputStream out) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeUTF(nameOfMovieSeries);
        dataOutputStream.writeInt(timeOfEachMovie.length);
        for (int i=0;i<timeOfEachMovie.length;i++){
            dataOutputStream.writeInt(timeOfEachMovie[i]);
        }
        dataOutputStream.writeInt(timeOfTitles);
    }

    public void write(Writer out){
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.println(nameOfMovieSeries);
        printWriter.println(timeOfEachMovie.length);
        for (int i=0;i<timeOfEachMovie.length;i++){
            printWriter.println(timeOfEachMovie[i]);
        }
        printWriter.println(timeOfTitles);
    }

    @Override
    public String toString(){
        String info;
        info = "\nНазвание серии фильмов: "+nameOfMovieSeries
                +"\nКоличество фильмов: "+timeOfEachMovie.length
                +"\nДлительность каждого фильма:";
        for (int i=0;i<timeOfEachMovie.length;i++){
            info+="\n" + (i+1) + " фильм: " + timeOfEachMovie[i] + " мин";
        }
        info+="\nСреднее время титров: "+timeOfTitles+ " мин";
        info+="\nОбщая длительность серии фильмов без титров: "+getTotalTime()+ " мин";
        return info;
    }
    @Override
    public boolean equals(Object o){
        if(this== o){return true;}
        if(o ==null||getClass()!=o.getClass()){return false;}
        Movies movies=(Movies) o;
        return nameOfMovieSeries.equals(movies.nameOfMovieSeries)&&
                timeOfEachMovie.equals(movies.timeOfEachMovie)&&
                timeOfTitles == movies.timeOfTitles;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nameOfMovieSeries == null) ? 0 : nameOfMovieSeries.hashCode());
        result = prime * result + ((timeOfEachMovie == null) ? 0 : timeOfEachMovie.hashCode());
        result = prime * result + timeOfTitles;
        return result;
    }
    public static class IllegalArgumentException extends RuntimeException{
        public IllegalArgumentException(String message){
            super(message);
        }
    }
    public static class CapacityZeroException extends Exception{
        public CapacityZeroException (String message){
            super(message);
        }
    }


}

