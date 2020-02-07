package com.example.otherpatterns.retry_pattern;

public class Main {

    public static void main(String[] args) {
        noErrors();
        errorNoRetry();
        errorWithRetry();
        errorWithRetryIgnoreCustomerNotFoundException();
    }

    private static void noErrors() {
        BusinessOperation<String> op = new FindCustomer("123"); // No errors
        String result;
        try {
            result = op.perform();
            System.out.println(result);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    private static void errorNoRetry() {
        BusinessOperation<String> op = new FindCustomer("123", new CustomerNotFoundException("Customer not Found"));
        try {
            String result = op.perform();
            System.out.println(result);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void errorWithRetry() {
        try {
            final Retry<String> retry = new Retry<>(new FindCustomer("12345", new CustomerNotFoundException("Customer Not Found")), 2, 100);
            String result = retry.perform();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void errorWithRetryIgnoreCustomerNotFoundException() {
        try {
            String customerId = "12345";
            final Retry<String> retry = new Retry<>(new FindCustomer(customerId, new CustomerNotFoundException("Customer Not Found"), new CustomerNotFoundException("Customer Not Found"),
                    new CustomerNotFoundException("Customer Not Found")), 7, 1000, (e) -> CustomerNotFoundException.class.isAssignableFrom(e.getClass()));
            String result = retry.perform();
            System.out.println(result);
            System.out.println(String.format("However, retrying the operation while ignoring a recoverable error will eventually yield " + "the result %s after a number of attempts %s", customerId,
                    retry.attempts()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
