import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public interface General extends Iterable<Integer>{
    String getName();
    void setName(String name);

    int getEachTime(int n);
    void setEachTime(int n, int time);

    int getTotalNum (String name);

    int getTimeOfTitles();
    void setTimeOfTitles(int timeOfTitles);

    int getTotalTime();

    void output(OutputStream out) throws IOException;
    void write(Writer out);
}
