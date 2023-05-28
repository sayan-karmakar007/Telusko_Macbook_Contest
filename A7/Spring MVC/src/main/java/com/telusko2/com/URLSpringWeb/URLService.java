import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class URLService {
    Random random = new Random();
    Map<String, String> hashMap = new HashMap<>();

    public String generateUrl(String oUrl) {
        if (hashMap.containsKey(oUrl)) {
            System.out.println("\nRetrieved...");
            return hashMap.get(oUrl);
        } else {
            String sUrl = "";
            String withoutHttps = oUrl.replaceFirst("^https://", "");
            String withoutWWW = withoutHttps.replaceFirst("^www.", "");
            String chars = withoutWWW.replaceAll("[^a-zA-Z0-9]", "");
            StringBuilder sb = new StringBuilder();
            int idx = 0;

            for (int i = 0; i < 6; i++) {
                idx = random.nextInt(chars.length());
                sb.append(chars.charAt(idx));
            }

            sUrl = sb.toString();
            hashMap.put(oUrl, "telus.ko/" + sUrl);

            System.out.println("\nGenerated...");
            return "telus.ko/" + sUrl;
        }
    }
}
