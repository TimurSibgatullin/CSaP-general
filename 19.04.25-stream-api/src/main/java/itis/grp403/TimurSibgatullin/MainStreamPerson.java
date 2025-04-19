package itis.grp403.TimurSibgatullin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.SocketHandler;
import java.util.stream.Collectors;

public class MainStreamPerson {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        initPersonList(persons);
        //find youngest
        Optional<Person> person = persons.stream().min((p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println(person.get());
        System.out.println(person.orElse(new Person("New", 0)));
        //print all names with capital letter
        persons
                .stream() // Stream<Person>
                .map(p -> p.getName().toUpperCase())
                .sorted()
                .toList()
                .forEach(System.out::println);

//        List<Person> persons = new ArrayList<>();
//
//        initPersonList(persons);
//        // Получить младшего из людей
//        Person little = persons
//                .stream()
//                .min((p1,p2) -> p1.getAge() - p2.getAge()).get();
//
//        System.out.println(little);
//
//        // Получить список имен людей в верхнем регистре
//        List<String> names = persons.stream() // обратились к "потоку"
//                .map(p -> p.getName().toUpperCase()) // описали преобразование элементов
//                .collect(Collectors.toList()); // терминальный метод - создание новой коллекции
//
//        Consumer<String> consumer = s -> System.out.println(s);
//
//        names.stream().forEach(System.out::println);
//
//        long size = persons
//                .stream()
//                .count();
//        System.out.println(size);
//
//        List<Person> pNamePersons = persons
//                .stream()
//                .filter(s -> s.getName().charAt(0) == 'П')
//                .toList();
//        System.out.println(pNamePersons);
//
//        List<Integer> lenNames = persons
//                .stream()
//                .map(s -> s.getName().length())
//                .distinct()
//                .toList();
//        System.out.println(lenNames);
//        persons.stream()
//                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
//                .toList().forEach(System.out::println);
    }

    private static void initPersonList(List<Person> persons) {
        persons.add(new Person("Пушкин", 30));
        persons.add(new Person("Гоголь", 43));
        persons.add(new Person("Маяковский", 21));
        persons.add(new Person("Есенин", 18));
        persons.add(new Person("Паустовский", 24));
        persons.add(new Person("Толстой", 70));
        persons.add(new Person("Достоевский", 25));
    }
}