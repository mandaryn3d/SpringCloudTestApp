package pl.umcs;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.umcs.datatypes.Assignment;
import pl.umcs.datatypes.Employee;
import pl.umcs.datatypes.Holiday;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/service")
public class CheckerController {

    private String defaultNamePath = "/service";
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getHello() {
        return "This is core app.";
    }

    @GetMapping("/check")
    public String checkApps() {
        Application clientApplication
                = eurekaClient.getApplication("client");
        Application consumerApplication
                = eurekaClient.getApplication("konsumer");


        return restTemplate.getForObject(getUrl(clientApplication, defaultNamePath), String.class) + "\n" +
                restTemplate.getForObject(getUrl(consumerApplication, defaultNamePath), String.class);
    }

    @GetMapping("/trigger")
    public String triggerDataSend() {
        Application clientApplication
                = eurekaClient.getApplication("client");

        //restTemplate.getForObject(getUrl(clientApplication, defaultNamePath + "/fill"), String.class);

        ResponseEntity<Employee> steve = restTemplate.getForEntity(getUrl(clientApplication, defaultNamePath+"/1"), Employee.class);
        Holiday holidayForSteve = new Holiday();

        holidayForSteve.setEmployee(steve.getBody());
        holidayForSteve.setLength(7);
        holidayForSteve.setStartDate(new Date(2018, 12, 22));
        ResponseEntity<String> newSteve = restTemplate.postForEntity(getUrl(clientApplication, defaultNamePath+"/holiday"),holidayForSteve,String.class);
        return "Some holidays were requested for " + newSteve.getBody();
    }

    private String getUrl(Application application, String path) {
        List<InstanceInfo> instances = application.getInstances();
        InstanceInfo instanceInfo = instances.iterator().next();
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        return "http://"+hostname+":"+port+path;
    }
}
