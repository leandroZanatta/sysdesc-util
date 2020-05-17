package br.com.sysdesc.util.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChaveValorParametroHTML {

    private String descricao;

    private Map<String, String> parametro;
}
