import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void naoDeveDefinirSalarioNegativo() {
        try{
            Funcionario f = new Funcionario("Rebecca",1_412.0F,0F,0F);
            f.setSalarioBruto(-1F);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Salario invalido", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirSalarioAbaixoMinimo() {
        try{
            Funcionario f = new Funcionario("Rebecca",1_412.0F,0F,0F);
            f.setSalarioBruto(1_411.0F);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Salario abaixo do minimo", e.getMessage());
        }
    }

    @Test
    void deveDefinirSalarioMinimo(){
        Funcionario f = new Funcionario("Rebecca",1_413.0F,0F,0F); // um a mais para verificar que a troca foi realmente feita
        f.setSalarioBruto(1_412.0F);
        assertEquals(1_412.0F, f.getSalarioBruto());
    }

    @Test
    void naoDeveDefinirAcrescimoNegativo() {
        try{
            Funcionario f = new Funcionario("Rebecca",1_412.0F,0F,0F);
            f.setTotalAcrescimos(-1F);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Total de acrescimos invalido", e.getMessage());
        }
    }

    @Test
    void deveDefinirAcrescimoZero(){
        Funcionario f = new Funcionario("Rebecca",1_412.0F,1F,0F); // um a mais para verificar que a troca foi realmente feita
        f.setTotalAcrescimos(0F);
        assertEquals(0F, f.getTotalAcrescimos());
    }

    @Test
    void naoDeveDefinirDescontoNegativo() {
        try{
            Funcionario f = new Funcionario("Rebecca",1_412.0F,0F,0F);
            f.setTotalDescontos(-1F);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Total de descontos invalido", e.getMessage());
        }
    }

    @Test
    void deveDefinirDescontoZero(){
        Funcionario f = new Funcionario("Rebecca",1_412.0F,0F,1F); // um a mais para verificar que a troca foi realmente feita
        f.setTotalDescontos(0F);
        assertEquals(0F, f.getTotalDescontos());
    }

    @Test
    void naoDeveCalcularLiquidoInvalido(){
        try{
            Funcionario f = new Funcionario("Rebecca",1_412.0F,0F,1_413.0F);
            f.calculaSalarioLiquido();
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Total de descontos nao pode sobrepassar ao recebido.", e.getMessage());
        }
    }

    @Test
    void deveCalcularLiquidoVALIDO(){
        Funcionario f = new Funcionario("Rebecca",1_412.0F,0F,1_411.0F);
        assertEquals(f.calculaSalarioLiquido(),1.0F);
    }
}