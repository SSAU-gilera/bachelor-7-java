import java.util.Objects;

public class MiniSeries implements General {

    private String nameOfMiniSeries;
    private int[] timeOfEachEpisode;
    private int timeOfTitles;

    public MiniSeries(String nameOfMiniSeries, int[] timeOfEachEpisode, int timeOfTitles)
            throws CapacityZeroException, IllegalArgumentException {
        this.nameOfMiniSeries = nameOfMiniSeries;
        this.timeOfEachEpisode = timeOfEachEpisode;
        if (timeOfEachEpisode.length<=0){
            throw new CapacityZeroException("В сериале не может быть меньше 1 серии");
        }
        this.timeOfTitles = timeOfTitles;
        if (timeOfTitles < 1){
            throw new IllegalArgumentException("Титры не могут быть меньше минуты");
        }
    }

    public MiniSeries() {
        this.nameOfMiniSeries = "Мини-сериал";
        this.timeOfEachEpisode = new int[]{45, 45};
        this.timeOfTitles = 1;
    }

    public String getName() {
        return nameOfMiniSeries;
    }

    public void setName(String nameOfMiniSeries) {
        this.nameOfMiniSeries = nameOfMiniSeries;
    }

    public int getEachTime(int episodeNum) {
        return timeOfEachEpisode[episodeNum - 1];
    }

    public void setEachTime(int episodeNum, int timeOfEpisode) {
        this.timeOfEachEpisode[episodeNum - 1] = timeOfEpisode;
    }

    public int getTotalNum(String nameOfMiniSeries) {
        return timeOfEachEpisode.length;
    }

    public int getTimeOfTitles() {
        return timeOfTitles;
    }

    public void setTimeOfTitles(int timeOfTitles) {
        this.timeOfTitles = timeOfTitles;
    }

    public int getTotalTime() {
        int[] timeWithoutTitles = new int[timeOfEachEpisode.length];
        int totalTime =0;
        for (int i = 0; i < timeOfEachEpisode.length; i++) {
            timeWithoutTitles[i] = timeOfEachEpisode[i] - timeOfTitles;
            totalTime+=timeWithoutTitles[i];
        }
        return totalTime;
    }

    @Override
    public String toString(){
        String info;
        info = "\nНазвание сериала: "+nameOfMiniSeries
                +"\nКоличество серий: "+timeOfEachEpisode.length
                +"\nДлительность каждой серии:";
        for (int i=0;i<timeOfEachEpisode.length;i++){
            info+="\n"+ (i+1) + " серия: " + timeOfEachEpisode[i] + " мин";
        }
        info+="\nСреднее время титров: "+timeOfTitles +" мин";
        info+="\nОбщая длительность сериала без титров: "+getTotalTime()+" мин";
        return info;
    }
    @Override
    public boolean equals(Object o){
        if(this== o){return true;}
        if(o ==null||getClass()!=o.getClass()){return false;}
        MiniSeries miniSeries=(MiniSeries) o;
        return nameOfMiniSeries.equals(miniSeries.nameOfMiniSeries)&&
                timeOfEachEpisode.equals(miniSeries.timeOfEachEpisode)&&
                timeOfTitles == miniSeries.timeOfTitles;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nameOfMiniSeries == null) ? 0 : nameOfMiniSeries.hashCode());
        result = prime * result + ((timeOfEachEpisode == null) ? 0 : timeOfEachEpisode.hashCode());
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

