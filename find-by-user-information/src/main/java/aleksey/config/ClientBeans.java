package aleksey.config;

import aleksey.client.UserClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {


    @Bean
    public UserClientImpl productsRestClient(
            @Value("${userinfo.base-uri}") String catalogueBaseUri,
            LoadBalancerClient balancerClient) {
        return new UserClientImpl(RestClient.builder()
                .baseUrl(catalogueBaseUri)
                .requestInterceptor(new LoadBalancerInterceptor(balancerClient))
                .build());
    }
}
