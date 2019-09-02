package com.example.memmgt.esc_references;

public interface CustomerReadOnly {

    String getName();

    String getContact();

    @Override
    String toString();

}