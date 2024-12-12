public class Funcionario {
    private String nome;
    private float salarioBruto;
    private float totalAcrescimos;
    private float totalDescontos;

    public Funcionario(String nome, float salarioBruto, float totalAcrescimos, float totalDescontos) {
        this.nome = nome;
        setSalarioBruto(salarioBruto);
        setTotalAcrescimos(totalAcrescimos);
        setTotalDescontos(totalDescontos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        if (salarioBruto < 0) {
            throw new IllegalArgumentException("Salario invalido");
        }
        if (salarioBruto < 1_412.00F) {
            throw new IllegalArgumentException("Salario abaixo do minimo");
        }
        this.salarioBruto = salarioBruto;
    }

    public float getTotalAcrescimos() {
        return totalAcrescimos;
    }

    public void setTotalAcrescimos(float totalAcrescimos) {
        if (totalAcrescimos < 0) {
            throw new IllegalArgumentException("Total de acrescimos invalido");
        }
        this.totalAcrescimos = totalAcrescimos;
    }

    public float getTotalDescontos() {
        return totalDescontos;
    }

    public void setTotalDescontos(float totalDescontos) {
        if (totalDescontos < 0) {
            throw new IllegalArgumentException("Total de descontos invalido");
        }
        this.totalDescontos = totalDescontos;
    }

    public float calculaSalarioLiquido() {
        if (totalDescontos > (this.getSalarioBruto()+this.getTotalAcrescimos())) {
            throw new IllegalArgumentException("Total de descontos nao pode sobrepassar ao recebido.");
        }
        return (this.getSalarioBruto()+this.getTotalAcrescimos()-this.getTotalDescontos());
    }
}
