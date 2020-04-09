package com.example.snippets.threading.thread_local_2;

// https://veerasundar.com/blog/2010/11/java-thread-local-how-to-use-and-code-sample/
public class ThreadLocalDemo extends Thread {

    @Override
    public void run() {
        Context context = new Context();
        context.setTransactionId(this.getName());
        MyThreadLocal.set(context);

        System.out.println("Setting Transaction ID : " + context.getTransactionId());

        new BusinessService().businessMethod();
        MyThreadLocal.unset();

    }

    public static void main(String[] args) {
        Thread threadOne = new ThreadLocalDemo();
        threadOne.start();

        Thread thread2 = new ThreadLocalDemo();
        thread2.start();
    }

}
