import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static User method(List<User> userList) {
        return userList.stream()
                .distinct()
                .sorted(Comparator.comparingInt(User::getAge)
                        .reversed()
                        .thenComparing(User::getName))
                .findFirst()
                .orElse(null);
    }
}
