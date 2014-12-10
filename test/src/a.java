
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
 
/**
 * GetSearchResultTest
 *
 * @author Eugene Matyushkin aka Skipy
 * @since 19.10.2011
 */
public class a {
 
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://vk.com/id13537567");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
    }
}