package com.inexture.UserFinalTaskBoot;

import static org.junit.jupiter.api.Assertions.fail;

import com.inexture.UserFinalTaskBoot.Servlets.FrontController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles({"profile1","dev"})
@ContextConfiguration(classes = ViewConfigurationClass.class)
class UserFinalTaskBootApplicationTests {

	@Test
	void main() {
		UserFinalTaskBootApplication.main(new String[] {});
	}

}
