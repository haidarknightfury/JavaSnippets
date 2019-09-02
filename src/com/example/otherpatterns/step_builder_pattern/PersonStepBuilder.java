package com.example.otherpatterns.step_builder_pattern;

import java.util.ArrayList;
import java.util.List;

public class PersonStepBuilder {

    private PersonStepBuilder() {
    }

    public static NameStep newBuilder() {
        return new PersonSteps();
    }

    public interface NameStep {
        UsernameStep name(String name);

        BuildStep noMoreProperties();
    }

    public interface UsernameStep {
        RoleStep withUsername(String username);
    }

    public interface RoleStep {
        BuildStep noRoles();

        BuildStep withNoMoreRole();

        RoleStep withRole(String role);
    }

    public interface BuildStep {
        Person build();
    }

    private static class PersonSteps implements NameStep, UsernameStep, RoleStep, BuildStep {

        private String name;
        private String username;
        private List<String> roles;
        private String othernames;
        private Integer age;

        @Override
        public Person build() {
            Person person = new Person(this.name);
            if (this.username != null) {
                person.setUsername(this.username);
            }
            if (this.roles != null && !this.roles.isEmpty()) {
                person.setRoles(this.roles);
            }
            person.setAge(this.age);
            person.setOthernames(this.othernames);

            return person;
        }

        @Override
        public BuildStep noRoles() {
            this.roles = new ArrayList<String>();
            return this;
        }

        @Override
        public BuildStep withNoMoreRole() {
            return this;
        }

        @Override
        public RoleStep withRole(String role) {
            if (this.roles != null) {
                this.roles.add(role);
            } else {
                this.roles = new ArrayList<String>();
                this.roles.add(role);
            }
            return this;
        }

        @Override
        public RoleStep withUsername(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UsernameStep name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public BuildStep noMoreProperties() {
            return this;
        }

    }

}
