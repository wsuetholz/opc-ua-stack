package com.digitalpetri.opcua.stack.core.types.structured;

import com.digitalpetri.opcua.stack.core.serialization.DelegateRegistry;
import com.digitalpetri.opcua.stack.core.serialization.UaDecoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEncoder;
import com.digitalpetri.opcua.stack.core.serialization.UaStructure;
import com.digitalpetri.opcua.stack.core.types.UaDataType;
import com.digitalpetri.opcua.stack.core.types.builtin.ByteString;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.StatusCode;
import com.digitalpetri.opcua.stack.core.Identifiers;

@UaDataType("BrowseResult")
public class BrowseResult implements UaStructure {

    public static final NodeId TypeId = Identifiers.BrowseResult;
    public static final NodeId BinaryEncodingId = Identifiers.BrowseResult_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.BrowseResult_Encoding_DefaultXml;

    protected final StatusCode _statusCode;
    protected final ByteString _continuationPoint;
    protected final ReferenceDescription[] _references;

    public BrowseResult() {
        this._statusCode = null;
        this._continuationPoint = null;
        this._references = null;
    }

    public BrowseResult(StatusCode _statusCode, ByteString _continuationPoint, ReferenceDescription[] _references) {
        this._statusCode = _statusCode;
        this._continuationPoint = _continuationPoint;
        this._references = _references;
    }

    public StatusCode getStatusCode() {
        return _statusCode;
    }

    public ByteString getContinuationPoint() {
        return _continuationPoint;
    }

    public ReferenceDescription[] getReferences() {
        return _references;
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


    public static void encode(BrowseResult browseResult, UaEncoder encoder) {
        encoder.encodeStatusCode("StatusCode", browseResult._statusCode);
        encoder.encodeByteString("ContinuationPoint", browseResult._continuationPoint);
        encoder.encodeArray("References", browseResult._references, encoder::encodeSerializable);
    }

    public static BrowseResult decode(UaDecoder decoder) {
        StatusCode _statusCode = decoder.decodeStatusCode("StatusCode");
        ByteString _continuationPoint = decoder.decodeByteString("ContinuationPoint");
        ReferenceDescription[] _references = decoder.decodeArray("References", decoder::decodeSerializable, ReferenceDescription.class);

        return new BrowseResult(_statusCode, _continuationPoint, _references);
    }

    static {
        DelegateRegistry.registerEncoder(BrowseResult::encode, BrowseResult.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(BrowseResult::decode, BrowseResult.class, BinaryEncodingId, XmlEncodingId);
    }

}
