import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityFileReader {
    private String filePath;

    public CityFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readCities(int cityColumnIndex) {
        List<String> cities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // Adjust delimiter if necessary
                if (cityColumnIndex < columns.length) {
                    cities.add(columns[cityColumnIndex].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public static void main(String[] args) {
        // Example usage
        CityFileReader cityFileReader = new CityFileReader("src/world-cities.csv");
        List<String> cities = cityFileReader.readCities(1); // Adjust index for your city column
        System.out.println("Cities: " + cities);
    }
}

