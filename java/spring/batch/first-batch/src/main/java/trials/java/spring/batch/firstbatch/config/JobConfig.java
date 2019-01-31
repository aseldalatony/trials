package trials.java.spring.batch.firstbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableBatchProcessing
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class JobConfig extends DefaultBatchConfigurer {

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("step1").tasklet(new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("Hello, batch");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}

	@Bean
	public Job helloJob(JobBuilderFactory jobBuilderFactory, Step step) {
		return jobBuilderFactory.get("HelloJob").start(step).build();
	}
}
