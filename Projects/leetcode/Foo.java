package leetcode;

import java.util.concurrent.Semaphore;

class Foo {
    private final Semaphore checkpoint1 = new Semaphore(1);
    private final Semaphore checkpoint2 = new Semaphore(1);

    public Foo() {
        try {
            checkpoint1.acquire();
            checkpoint2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first(Runnable printFirst) {
        printFirst.run();
        checkpoint1.release();
    }

    public void second(Runnable printSecond) {
        try {
            checkpoint1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printSecond.run();
        checkpoint2.release();
    }

    public void third(Runnable printThird) {
        try {
            checkpoint2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printThird.run();
    }
}
