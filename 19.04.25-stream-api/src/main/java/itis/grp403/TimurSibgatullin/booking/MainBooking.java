package itis.grp403.TimurSibgatullin.booking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainBooking {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Bookings bookings = mapper.readValue(new File("bookings.json"), Bookings.class);
//        printCount(bookings);
//        printCountWomen(bookings);
//        fromMoscow(bookings);
//        printChild(bookings);
//        printHotel(bookings);

//        printFemaleHotelBookings(bookings);
//        printMaleHotelBookings(bookings);
//        printSamaraHotelBookings(bookings);
//        printFourty(bookings);
//        printTownBookings(bookings);
//        printMapHotel(bookings);
        printUniqPeoples(bookings);
    }

    public static void printCount(Bookings bookings) {
        System.out.println(
                bookings
                    .getBookings()
                    .stream()
                    .count()
        );
    }

    public static void printCountWomen(Bookings bookings) {
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .filter(b -> b.getPerson().getGender() != null)
                        .filter(b -> b.getPerson().getGender().equals("Female"))
                        .count()
        );
    }

    public static void fromMoscow(Bookings bookings) {
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .filter(b -> b.getPerson().getFromcity().contains("Москва"))
                        .count()
        );
    }

    public static void printChild(Bookings bookings) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2011-04-23");
            bookings
                    .getBookings()
                    .stream()
                    .filter(p -> p.getPerson().getBirthdate() != null)
                    .filter(p -> p.getPerson().getBirthdate().after(date))
                    .map(b -> b.getPerson())
                    .toList()
                    .forEach(System.out::println);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    public static void printHotel(Bookings bookings) {
        Map<String, Integer> result = bookings
                .getBookings()
                .stream()
                .collect(Collectors.toMap(
                        b -> b.getHotel().getName(),
                        b -> 1,
                        (x, y) -> x+y));
        result.entrySet()
                .stream().
                forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }


    //1. Вывести список гостиниц и кол-во бронирований женщинами
    public static void printFemaleHotelBookings(Bookings bookings) {
        Map<String, Integer> result = bookings
                .getBookings()
                .stream()
                .filter(p -> p.getPerson().getGender() != null)
                .filter(p -> p.getPerson().getGender().equals("Female"))
                .collect(Collectors.toMap(
                        b -> b.getHotel().getName(),
                        b -> 1,
                        (x, y) -> x+y));
        result.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    //2. Вывести список гостиниц и кол-во бронирований мужчинами
    public static void printMaleHotelBookings(Bookings bookings) {
        Map<String, Integer> result = bookings
                .getBookings()
                .stream()
                .filter(p -> p.getPerson().getGender() != null)
                .filter(p -> p.getPerson().getGender().equals("Male"))
                .collect(Collectors.toMap(
                        b -> b.getHotel().getName(),
                        b -> 1,
                        (x, y) -> x+y));
        result.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    //3. Вывести процент бронирований из Самарской области
    public static void printSamaraHotelBookings(Bookings bookings) {
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .filter(b -> b.getPerson().getFromcity().equals("Самарская область, г Самара"))
                        .count() * 100 /

                bookings
                        .getBookings()
                        .stream()
                        .count()
        );
    }

    //4. Вывести процент бронирований людьми в возрасте от 40 до 45 лет
    public static void printFourty(Bookings bookings) {
        try {
            Date dateAfter = new SimpleDateFormat("yyyy-MM-dd").parse("1980-04-24");
            Date dateBefore = new SimpleDateFormat("yyyy-MM-dd").parse("1985-04-24");
            System.out.println(
                    bookings
                    .getBookings()
                    .stream()
                    .filter(p -> p.getPerson().getBirthdate() != null)
                    .filter(p -> p.getPerson().getBirthdate().after(dateAfter))
                    .filter(p -> p.getPerson().getBirthdate().before(dateBefore))
                    .count() * 100 /

                            bookings
                                    .getBookings()
                                    .stream()
                                    .count()
            );
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    //5. Вывести список городов и кол-во бронирований по ним (город ~ г ...)
    public static void printTownBookings(Bookings bookings) {
        Map<String, Integer> result = bookings
                .getBookings()
                .stream()
                .filter(p -> p.getPerson().getFromcity() != null)
                .collect(Collectors.toMap(
                        p -> p.getPerson().getFromcity(),
                        b -> 1,
                        (x, y) -> x+y));
        result.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + "    bookings count: " + e.getValue()));
    }


    //6. Сформировать Map ключ - гостиница, значение - список городов
    public static void printMapHotel(Bookings bookings) {
        Map<String, ArrayList<String>> result = bookings
                .getBookings()
                .stream()
                .collect(Collectors.toMap(
                        b -> b.getHotel().getName(),
                        b -> {
                            ArrayList<String> res = new ArrayList<>();
                            res.add(b.getHotel().getName());
                            return res;
                        },
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }));
        result.entrySet()
                .stream().
                forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
    //7. Вывести процент уникальных людей (необходимо описать эквивалентность по полу, дате рождения)
    public static void printUniqPeoples(Bookings bookings) {
        class PersonKey {
            String gender;
            Date birthdate;
            public PersonKey(String gender, Date birthdate) {
                this.gender = gender;
                this.birthdate = birthdate;
            }
        }
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .map(b -> new PersonKey(
                                b.getPerson().getGender(),
                                b.getPerson().getBirthdate()
                        ))
                        .distinct() // оставляет только уникальные PersonKey
                        .count() * 100 /
                        bookings
                                .getBookings()
                                .stream()
                                .count()

        );
    }
}
