package fishapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import fishapp.models.Fish;
import fishapp.services.FishService;
import fishapp.utils.UUID;

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
    public String getRoot() {
        this.logger.info("hit /api");
        return "hello world";
    }

    @GetMapping("/fish")
    public String getFish() {
        this.logger.info("getting all fish");
        List<Fish> allFish = this.fishService.findAll();

        StringBuilder s = new StringBuilder();

        allFish.forEach(fish -> {
            s.append(fish.toString());
        });

        return s.toString();
    }

    @PutMapping("/fish")
    public String putFish(@RequestBody @Valid Fish fish) {
        this.logger.info("Creating fish");
        this.logger.info(fish.toString());

        fish.setId(UUID.getUUID());

        Fish result = this.fishService.save(fish);

        return result.toString();
    }

    @GetMapping("fish/{id}")
    public String getFish(@PathVariable String id) {
        this.logger.info(String.format("finding fish: %s", id));
        Fish fish = fishService.findByID(Integer.parseInt(id)).get();

        return fish.toString();
    }
}
