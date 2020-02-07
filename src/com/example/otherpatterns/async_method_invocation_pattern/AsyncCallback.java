package com.example.otherpatterns.async_method_invocation_pattern;

import java.util.Optional;

public interface AsyncCallback<T> {

    void onComplete(T value, Optional<Exception> ex);

}
