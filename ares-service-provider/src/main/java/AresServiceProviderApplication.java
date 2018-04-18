import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableEurekaClient
@EnableFeignClients({"com.study.cloud.service"})
@SpringBootApplication
@ComponentScan("com.study.cloud.repository")
public class AresServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AresServiceProviderApplication.class, args);
	}
}
