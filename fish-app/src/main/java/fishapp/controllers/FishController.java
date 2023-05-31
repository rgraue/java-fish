package fishapp.controllers;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class FishController {

    @Autowired
    private  WebClient CLIENT;

    @Autowired
    private  Logger LOG;
    
    @GetMapping
    public String Home () {
        this.LOG.info("hit /api");
        return "hello world";
    }

    @GetMapping
    @RequestMapping("/fish")
    public String fish () {
        this.LOG.info("hit /api/fish");
        return "hello from fish";
    }

    @GetMapping
    @RequestMapping("/{id}")
    public String fishId (@PathVariable String id) {
        this.LOG.info(String.format("hit /api/fish/%s", id));
        return String.format("Hello from frish: %s", id);
    }

    @Async
    @GetMapping
    @RequestMapping("/async")
    public CompletableFuture asyncExample () {
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
