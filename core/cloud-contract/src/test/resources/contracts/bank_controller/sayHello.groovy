package contracts.greeting_controller
import org.springframework.cloud.contract.spec.Contract
Contract.make {
    request {
        method 'GET'
        url("/hello")
    }
    response {
        status 200
        body("Hello. This is bank.")
        headers {
            header('Content-Type': value(
                    producer(regex('text/plain;charset=ISO-8859-1')),
                    consumer('text/plain;charset=ISO-8859-1')
            ))
        }
    }
}