import java.util.List;
import java.util.stream.Collectors;

public class CityFilter {
    public static void main(String[] args) {
        // city file reader instance to read the file
        CityFileReader cityFileReader = new CityFileReader("src/world-cities.csv");
        List<String> cities = cityFileReader.readCities(0); // Adjust index for your city column

        // Use streams to filter, transform, sort
        String result = cities.stream()
                // Filter out cities that start with 'B'
                .filter(city -> city.startsWith("B"))
                // Uppercase the cities
                .map(String::toUpperCase)
                // Sort the cities alphabetically
                .sorted()
                // single string separated by commas
                .collect(Collectors.joining(", "));

        // Output the result
        System.out.println("Cities after filtering 'B': ");
        System.out.println(result);
    }
}
