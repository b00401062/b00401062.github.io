package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private final int n;
    private final Semaphore[] locks = new Semaphore[]{
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1)
    };

    public ZeroEvenOdd(int n) {
        this.n = n;
        try {
            locks[0].acquire();
            locks[1].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            locks[2].acquire();
            printNumber.accept(0);
            locks[i % 2].release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            locks[0].acquire();
            printNumber.accept(i);
            locks[2].release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            locks[1].acquire();
            printNumber.accept(i);
            locks[2].release();
        }
    }
}
