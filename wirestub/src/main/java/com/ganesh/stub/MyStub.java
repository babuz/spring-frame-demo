package com.ganesh.stub;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.FileSource;

import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;
import org.springframework.util.NumberUtils;

import java.io.File;

import static com.github.tomakehurst.wiremock.core.WireMockApp.FILES_ROOT;
import static com.github.tomakehurst.wiremock.core.WireMockApp.MAPPINGS_ROOT;

public class MyStub implements CommandLineRunner {


    private int httpPort=8081;
    @Value("${testdata.location:classpath:testdata}")
    private File testDataLocation;
    private int containerThreads=10;
    private int acceptors=2;
    @Value("${jetty.accept-queue-size:#{T(java.lang.Integer).MAX_VALUE}}")
    private String acceptQueueSize;
    private int headerBufferSize=8192;

    private final Environment environment;

    public MyStub(final Environment environment) {
        this.environment = environment;
    }

    public static void main(final String[] args){
        SpringApplication.run(MyStub.class, args);
    }

    @Override
    public void run(final String... args){
        final FileSource fileSource = new SingleRootFileSource(testDataLocation);
        fileSource.createIfNecessary();

        final FileSource filesFileSource = fileSource.child(FILES_ROOT);
        filesFileSource.createIfNecessary();

        final FileSource mappingFileSource = fileSource.child(MAPPINGS_ROOT);
        mappingFileSource.createIfNecessary();

        final WireMockConfiguration options = WireMockConfiguration.options();

        if(environment.acceptsProfiles("performance")){
            options.disableRequestJournal();
        }

        final WireMockServer wireMockServer = new WireMockServer(
                options
                        .port(httpPort)
                        .fileSource(fileSource)
                        .enableBrowserProxying(true)
                        .containerThreads(containerThreads)
                        .jettyAcceptors(acceptors)
                        .jettyAcceptQueueSize(NumberUtils.parseNumber(acceptQueueSize,Integer.class))
                        .jettyHeaderBufferSize(headerBufferSize)
                );

        wireMockServer.start();

    }
}
