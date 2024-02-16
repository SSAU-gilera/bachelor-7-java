import java.util.Iterator;

public class GeneralIterator implements Iterator<Integer> {
    private General general;
    private int i;
    public GeneralIterator (General general){
        this.general = general;
        i = 0;
    }
    @Override
    public boolean hasNext(){
        return i<general.getTotalNum(general.getName());
    }

    @Override
    public Integer next() {
        return general.getEachTime(i++);
    }
}