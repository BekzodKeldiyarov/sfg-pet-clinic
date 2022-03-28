package springpetproject;

import com.bekzodkeldiyarov.springpetproject.SpringPetProjectApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringPetProjectApplication.class)
class SpringPetProjectApplicationTests {

    @Test
    void contextLoads() {
    }

}
