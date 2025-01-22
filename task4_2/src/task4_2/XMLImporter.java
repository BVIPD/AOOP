package task4_2;

public class XMLImporter extends DataImporter {
    @Override
    protected void parseData() {
        System.out.println("Parsing XML data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving XML data to database...");
    }
}