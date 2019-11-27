package com.basic.datastruct.hash;

import java.util.Objects;

public class Student {

    private int cla;
    private int score;
    private String firstName;
    private String lastName;

    public Student(int cla, int score, String firstName, String lastName) {
        this.cla = cla;
        this.score = score;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return cla == student.cla &&
                score == student.score &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cla, score, firstName, lastName);
    }
}
