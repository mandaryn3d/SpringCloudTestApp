package pl.umcs;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ConsumerBasicController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getHello() {
        return "Consumer standing by.";
    }

    @GetMapping("/dajGlos")
    public String dajGlos() {
        Application application
                = eurekaClient.getApplication("client");
        List<InstanceInfo> instances = application.getInstances();
        InstanceInfo instanceInfo = instances.iterator().next();
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        return restTemplate.getForObject(
                "http://"+hostname+":"+port+"/service/name", String.class) + " Roxx!";
    }

}
