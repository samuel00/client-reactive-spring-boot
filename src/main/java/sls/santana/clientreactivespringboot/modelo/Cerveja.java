package sls.santana.clientreactivespringboot.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cerveja{

    private String id;
    private String nome;
    private String fabricante;
    private String tipo;
}