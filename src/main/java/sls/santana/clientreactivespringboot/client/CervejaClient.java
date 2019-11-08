package sls.santana.clientreactivespringboot.client;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import sls.santana.clientreactivespringboot.modelo.Cerveja;

@Slf4j
@Setter
@Component
@ConfigurationProperties("sml")
public class CervejaClient {

    private final static String DOUBLE_QUOTE = ":";
    private String protocol;
    private String host;
    private String port;
    private String path;

    public Flux<Cerveja> getCervejaStream() {

        String url = this.protocol
                + this.host
                + DOUBLE_QUOTE
                + this.port;

        log.debug("Url de acesso: " + url);

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .uri(this.path)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMapMany(res -> res.bodyToFlux(Cerveja.class));
    }
}
