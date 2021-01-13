package Homework.PenguinColonies;

public class Penguin {
    private final int birthYear;
    private final String name;
    private final Gender gender;
    private Fish favoriteFish;

    public Penguin(int birthYear, String name, Gender gender, Fish favoriteFish) {
        this.birthYear = birthYear;
        this.name = name;
        this.gender = gender;
        this.favoriteFish = favoriteFish;
    }

    public boolean equals(Object other) {
        Penguin peng = (Penguin) other;
        if (peng.getName() == null || peng.getGender() == null) return false;
        return birthYear == peng.getBirthYear() && name.equals(peng.getName()) && gender.equals(peng.getGender());
    }

    public int hashCode() {
        return birthYear / name.length() + 1007;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Fish getFavoriteFish() {
        return favoriteFish;
    }

    public void setFavoriteFish(Fish favoriteFish) {
        this.favoriteFish = favoriteFish;
    }

}
