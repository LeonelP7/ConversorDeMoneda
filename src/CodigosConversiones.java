import java.util.HashMap;
import java.util.Map;

public class CodigosConversiones {

    Map<String, String> currencyCodes = new HashMap();

    public CodigosConversiones() {
        currencyCodes.put("USD", "Dolar estadounidense");
        currencyCodes.put("COP", "Peso Colombiano");
        currencyCodes.put("ARS", "Peso Argentino");
        currencyCodes.put("BOB", "Boliviano boliviano");
        currencyCodes.put("BRL", "Real brasileño");
        currencyCodes.put("CLP", "Peso chileno");

    }

    public Map<String, String> getCurrencyCodes() {
        return currencyCodes;
    }

}
