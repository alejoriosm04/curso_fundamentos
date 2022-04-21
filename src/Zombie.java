public class Zombie extends Main {
    private String nameZ;
    private int health;
    private int year;
    private String bloodType;
    private int infectedPeople;

    public Zombie(String n, int h, int y, String b, int i) {
        this.nameZ = n;
        this.health = h;
        this.year = y;
        this.bloodType = b;
        this.infectedPeople = i;
    }

    public void setNameZ(String n) {
        this.nameZ = n;
    }

    public String getNameZ() {
        return this.nameZ;
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public int getHealth() {
        return this.health;
    }

    public void setYear(int y) {
        this.year = y;
    }

    public int getYear() {
        return this.year;
    }

    public void setBloodType(String b) {
        this.bloodType = b;
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setInfectedPeople(int i) {
        this.infectedPeople = i;
    }

    public int getInfectedPeople() {
        return this.infectedPeople;
    }
}