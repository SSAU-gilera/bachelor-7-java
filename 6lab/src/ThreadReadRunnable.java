public class ThreadReadRunnable implements Runnable {
    GeneralSynchronizer generalSynchronizer;

    public ThreadReadRunnable(GeneralSynchronizer generalSynchronizer){
        this.generalSynchronizer = generalSynchronizer;
    }

    @Override
    public void run(){
        for (int i=0;i<2;i++){
            try {
                generalSynchronizer.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
