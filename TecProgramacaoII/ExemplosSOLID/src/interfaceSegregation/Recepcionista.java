package interfaceSegregation;

import java.math.BigDecimal;

public class Recepcionista implements Funcionario {

    @Override
    public BigDecimal salario() {
        return new BigDecimal("2500");
    }
/* 
    @Override
    public BigDecimal gerarComissao() {
        return BigDecimal.ZERO;
    }
 */
}
