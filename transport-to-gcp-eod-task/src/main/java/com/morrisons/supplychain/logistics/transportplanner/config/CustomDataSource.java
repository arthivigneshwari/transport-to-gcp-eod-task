/*package com.morrisons.supplychain.logistics.transportplanner.config;

import java.net.URI;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.RdsUtilities;
import software.amazon.awssdk.services.rds.model.GenerateAuthenticationTokenRequest;

public class CustomDataSource extends HikariDataSource{
	
	public CustomDataSource(HikariConfig hikariConfig){
        super(hikariConfig);
    }

    @Override
    public String getPassword() {
        RdsClient rdsClient = RdsClient.builder()
                .region(new DefaultAwsRegionProviderChain().getRegion())
                .build();

        RdsUtilities rdsUtilities = rdsClient.utilities();

        URI jdbcUri = parseJdbcURL(getJdbcUrl());
        GenerateAuthenticationTokenRequest request = GenerateAuthenticationTokenRequest.builder()
                .username(getUsername())
                .hostname(jdbcUri.getHost())
                .port(jdbcUri.getPort())
                .build();
        return rdsUtilities.generateAuthenticationToken(request);
    }

    private URI parseJdbcURL(String jdbcUrl) {
        String uri = jdbcUrl.substring(17);
        return URI.create(uri);
    }

}*/
