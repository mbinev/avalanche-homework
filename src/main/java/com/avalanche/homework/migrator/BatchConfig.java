package com.avalanche.homework.migrator;

import com.avalanche.homework.migrator.processors.StarshipVesselProcessor;
import com.avalanche.homework.starship.model.Starship;
import com.avalanche.homework.vessel.model.Vessel;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class BatchConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    @Qualifier("starshipEntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean starshipEntityManager;

    @Autowired
    @Qualifier("vesselEntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean vesselEntityManager;

    @Autowired
    private JpaTransactionManager jpaTransactionManager;

    @Bean
    public Job migrateStarships() {
        return new JobBuilder("migrateStarships", jobRepository)
                .start(step())
                .build();
    }

    @Bean
    public Step step() {
        return new StepBuilder("migrateStep", jobRepository)
                .<Starship, Vessel>chunk(5, jpaTransactionManager)
                .reader(reader())
                .processor(new StarshipVesselProcessor())
                .writer(writer())
                .build();
    }

    @Bean
    public JpaPagingItemReader<Starship> reader() {
        return new JpaPagingItemReaderBuilder<Starship>()
                .name("starshipReader")
                .entityManagerFactory(starshipEntityManager.getObject())
                .queryString("SELECT s FROM Starship s")
                .pageSize(5)
                .build();
    }

    @Bean
    public JpaItemWriter<Vessel> writer() {
        return new JpaItemWriterBuilder<Vessel>()
                .entityManagerFactory(vesselEntityManager.getObject())
                .build();
    }

}
