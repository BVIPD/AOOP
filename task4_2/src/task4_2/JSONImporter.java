package task4_2;

public class JSONImporter extends DataImporter {
    @Override
    protected void parseData() {
        System.out.println("Parsing JSON data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving JSON data to database...");
    }
}