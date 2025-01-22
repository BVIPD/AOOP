package task4_2;

public class CSVImporter extends DataImporter {
    @Override
    protected void parseData() {
        System.out.println("Parsing CSV data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving CSV data to database...");
    }
}
