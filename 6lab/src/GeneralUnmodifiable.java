import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;


public class GeneralUnmodifiable implements General{
    private General general;

    public GeneralUnmodifiable(General general){
        this.general=general;
    }

    @Override
    public String getName() {
        return general.getName();
    }
    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException();
    }
    @Override
    public int getEachTime(int n) {
        return general.getEachTime(n);
    }
    @Override
    public void setEachTime(int n, int time) {
        throw new UnsupportedOperationException();
    }
    @Override
    public int getTotalNum(String name) {
        return general.getTotalNum(name);
    }
    @Override
    public int getTimeOfTitles() {
        return general.getTimeOfTitles();
    }
    @Override
    public void setTimeOfTitles(int timeOfTitles) {
        throw new UnsupportedOperationException();
    }
    @Override
    public int getTotalTime() {
        return general.getTotalTime();
    }
    @Override
    public void output(OutputStream out) throws IOException {
        throw new UnsupportedOperationException();
    }
    @Override
    public void write(Writer out) {
        throw new UnsupportedOperationException();
    }
    @Override
    public Iterator<Integer> iterator() {
        return general.iterator();
    }
}

