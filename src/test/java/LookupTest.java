import cz.etn.emailvalidator.DNSLookup;
import cz.etn.emailvalidator.Email;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by tomaspavel on 16.2.17.
 */
public class LookupTest {

	@Test
	void ipLookupTest() {
		List<String> ips = DNSLookup.getIPAddresses("seznam.cz");
		assertFalse(ips.isEmpty());

		ips = DNSLookup.getIPAddresses("nejakablbost.cz");
		assertTrue(ips.isEmpty());
	}

	@Test
	void mxLookupTest() {
		Email email = new Email("karel@seznam.cz");
		assertTrue(email.hasMXRecord());

		email = new Email("karel@nejakablbost.cz");
		assertFalse(email.hasMXRecord());
	}
}