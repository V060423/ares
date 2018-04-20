import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableFeignClients({"com.study.cloud.service"})
@ComponentScan(value ={
		"com.study.cloud.web",
		"com.study.cloud.fallback"})
@SpringBootApplication
public class AresServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AresServiceConsumerApplication.class, args);
	}
}
