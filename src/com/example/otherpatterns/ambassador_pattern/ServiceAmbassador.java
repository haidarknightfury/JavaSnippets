package com.example.otherpatterns.ambassador_pattern;

public class ServiceAmbassador implements RemoteServiceInterface {

    private static final int RETRIES = 3;
    private static final int DELAY_MS = 3000;

    @Override
    public long doRemoteFunction(int value) {
        return this.safeCall(value);
    }

    private long safeCall(int value) {
        int retries = 0;
        long result = FAILURE;
        for (int i = 0; i < RETRIES; i++) {
            if (retries >= RETRIES) {
                return FAILURE;
            }

            if ((result = this.checkLatency(value)) == FAILURE) {
                System.out.println(String.format("Failed to reach remote:  (%d)", i + 1));
                retries++;
                try {
                    Thread.sleep(DELAY_MS);
                } catch (Exception e) {
                    System.out.println("Thread.sleep interrupted");
                }
            } else {
                break;
            }

        }
        return result;
    }

    private long checkLatency(int value) {
        long startTime = System.currentTimeMillis();
        long result = RemoteService.getRemoteService().doRemoteFunction(value);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(String.format("Time taken is %d ms", timeTaken));

        return result;
    }

}
