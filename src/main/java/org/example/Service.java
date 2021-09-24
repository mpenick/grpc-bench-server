package org.example;

import io.grpc.stub.StreamObserver;
import org.example.proto.GreeterGrpc.GreeterImplBase;
import org.example.proto.Service.HelloReply;
import org.example.proto.Service.HelloRequest;

public class Service extends GreeterImplBase {
  public void sayHello(HelloRequest request,
      StreamObserver<HelloReply> responseObserver) {
    responseObserver.onNext(HelloReply.newBuilder().setMessage("Hi").build());
    responseObserver.onCompleted();
  }

  public StreamObserver<HelloRequest> sayHelloAgain(
      final StreamObserver<HelloReply> responseObserver) {
    return new StreamObserver<HelloRequest>() {
      @Override
      public void onNext(HelloRequest value) {
        responseObserver.onNext(HelloReply.newBuilder().setMessage("Hi").build());
      }

      @Override
      public void onError(Throwable t) {
        System.err.printf("Error: %s\n", t.getMessage());
      }

      @Override
      public void onCompleted() {
        responseObserver.onCompleted();
      }
    };
  }
}
