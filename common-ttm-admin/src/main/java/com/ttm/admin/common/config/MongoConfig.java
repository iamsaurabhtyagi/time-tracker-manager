package com.ttm.admin.common.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

//@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	private String DATABASE_NAME = "time_tracker_manager";
	private String DATABASE_URL = "mongodb://localhost:27017/time_tracker_manager";

	@Override
	protected String getDatabaseName() {
		return DATABASE_NAME;
	}

	@Bean
	public MongoClient mongo() {
		ConnectionString connString = new ConnectionString(DATABASE_URL);
		MongoClientSettings mcSetting = MongoClientSettings.builder().applyConnectionString(connString).build();
		return MongoClients.create(mcSetting);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongo(), DATABASE_NAME);
	}

	@Override
	public Collection<String> getMappingBasePackages() {
		return Collections.singleton("com.ttm.admin");
	}

}
