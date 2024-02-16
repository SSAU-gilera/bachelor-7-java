import java.util.Random;

public class ThreadRead extends Thread{
    private General general;

    public ThreadRead(General general){
        this.general = general;
    }

    @Override
    public void run(){
        for (int i=0;i<general.getTotalNum(general.getName());i++){
            System.out.println("Read: " + general.getEachTime(i) + " from position " + i);
        }
    }
}
