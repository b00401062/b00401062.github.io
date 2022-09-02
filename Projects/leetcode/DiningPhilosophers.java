package leetcode;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    private final Semaphore[] locks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            locks[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork
    ) throws InterruptedException {
        if (philosopher % 2 == 0) {
            locks[philosopher].acquire();
            locks[(philosopher + 1) % 5].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
            locks[(philosopher + 1) % 5].release();
            locks[philosopher].release();
        } else {
            locks[(philosopher + 1) % 5].acquire();
            locks[philosopher].acquire();
            pickRightFork.run();
            pickLeftFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            locks[philosopher].release();
            locks[(philosopher + 1) % 5].release();
        }
    }
}
