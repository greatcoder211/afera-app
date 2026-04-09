package pl.afera.aferaapp.legacyCode;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.afera.aferaapp.Party;
import pl.afera.aferaapp.Politician;
import pl.afera.aferaapp.repository.PartyRepository;

import java.sql.Types;
import java.util.Arrays;

@Repository
public class JdbcPartyRepository implements PartyRepository {
    private final JdbcTemplate jdbc;
    public JdbcPartyRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Party save(Party party) {
        long partyId = savePartyInfo(party);
        party.setId(partyId);
        for(Politician politician : party.getMembers()) {
            savePoliticianToParty(politician, partyId);
        }
        return party;
    }
    // TODO: Sprawdzić SimpleJdbcInsert (strona 19 z 32 rozdział 3 w książce)
    public long savePartyInfo(Party party) {
        PreparedStatementCreator psc =
                new PreparedStatementCreatorFactory(
                        "insert into Party (name, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney) values (?, ?, ?)",
                        Types.VARCHAR, Types.DECIMAL, Types.DECIMAL
                ).newPreparedStatementCreator(
                        Arrays.asList(
                                party.getName(),
                                party.getConfirmedEmbezzledAmountOfMoney(),
                        party.getUnconfirmedEmbezzledAmountOfMoney()));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }
    private void savePoliticianToParty(
            Politician politician, long partyId) {
        jdbc.update(
                "insert into Party_Politicians (party, politician) " +
                        "values (?, ?)",
                partyId, politician.getId());
    }

/*    public Iterable<Party> findAll() {

    }
    public Party findById(int id) {

    }
    public Party findByName(String name){

    }

 */
}
