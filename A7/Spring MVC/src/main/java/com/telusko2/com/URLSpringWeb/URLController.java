import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urls")
public class URLController {

    @Autowired
    private URLService urlService;

    @GetMapping("/generate")
    public String generateShortURL(@RequestParam String oUrl) {
        return urlService.generateUrl(oUrl);
    }
}