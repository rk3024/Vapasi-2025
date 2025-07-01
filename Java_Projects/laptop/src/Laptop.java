public class Laptop {
    Processor processor;
    Ram ram;
    Harddisk hdd;
    String logo;

    Laptop(){

    }
    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Harddisk getHdd() {
        return hdd;
    }

    public void setHdd(Harddisk hdd) {
        this.hdd = hdd;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "processor=" + processor.toString() +
                ", ram=" + ram.toString() +
                ", hdd=" + hdd.toString() +
                ", logo='" + logo + '\'' +
                '}';
    }
}
