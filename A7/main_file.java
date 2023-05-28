// import java.util.ArrayList;
import java.util.HashMap;
// import java.util.List;
import java.util.Map;
import java.util.Random;


class URLService{
    // String chars = "abcdef";
    Random random = new Random();
    // List<String> urls = new ArrayList<>();
    Map<String, String> hashMap = new HashMap<>();
    
    // public void fillUrls(){
    //     for(int i = 0; i < 1000; i++){
    //         urls.add(generateUrl(""));
    //     }
    // }

    public String generateUrl(String oUrl){
        // Uncomment this to check the retrieved from the hashmap part:
        // hashMap.put("https://www.youtube.com/watch?v=2Gik4bFYJbM&ab_channel=Telusko", "telus.ko/bbcdfa");

        if (hashMap.containsKey(oUrl)){
            System.out.println("\nRetrieved...");
            return hashMap.get(oUrl);
        }
        
        else{
            String sUrl = "";
            // Assignment point number 3:
            String withoutHttps = oUrl.replaceFirst("^https://", "");
            String withoutWWW = withoutHttps.replaceFirst("^www.", "");
            String chars = withoutWWW.replaceAll("[^a-zA-Z0-9]", "");
            StringBuilder sb = new StringBuilder();
            int idx = 0;

            for (int i = 0; i < 6; i++){
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


class Main{
    public static void main(String[] args) throws Exception{
        // System.out.println("\nTest");
        String oUrl = "https://www.youtube.com/watch?v=2Gik4bFYJbM&ab_channel=Telusko";

        // Expected output: telus.ko/bbcdfa
        String sUrl = "";

        URLService service = new URLService();
        // do{
        //     sUrl = service.generateUrl(oUrl);
        //     System.out.println("\nCreated...");
        // }while(service.urls.contains(sUrl));
        sUrl = service.generateUrl(oUrl);

        System.out.println(sUrl);
    }
}