package fishapp.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;

import fishapp.models.Fish;
import fishapp.services.FishService;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class FishController {

    @Autowired
    private WebClient CLIENT;

    @Autowired
    private Logger LOG;

    @Autowired
    private FishService fishService;


    @GetMapping("/")
    public String Home() {
        this.LOG.info("hit /api");
        return "hello world";
    }

    @GetMapping("/fish")
    public String getFish() {
        this.LOG.info("hit /api/fish");
        List<Fish> allFish = this.fishService.getAllFish();

        allFish.forEach(fish -> {
            LOG.info(fish.toString());
        });
        return "hello from fish";
    }

    @PutMapping("/fish")
    public String putFish (@RequestBody String name) {
        this.LOG.info("Creating fish");
        Fish result = this.fishService.createFish(name);

        return result.toString();

        // return "hit";
    }



    @GetMapping("fish/{id}")
    public String getFishId(@PathVariable String id) {
        this.LOG.info(String.format("hit /api/fish/%s", id));
        return String.format("Hello from frish: %s", id);
    }

    @Async
    @GetMapping("/async")
    public CompletableFuture<Mono<String>> asyncExample() {
        this.LOG.info("starting async example");
        String url = "https://api.instantwebtools.net/v1/airlines/1";

        Mono<String> response = this.CLIENT
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);

        this.LOG.info("Retraived response???");

        return CompletableFuture.completedFuture(response);
    }
}
