package jv_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class main_people {
    public static void main(String[] args) {
        List<Person> people = peoplelist();

        //----------Imperative approach------------
        /*
        List <Person> female = new ArrayList<>();
        for (Person person : people){
            if (person.getgender().equals(Gender.FEMALE)){
                female.add(person);
            }
        }
        female.forEach(System.out::println);
         */

        //-----------Declarative approach----------------

        //Filter - Finding female in the list
        List<Person> females = people.stream() // " -> " means predicate which returns true or false
                .filter(person -> person.getgender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        //females.forEach(System.out::println);

        //Sort - sorting age
        List<Person> agesorted = people.stream()
                .sorted(Comparator.comparing(Person::getage).thenComparing(Person::getgender).reversed())
                .collect(Collectors.toList());
        //agesorted.forEach(System.out::println);

        //All match
        boolean matching = people.stream().allMatch(Person -> Person.getage() > 5);
        //System.out.println(matching);

        //Any match
        boolean anymatching = people.stream().anyMatch(Person -> Person.getage() > 5);
        //System.out.println(anymatching);

        //None match
        boolean nonematching = people.stream()
                .noneMatch(person -> person.getname().equals("Long"));
        // System.out.println(nonematching);

        //Max
        people.stream().max(Comparator.comparing(person -> person.getage()));
        //    .ifPresent(System.out::println);
        //Min
        people.stream().min(Comparator.comparing(person -> person.getage()));
        //   .ifPresent(System.out::println);

        //Group
        Map<Gender, List<Person>> groupbyGender = people.stream().collect(Collectors.groupingBy(Person::getgender));
        groupbyGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

    }

    private static List<Person> peoplelist() {
        return List.of(
                new Person("James", 30, Gender.MALE),
                new Person("Katherine", 31, Gender.FEMALE),
                new Person("Michelle", 1, Gender.FEMALE),
                new Person("Paul", 2, Gender.MALE)
        );
    }
}

