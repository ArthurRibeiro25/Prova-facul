package classes;

public class Professor extends Pessoa {
    
    private int func_cod;

    public Professor(){
        
    }  
    
    public int getFunc_cod() {
        return func_cod;
    }

    public void setFunc_cod(int func_cod) {
        this.func_cod = func_cod;
    }
    
    public String listaIDnome(){
        return "Codigo de funcionário: " + func_cod + super.retornaNome();
    }

    @Override
    public String toString() {
        String msg = "Professor: \n\nCodigo de funcionario: " + func_cod;
        return msg + super.toString();
    }
    
    
}
