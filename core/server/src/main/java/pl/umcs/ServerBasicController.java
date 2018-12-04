package pl.umcs;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServerBasicController {

    @GetMapping
    public String getHello() {
        return "Hello, I am the server.";
    }

}
