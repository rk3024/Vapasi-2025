public class Processor {
    private String gen;
    private int ghz;

    Processor(){
        System.out.println("Setting up Processor");
    }
    public String gen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getGhz() {
        return ghz;
    }

    public void setGhz(int ghz) {
        this.ghz = ghz;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "gen=" + gen +
                ", ghz=" + ghz +
                '}';
    }
}
