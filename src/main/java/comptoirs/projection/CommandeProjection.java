package comptoirs.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CommandeProjection {
    Integer getNumeroCommande();
    LocalDate getSaisieLe();
    LocalDate getEnvoyeeLe();
    BigDecimal getPort();
    String getDestinataire();
    BigDecimal getRemise();
}
