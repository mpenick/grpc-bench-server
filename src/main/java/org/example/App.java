package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8090)
            .directExecutor()
            .addService(new Service())
            .build();
        server.start();
        server.awaitTermination();
    }
}
