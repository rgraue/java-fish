package fishapp.controllers;

// import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FishController {
    
    @RequestMapping("/api")
    public String Home () {
        System.out.println("hit /api");
        return "hello world";
    }

    @RequestMapping("/api/fish")
    public String fish () {
        return "hello from fish";
    }

    @RequestMapping("/api/fish/{id}")
    public String fishId (@PathVariable String id) {
        return String.format("Hello from frish: %s", id);
    }
}
