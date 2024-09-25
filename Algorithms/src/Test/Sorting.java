package Test;

import java.util.*;

public class Sorting {
    class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + ": " + age;
        }
    }

    class PersonComaprator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
           return Integer.compare(p1.age,p2.age);
        }

    }

    public Person[] people;

    public Sorting() {
        people = new Person[6];
        people[0] = new Person("Jake", 30);
        people[1] = new Person("Shawn", 37);
        people[2] = new Person("Amy", 28);
        people[3] = new Person("Kaitlin", 28);
        people[4] = new Person("Darryl", 37);
        people[5] = new Person("Toni", 28);

        Arrays.sort(people, new PersonComaprator());
    }


}


