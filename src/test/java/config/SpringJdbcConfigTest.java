package config;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SpringJdbcConfigTest {

    @Test
    public void databaseProperties() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("database.properties").getFile());
        assertTrue(file.exists());
    }
}