public class GeneralSynchronizer {
    private General general;
    private volatile int current = 0;
    private boolean set = false;

    public GeneralSynchronizer(General general) {
        this.general = general;
    }

    public synchronized void write(int val) throws InterruptedException {
        while (set) {
            wait();
        }
        if (current < general.getTotalNum(general.getName())) {
            general.setEachTime(current, val);
            System.out.println("Write: " + val + " to position " + current);
            set = true;
            notify();
        }
    }

    public synchronized int read() throws InterruptedException {
        while (!set) {
            wait();
        }
        int val = 0;
        if (current < general.getTotalNum(general.getName())) {
            val = general.getEachTime(current);
            System.out.println("Read: " + val + " from position " + current);
            set = false;
            current++;
            notify();
        }
        return val;
    }
}
