package ex1_thread;

public class ThreadSub extends Thread {

    @Override
    public void run() {
        // 프로세서의 독립적인 수행을 위한 영역
        for (int i = 0; i < 10; i++) {

            // 0.5초간 휴식
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }

            System.out.println("스레드 실행중");

        } // for

    }

}
