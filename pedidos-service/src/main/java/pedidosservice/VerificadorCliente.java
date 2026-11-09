package pedidosservice;

import com.uptc.grpcmsg.clientesservice.grpc.ClienteGrpcGrpc.ClienteGrpcBlockingStub;
import com.uptc.grpcmsg.clientesservice.grpc.ClienteRequest;
import org.springframework.stereotype.Component;

@Component
public class VerificadorCliente {

    private final ClienteGrpcBlockingStub stub;

    VerificadorCliente(ClienteGrpcBlockingStub stub) {
        this.stub = stub;
    }

    public boolean existe(long clienteId) {
        var request = ClienteRequest.newBuilder().setId(clienteId).build();
        return stub.existeCliente(request).getExiste();
    }

}
