import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadPool {

    private Deque<Runnable> tasks;
    private PoolWorker[] pool;

    public ThreadPool(int threadsCount) {

        tasks = new ConcurrentLinkedDeque<>();
        pool = new PoolWorker[threadsCount];
        for (int i = 0; i < pool.length; i++) {
            pool[i] = new PoolWorker();
            pool[i].start();
        }
    }

    public void submit(Runnable task) {
        tasks.add(task);
    }

    private class PoolWorker extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (tasks){
                    task = tasks.pollFirst();
                }
                if(task != null) task.run();
            }
        }
    }

}
