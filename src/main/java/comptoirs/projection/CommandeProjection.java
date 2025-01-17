package comptoirs.projection;

import java.math.BigDecimal;

public interface CommandeProjection {
    Integer getNumeroCommande();
    BigDecimal getPort();
    BigDecimal getMontantArticles(); // Ajout du champ montantArticles
}
