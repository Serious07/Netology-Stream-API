import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Формируем случайный список людей
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        // 1. Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        long numberOfMinors = persons.parallelStream().
                                    filter(person -> person.getAge() < 18).
                                    count();
        // 2. Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List<String> listOfFamily = persons.parallelStream().
                                    filter(person -> person.getAge() >= 18 && person.getAge() < 27).
                                    map(Person::getFamily).
                                    collect(Collectors.toList());
        // 3. Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в
        // выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        List<Person> listOfPersons = persons.parallelStream().
                                    filter(person ->
                                            (
                                            (person.getSex() == Sex.MAN &&
                                            person.getAge() >= 18 && person.getAge() < 65 &&
                                            person.getEducation() == Education.HIGHER) ||

                                            (person.getSex() == Sex.WOMAN &&
                                            person.getAge() >= 18 && person.getAge() < 60 &&
                                            person.getEducation() == Education.HIGHER)
                                            )
                                    ).
                                    sorted(Comparator.comparing(Person::getFamily)).
                                    collect(Collectors.toList());

        // Вывод данных
        // 1
        // System.out.println("Количество несовершеннолетних (т.е. людей младше 18 лет): " + numberOfMinors);

        // 2
        // System.out.println("Список найденных фамилий:");
        // listOfFamily.parallelStream().forEachOrdered(family -> { System.out.println(family); });

        // 3
        // System.out.println("Список подходящих людей (" + listOfPersons.size() + "):");
        // listOfPersons.parallelStream().forEachOrdered(person -> { System.out.println(person.toString());});
    }
}
