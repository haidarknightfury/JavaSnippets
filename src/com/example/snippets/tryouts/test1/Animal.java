package com.example.snippets.tryouts.test1;

public interface Animal {
    class DefaultAnimal {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    void display(DefaultAnimal an);
}
