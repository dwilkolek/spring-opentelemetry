package eu.wilkolek.springopentelemetry;

import com.zaxxer.hikari.HikariDataSource;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.jdbc.datasource.JdbcTelemetry;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;


@Configuration
class DataSourceConfig {
    @Bean
    public DataSource dataSource(DataSourceProperties properties, OpenTelemetry openTelemetry) {
        var dataSourceBuilder = DataSourceBuilder.create();
        //Data source configurations
        var dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
        return JdbcTelemetry.create(openTelemetry).wrap(dataSource);
    }
}