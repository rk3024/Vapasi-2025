public class Ram {
    private int ramsize;
    private String type;

    Ram(){
        System.out.println("Setting up RAM");
    }
    public int getRamsize() {
        return ramsize;
    }

    public void setRamsize(int ramsize) {
        this.ramsize = ramsize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "ramsize=" + ramsize +
                ", type='" + type + '\'' +
                '}';
    }
}
