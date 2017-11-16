package ar.edu.unlam.tallerweb1.modelo;

public class Nota {

	private Double nota1;

	public Nota(Double nota1)throws Exception{
		if(nota1!=null && nota1<=10 && nota1 >= 1){
			this.nota1 = nota1;
		}else{
			throw new Exception();
		}
	}
    //ESTE MÉTODO LO QUE HACE ES QUE PUEDA MODIFICAR EL ESTADO DE LA NOTA, TIPO SET
	public void recuperar(Double nota1) {
		
		
		
		//Integer contador=0;
		
	}

	public Boolean estaAprobado() {
		
		//es como un if, más simplificado, esto va a dar true;
		return this.nota1>=4;
	}

	public Boolean estaPromocionada() {
		
		return this.nota1>=4&&this.nota1<=7;

	}
	
	public Double valor(){
		return this.nota1;
	}
}