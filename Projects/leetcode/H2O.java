package leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2O {
    private final Semaphore[] locks = new Semaphore[]{
            new Semaphore(2),
            new Semaphore(1)
    };

    private final CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        this.locks[0].release(2);
        this.locks[1].release(1);
    });

    public final void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        this.locks[0].acquire();
        releaseHydrogen.run();
        try {
            this.barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public final void oxygen(Runnable releaseOxygen) throws InterruptedException {
        this.locks[1].acquire();
        releaseOxygen.run();
        try {
            this.barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
