package com.digitalpetri.opcua.stack.core.types.structured;

import com.digitalpetri.opcua.stack.core.serialization.DelegateRegistry;
import com.digitalpetri.opcua.stack.core.serialization.UaDecoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEncoder;
import com.digitalpetri.opcua.stack.core.serialization.UaRequestMessage;
import com.digitalpetri.opcua.stack.core.types.UaDataType;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.Identifiers;

@UaDataType("UnregisterNodesRequest")
public class UnregisterNodesRequest implements UaRequestMessage {

    public static final NodeId TypeId = Identifiers.UnregisterNodesRequest;
    public static final NodeId BinaryEncodingId = Identifiers.UnregisterNodesRequest_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.UnregisterNodesRequest_Encoding_DefaultXml;

    protected final RequestHeader _requestHeader;
    protected final NodeId[] _nodesToUnregister;

    public UnregisterNodesRequest() {
        this._requestHeader = null;
        this._nodesToUnregister = null;
    }

    public UnregisterNodesRequest(RequestHeader _requestHeader, NodeId[] _nodesToUnregister) {
        this._requestHeader = _requestHeader;
        this._nodesToUnregister = _nodesToUnregister;
    }

    public RequestHeader getRequestHeader() {
        return _requestHeader;
    }

    public NodeId[] getNodesToUnregister() {
        return _nodesToUnregister;
    }

    @Override
    public NodeId getTypeId() {
        return TypeId;
    }

    @Override
    public NodeId getBinaryEncodingId() {
        return BinaryEncodingId;
    }

    @Override
    public NodeId getXmlEncodingId() {
        return XmlEncodingId;
    }


    public static void encode(UnregisterNodesRequest unregisterNodesRequest, UaEncoder encoder) {
        encoder.encodeSerializable("RequestHeader", unregisterNodesRequest._requestHeader != null ? unregisterNodesRequest._requestHeader : new RequestHeader());
        encoder.encodeArray("NodesToUnregister", unregisterNodesRequest._nodesToUnregister, encoder::encodeNodeId);
    }

    public static UnregisterNodesRequest decode(UaDecoder decoder) {
        RequestHeader _requestHeader = decoder.decodeSerializable("RequestHeader", RequestHeader.class);
        NodeId[] _nodesToUnregister = decoder.decodeArray("NodesToUnregister", decoder::decodeNodeId, NodeId.class);

        return new UnregisterNodesRequest(_requestHeader, _nodesToUnregister);
    }

    static {
        DelegateRegistry.registerEncoder(UnregisterNodesRequest::encode, UnregisterNodesRequest.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(UnregisterNodesRequest::decode, UnregisterNodesRequest.class, BinaryEncodingId, XmlEncodingId);
    }

}
