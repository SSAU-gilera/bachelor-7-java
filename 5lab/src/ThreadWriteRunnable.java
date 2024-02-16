import java.util.Random;

public class ThreadWriteRunnable implements Runnable{
    GeneralSynchronizer generalSynchronizer;

    public ThreadWriteRunnable(GeneralSynchronizer generalSynchronizer){
        this.generalSynchronizer = generalSynchronizer;
    }

    private static int generateRandom() {//максимально значение - 200, минимальное - 30 минут
        Random r = new Random();
        return r.nextInt(171) + 30;
    }

    @Override
    public void run(){
        for (int i=0;i<2;i++){
            try {
                generalSynchronizer.write(generateRandom());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
