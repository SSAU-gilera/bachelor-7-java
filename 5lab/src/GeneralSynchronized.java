import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class GeneralSynchronized implements General{
    private final General general;

    public GeneralSynchronized(General general) {
        this.general = general;
    }

    @Override
    public String getName(){
        general.getName();
        return null;
    }
    @Override
    public void setName(String name){
        general.setName(name);
    }

    @Override
    public int getEachTime(int n){
        return general.getEachTime(n);
    }
    @Override
    public void setEachTime(int n, int time){
        general.setEachTime(n,time);
    }

    @Override
    public int getTotalNum(String name){
        return general.getTotalNum(name);
    }

    @Override
    public int getTimeOfTitles(){
        return general.getTimeOfTitles();
    }
    @Override
    public void setTimeOfTitles(int timeOfTitles){
        general.setTimeOfTitles(timeOfTitles);
    }

    @Override
    public int getTotalTime(){
        return general.getTotalTime();
    }

    @Override
    public void output(OutputStream out) throws IOException{
        general.output(out);
    }
    @Override
    public void write(Writer out){
        general.write(out);
    }
}
