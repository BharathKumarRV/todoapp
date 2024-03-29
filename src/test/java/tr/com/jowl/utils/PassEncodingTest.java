
package tr.com.jowl.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tr.com.jowl.Application;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The Password Encoding Test class
 *
 * @author ibrahim KARAYEL
 * @version 1.0 Date 4/27/2018.
 */
@ExtendWith(SpringExtension.class)

@SpringBootTest(classes=Application.class)
public class PassEncodingTest {

	public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private static final String password_ = "123456";

	@BeforeAll
	public static void oneTimeSetUp() {
		System.out.println("@BeforeAll - oneTimeSetUp");
	}

	@AfterAll
	public static void afterAll() { // one-time cleanup code
		System.out.println("@AfterAll - oneTimeTearDown");
	}

	@BeforeEach
	public void beforeEach() throws Exception {
		System.out.println("@BeforeEach - UserService setUp");
	}

	@AfterEach
	public void afterEach() throws Exception {
		System.out.println("@AfterEach - UserService tearDown");
	}

	@Test
	public void testPassword() {

		String pass = passwordEncoder.encode(password_);
		System.out.println(pass);
		assertNotEquals(pass, password_);

	}

}
