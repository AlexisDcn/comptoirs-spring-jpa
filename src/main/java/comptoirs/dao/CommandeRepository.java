package comptoirs.dao;

import comptoirs.projection.CommandeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import comptoirs.entity.Commande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    /**
     * Calcule le montant des articles commandés dans une commande
     * @param numeroCommande le numéro de la commande à traiter
     * @return le montant des articles commandés, en tenant compte de la remise
     */
    @Query("""
            SELECT SUM(l.quantite * l.produit.prixUnitaire * (1 - l.commande.remise))
            FROM Ligne l
            WHERE l.commande.numero = :numeroCommande
            """)
    BigDecimal montantArticles(Integer numeroCommande);

    /**
     * Renvoie la liste des commandes pour un client donné avec les informations nécessaires
     * @param codeClient le code du client à traiter
     * @return la liste des commandes avec les informations nécessaires
     */
    @Query("""
            SELECT c.numero AS numeroCommande,
                   c.saisiele AS saisieLe,
                   c.envoyeele AS envoyeeLe,
                   c.port AS port,
                   c.destinataire AS destinataire,
                   c.remise AS remise
            FROM Commande c
            WHERE c.client.code = :codeClient
            """)
    List<CommandeProjection> findCommandesByClientCode(String codeClient);
}
