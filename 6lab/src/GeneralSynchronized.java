import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class GeneralSynchronized implements General{
    private final General general;

    public GeneralSynchronized(General general) {
        this.general = general;
    }

    @Override
    public synchronized String getName(){
        general.getName();
        return null;
    }
    @Override
    public synchronized void setName(String name){
        general.setName(name);
    }

    @Override
    public synchronized int getEachTime(int n){
        return general.getEachTime(n);
    }
    @Override
    public synchronized void setEachTime(int n, int time){
        general.setEachTime(n,time);
    }

    @Override
    public synchronized int getTotalNum(String name){
        return general.getTotalNum(name);
    }

    @Override
    public synchronized int getTimeOfTitles(){
        return general.getTimeOfTitles();
    }
    @Override
    public synchronized void setTimeOfTitles(int timeOfTitles){
        general.setTimeOfTitles(timeOfTitles);
    }

    @Override
    public synchronized int getTotalTime(){
        return general.getTotalTime();
    }

    @Override
    public synchronized void output(OutputStream out) throws IOException{
        general.output(out);
    }
    @Override
    public synchronized void write(Writer out){
        general.write(out);
    }

    @Override
    public Iterator<Integer> iterator() {
        return general.iterator();
    }
}
