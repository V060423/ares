import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients({"com.study.cloud.service"})
@SpringBootApplication(scanBasePackages = {
		"com.study.cloud.web",
		"com.study.cloud.fallback"
})
public class AresServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AresServiceConsumerApplication.class, args);
	}
}
