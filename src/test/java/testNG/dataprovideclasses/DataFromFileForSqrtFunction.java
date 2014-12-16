package testNG.dataprovideclasses;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataFromFileForSqrtFunction {
    public static Object[][] readFromFile(String path) {
        ArrayList<HashMap<String, String>> map = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            Yaml yaml = new Yaml();
            map = (ArrayList<HashMap<String, String>>)yaml.load(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] testData = new Object[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            testData[i][0] = map.get(i).get("firstValue");
            testData[i][1] = map.get(i).get("expectedResult");
        }

        return testData;
    }
}
