public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //Es la maquina con premio
    private boolean billeteConPremio;
    //Numero billetes que se pueden vender
    private int numeroBillete;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino , boolean billetePremiado, int numBilleteAVender) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billeteConPremio = billetePremiado;
        numeroBillete = numBilleteAVender;

    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }

    }

   /**
   * Imprime un billete para el cliente actual
   */
    public void imprimirBillete() {
        if ( numeroBillete > 0){
           if (billeteConPremio == true ){
               if (balanceClienteActual >= precioBillete){
                   System.out.println("##################");
                   System.out.println("# Billete de tren:");
                   System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                   System.out.println("# " + precioBillete + " euros.");
                   System.out.println("##################");
                   System.out.println("");
                   System.out.println("");
                   System.out.println("");
                   System.out.println("");
                   System.out.println("##################");
                   System.out.println("# Billete de tren de regalo:");
                   System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                   System.out.println("Gratuito");
                   System.out.println("##################");
                   System.out.println("");
                   System.out.println("");
                   // Actualiza el total de dinero acumulado en la maquina
                   totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                   // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                   balanceClienteActual = balanceClienteActual - precioBillete;
                   numeroBillete=numeroBillete - 1;
               }
               else{
                    System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");
               }
           }
           else{
               if (balanceClienteActual >= precioBillete){
                   System.out.println("##################");
                   System.out.println("# Billete de tren:");
                   System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                   System.out.println("# " + precioBillete + " euros.");
                   System.out.println("##################");
                   System.out.println();
                   // Actualiza el total de dinero acumulado en la maquina
                   totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                   // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                   balanceClienteActual = balanceClienteActual - precioBillete;
                   numeroBillete=numeroBillete - 1;
               }
               else{
                   System.out.println("No hay suficiente dinero");
               }
           }
        }
        else{
           System.out.println("Lo sentimos, la maquina no dispone de billetes");
        }
    }
   /**
   * Cancela la operacion de compra del cliente actual y le
   * devuelve al cliente el dinero que ha introducido hasta el momento
   */
   public int cancelarOperacionYDevolverDinero(){
       int cantidadDeDineroADevolver;
       cantidadDeDineroADevolver = balanceClienteActual;
       balanceClienteActual = 0;
       return cantidadDeDineroADevolver;
   } 
   public int vaciarDineroDeLaMaquina(){
       int vaciarDineroDeLaMaquina = -1;
       if (balanceClienteActual > 0) {
           System.out.println("Operacion en curso error");
       }
       else {
           vaciarDineroDeLaMaquina = balanceClienteActual + totalDineroAcumulado;
           balanceClienteActual = 0;
           totalDineroAcumulado = 0;
       }
       return vaciarDineroDeLaMaquina;
   }
}




