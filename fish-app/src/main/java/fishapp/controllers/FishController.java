package fishapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import fishapp.models.Fish;
import fishapp.services.FishService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class FishController {

    private Logger logger;
    private FishService fishService;

    @Autowired
    public FishController(FishService fishService, Logger logger) {
        this.fishService = fishService;
        this.logger = logger;
    }


    @GetMapping("/")
    public String Home() {
        this.logger.info("hit /api");
        return "hello world";
    }

    @GetMapping("/fish")
    public String getFish() {
        this.logger.info("hit /api/fish");
        List<Fish> allFish = this.fishService.getAllFish();

        allFish.forEach(fish -> {
            logger.info(fish.toString());
        });
        return "hello from fish";
    }

    @PutMapping("/fish")
    public String putFish (@RequestBody String name) {
        this.logger.info("Creating fish");
        Fish result = this.fishService.createFish(name);

        return result.toString();

        // return "hit";
    }



    @GetMapping("fish/{id}")
    public String getFishId(@PathVariable String id) {
        this.logger.info(String.format("hit /api/fish/%s", id));
        return String.format("Hello from frish: %s", id);
    }
}
