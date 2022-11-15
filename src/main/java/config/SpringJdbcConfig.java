package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

import static utils.readProperties.databaseProperties;


@Configuration
@ComponentScan
public class SpringJdbcConfig {

    @Bean
    public DataSource postgresDataSource(){
        Properties databaseProperties = databaseProperties("database.properties");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(databaseProperties.getProperty("driver"));
        dataSource.setUrl(databaseProperties.getProperty("url"));
        dataSource.setUsername(databaseProperties.getProperty("user"));
        dataSource.setPassword(databaseProperties.getProperty("password"));
        return dataSource;
    }
}
