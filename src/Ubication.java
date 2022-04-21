public class Ubication extends Main {
    private String nameU;
    private float distance;
    private int numberZombies;
    public Ubication(String n, float d, int nz) {
        this.nameU = n;
        this.distance = d;
        this.numberZombies = nz;
    }
    public void setNameU(String n) {
        this.nameU = n;
    }

    public String getNameU() {
        return this.nameU;
    }

    public void setDistance(float d) {
        this.distance = d;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setNumberZombies(int nz) {
        this.numberZombies = nz;
    }

    public int getNumberZombies() {
        return this.numberZombies;
    }
}