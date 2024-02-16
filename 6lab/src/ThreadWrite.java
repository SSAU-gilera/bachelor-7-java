import java.util.Random;

public class ThreadWrite extends Thread{
    private General general;

    public ThreadWrite(General general){
        this.general = general;
    }

    private static int generateRandom() {//максимально значение - 200, минимальное - 30 минут
        Random r = new Random();
        return r.nextInt(171) + 30;
    }

    @Override
    public void run(){
        for (int i=0;i<general.getTotalNum(general.getName());i++){
            general.setEachTime(i,generateRandom());
            System.out.println("Write: " + general.getEachTime(i) + " to position " + i);
        }
    }
}
