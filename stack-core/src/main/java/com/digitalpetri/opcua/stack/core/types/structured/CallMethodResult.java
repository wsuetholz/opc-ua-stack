package com.digitalpetri.opcua.stack.core.types.structured;

import com.digitalpetri.opcua.stack.core.serialization.DelegateRegistry;
import com.digitalpetri.opcua.stack.core.serialization.UaDecoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEncoder;
import com.digitalpetri.opcua.stack.core.serialization.UaStructure;
import com.digitalpetri.opcua.stack.core.types.UaDataType;
import com.digitalpetri.opcua.stack.core.types.builtin.DiagnosticInfo;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.StatusCode;
import com.digitalpetri.opcua.stack.core.types.builtin.Variant;
import com.digitalpetri.opcua.stack.core.Identifiers;

@UaDataType("CallMethodResult")
public class CallMethodResult implements UaStructure {

    public static final NodeId TypeId = Identifiers.CallMethodResult;
    public static final NodeId BinaryEncodingId = Identifiers.CallMethodResult_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.CallMethodResult_Encoding_DefaultXml;

    protected final StatusCode _statusCode;
    protected final StatusCode[] _inputArgumentResults;
    protected final DiagnosticInfo[] _inputArgumentDiagnosticInfos;
    protected final Variant[] _outputArguments;

    public CallMethodResult() {
        this._statusCode = null;
        this._inputArgumentResults = null;
        this._inputArgumentDiagnosticInfos = null;
        this._outputArguments = null;
    }

    public CallMethodResult(StatusCode _statusCode, StatusCode[] _inputArgumentResults, DiagnosticInfo[] _inputArgumentDiagnosticInfos, Variant[] _outputArguments) {
        this._statusCode = _statusCode;
        this._inputArgumentResults = _inputArgumentResults;
        this._inputArgumentDiagnosticInfos = _inputArgumentDiagnosticInfos;
        this._outputArguments = _outputArguments;
    }

    public StatusCode getStatusCode() {
        return _statusCode;
    }

    public StatusCode[] getInputArgumentResults() {
        return _inputArgumentResults;
    }

    public DiagnosticInfo[] getInputArgumentDiagnosticInfos() {
        return _inputArgumentDiagnosticInfos;
    }

    public Variant[] getOutputArguments() {
        return _outputArguments;
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


    public static void encode(CallMethodResult callMethodResult, UaEncoder encoder) {
        encoder.encodeStatusCode("StatusCode", callMethodResult._statusCode);
        encoder.encodeArray("InputArgumentResults", callMethodResult._inputArgumentResults, encoder::encodeStatusCode);
        encoder.encodeArray("InputArgumentDiagnosticInfos", callMethodResult._inputArgumentDiagnosticInfos, encoder::encodeDiagnosticInfo);
        encoder.encodeArray("OutputArguments", callMethodResult._outputArguments, encoder::encodeVariant);
    }

    public static CallMethodResult decode(UaDecoder decoder) {
        StatusCode _statusCode = decoder.decodeStatusCode("StatusCode");
        StatusCode[] _inputArgumentResults = decoder.decodeArray("InputArgumentResults", decoder::decodeStatusCode, StatusCode.class);
        DiagnosticInfo[] _inputArgumentDiagnosticInfos = decoder.decodeArray("InputArgumentDiagnosticInfos", decoder::decodeDiagnosticInfo, DiagnosticInfo.class);
        Variant[] _outputArguments = decoder.decodeArray("OutputArguments", decoder::decodeVariant, Variant.class);

        return new CallMethodResult(_statusCode, _inputArgumentResults, _inputArgumentDiagnosticInfos, _outputArguments);
    }

    static {
        DelegateRegistry.registerEncoder(CallMethodResult::encode, CallMethodResult.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(CallMethodResult::decode, CallMethodResult.class, BinaryEncodingId, XmlEncodingId);
    }

}
