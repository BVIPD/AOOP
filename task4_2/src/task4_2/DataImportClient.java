package task4_2;

public class DataImportClient {
    public static void main(String[] args) {
        String csvFile = "data.csv";
        String xmlFile = "data.xml";
        String jsonFile = "data.json";

        DataImporter csvImporter = new CSVImporter();
        DataImporter xmlImporter = new XMLImporter();
        DataImporter jsonImporter = new JSONImporter();

        System.out.println("\nImporting CSV data:");
        csvImporter.importData(csvFile);

        System.out.println("\nImporting XML data:");
        xmlImporter.importData(xmlFile);

        System.out.println("\nImporting JSON data:");
        jsonImporter.importData(jsonFile);
    }
}
