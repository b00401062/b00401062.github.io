package leetcode;

import java.util.concurrent.Semaphore;

public class FooBar {

    private int n;
    private Semaphore can_foo = new Semaphore(1);
    private Semaphore can_bar = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
        try {
            can_bar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            can_foo.acquire();
            printFoo.run();
            can_bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            can_bar.acquire();
            printBar.run();
            can_foo.release();
        }
    }
}
