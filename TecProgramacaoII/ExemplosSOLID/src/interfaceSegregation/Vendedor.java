package interfaceSegregation;

import java.math.BigDecimal;

public class Vendedor implements Funcionario, Comissionavel {

    @Override
    public BigDecimal salario() {
        return new BigDecimal("3000");
    }

    @Override
    public BigDecimal gerarComissao() {
        return new BigDecimal("500");
    }

}
