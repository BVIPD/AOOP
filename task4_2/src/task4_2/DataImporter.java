package task4_2;

	public abstract class DataImporter {
	    public void importData(String filePath) {
	        readData(filePath);
	        parseData();
	        validateData();
	        saveData();
	    }

	    protected void readData(String filePath) {
	        System.out.println("Reading data from file: " + filePath);
	    }

	    protected abstract void parseData();

	    protected void validateData() {
	        System.out.println("Validating the data...");
	    }

	    protected abstract void saveData();
	}
