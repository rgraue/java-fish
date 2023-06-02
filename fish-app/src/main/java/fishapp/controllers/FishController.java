package fishapp.controllers;

import java.util.List;

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
    public String Home() {
        this.logger.info("hit /api");
        return "hello world";
    }

    @GetMapping("/fish")
    public String getFish() {
        this.logger.info("hit /api/fish");
        List<Fish> allFish = this.fishService.findAll();

        final String result = "";

        allFish.forEach(fish -> {
            result.concat(fish.toString());
        });

        return result;
    }

    @PutMapping("/fish")
    public String putFish(@RequestBody String name) {
        this.logger.info("Creating fish");

        Fish dto = new Fish("test species");
        dto.setId(UUID.getUUID());

        Fish result = this.fishService.save(dto);

        return result.toString();
    }

    @GetMapping("fish/{id}")
    public String getFishId(@PathVariable String id) {
        this.logger.info(String.format("finding fish: %s", id));
        Fish fish = fishService.findByID(Integer.parseInt(id)).get();

        return fish.toString();
    }
}
