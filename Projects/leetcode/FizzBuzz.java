package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private final int n;
    private int i = 1;
    private final Semaphore[] locks = new Semaphore[4];

    public FizzBuzz(int n) {
        this.n = n;
        for (int i = 0; i < 4; i++) {
            locks[i] = new Semaphore(1);
        }
        try {
            locks[0].acquire();
            locks[1].acquire();
            locks[2].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void release() {
        if (++i > n) for (int j = 0; j < 4; j++) locks[j].release();
        else if (i % 15 == 0) locks[2].release();
        else if (i % 3 == 0) locks[0].release();
        else if (i % 5 == 0) locks[1].release();
        else locks[3].release();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            locks[0].acquire();
            if (i > n) break;
            printFizz.run();
            release();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            locks[1].acquire();
            if (i > n) break;
            printBuzz.run();
            release();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            locks[2].acquire();
            if (i > n) break;
            printFizzBuzz.run();
            release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            locks[3].acquire();
            if (i > n) break;
            printNumber.accept(i);
            release();
        }
    }
}
