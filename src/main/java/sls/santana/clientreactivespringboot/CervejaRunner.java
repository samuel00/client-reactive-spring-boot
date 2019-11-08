package sls.santana.clientreactivespringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import sls.santana.clientreactivespringboot.client.CervejaClient;
import sls.santana.clientreactivespringboot.modelo.Cerveja;

@Component
public class CervejaRunner implements CommandLineRunner {

    private final CervejaClient cervejaClient;

    public CervejaRunner(CervejaClient cervejaClient) {
        this.cervejaClient = cervejaClient;
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<Cerveja> cervejaFlux = this.cervejaClient.getCervejaStream();

        cervejaFlux.subscribe(System.out::println);
    }
}
