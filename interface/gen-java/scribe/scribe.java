/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package scribe;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class scribe {

  public interface Iface extends com.facebook.fb303.FacebookService.Iface {

    public int Log(List<LogEntry> messages) throws TException;

  }

  public static class Client extends com.facebook.fb303.FacebookService.Client implements Iface {
    public Client(TProtocol prot)
    {
      this(prot, prot);
    }

    public Client(TProtocol iprot, TProtocol oprot)
    {
      super(iprot, oprot);
    }

    public int Log(List<LogEntry> messages) throws TException
    {
      send_Log(messages);
      return recv_Log();
    }

    public void send_Log(List<LogEntry> messages) throws TException
    {
      oprot_.writeMessageBegin(new TMessage("Log", TMessageType.CALL, seqid_));
      Log_args args = new Log_args();
      args.messages = messages;
      args.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public int recv_Log() throws TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      Log_result result = new Log_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new TApplicationException(TApplicationException.MISSING_RESULT, "Log failed: unknown result");
    }

  }
  public static class Processor extends com.facebook.fb303.FacebookService.Processor implements TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(Iface iface)
    {
      super(iface);
      iface_ = iface;
      processMap_.put("Log", new Log());
    }

    private Iface iface_;

    public boolean process(TProtocol iprot, TProtocol oprot) throws TException
    {
      TMessage msg = iprot.readMessageBegin();
      ProcessFunction fn = processMap_.get(msg.name);
      if (fn == null) {
        TProtocolUtil.skip(iprot, TType.STRUCT);
        iprot.readMessageEnd();
        TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
        oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
        x.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
        return true;
      }
      fn.process(msg.seqid, iprot, oprot);
      return true;
    }

    private class Log implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        Log_args args = new Log_args();
        args.read(iprot);
        iprot.readMessageEnd();
        Log_result result = new Log_result();
        result.success = iface_.Log(args.messages);
        result.setSuccessIsSet(true);
        oprot.writeMessageBegin(new TMessage("Log", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }

    }

  }

  public static class Log_args implements TBase, java.io.Serializable, Cloneable, Comparable<Log_args>   {
    private static final TStruct STRUCT_DESC = new TStruct("Log_args");
    private static final TField MESSAGES_FIELD_DESC = new TField("messages", TType.LIST, (short)1);

    public List<LogEntry> messages;
    public static final int MESSAGES = 1;

    // isset id assignments

    public static final Map<Integer, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new HashMap<Integer, FieldMetaData>() {{
      put(MESSAGES, new FieldMetaData("messages", TFieldRequirementType.DEFAULT, 
          new ListMetaData(TType.LIST, 
              new StructMetaData(TType.STRUCT, LogEntry.class))));
    }});

    static {
      FieldMetaData.addStructMetaDataMap(Log_args.class, metaDataMap);
    }

    public Log_args() {
    }

    public Log_args(
      List<LogEntry> messages)
    {
      this();
      this.messages = messages;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public Log_args(Log_args other) {
      if (other.isSetMessages()) {
        List<LogEntry> __this__messages = new ArrayList<LogEntry>();
        for (LogEntry other_element : other.messages) {
          __this__messages.add(new LogEntry(other_element));
        }
        this.messages = __this__messages;
      }
    }

    public Log_args deepCopy() {
      return new Log_args(this);
    }

    @Deprecated
    public Log_args clone() {
      return new Log_args(this);
    }

    public List<LogEntry> getMessages() {
      return this.messages;
    }

    public Log_args setMessages(List<LogEntry> messages) {
      this.messages = messages;
      return this;
    }

    public void unsetMessages() {
      this.messages = null;
    }

    // Returns true if field messages is set (has been asigned a value) and false otherwise
    public boolean isSetMessages() {
      return this.messages != null;
    }

    public void setMessagesIsSet(boolean value) {
      if (!value) {
        this.messages = null;
      }
    }

    public void setFieldValue(int fieldID, Object value) {
      switch (fieldID) {
      case MESSAGES:
        if (value == null) {
          unsetMessages();
        } else {
          setMessages((List<LogEntry>)value);
        }
        break;

      default:
        throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
      }
    }

    public Object getFieldValue(int fieldID) {
      switch (fieldID) {
      case MESSAGES:
        return getMessages();

      default:
        throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
      }
    }

    // Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise
    public boolean isSet(int fieldID) {
      switch (fieldID) {
      case MESSAGES:
        return isSetMessages();
      default:
        throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
      }
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof Log_args)
        return this.equals((Log_args)that);
      return false;
    }

    public boolean equals(Log_args that) {
      if (that == null)
        return false;

      boolean this_present_messages = true && this.isSetMessages();
      boolean that_present_messages = true && that.isSetMessages();
      if (this_present_messages || that_present_messages) {
        if (!(this_present_messages && that_present_messages))
          return false;
        if (!this.messages.equals(that.messages))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(Log_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      Log_args typedOther = (Log_args)other;

      lastComparison = Boolean.valueOf(isSetMessages()).compareTo(isSetMessages());
      if (lastComparison != 0) {
        return lastComparison;
      }
      lastComparison = TBaseHelper.compareTo(messages, typedOther.messages);
      if (lastComparison != 0) {
        return lastComparison;
      }
      return 0;
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id)
        {
          case MESSAGES:
            if (field.type == TType.LIST) {
              {
                TList _list0 = iprot.readListBegin();
                this.messages = new ArrayList<LogEntry>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  LogEntry _elem2;
                  _elem2 = new LogEntry();
                  _elem2.read(iprot);
                  this.messages.add(_elem2);
                }
                iprot.readListEnd();
              }
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          default:
            TProtocolUtil.skip(iprot, field.type);
            break;
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();


      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (this.messages != null) {
        oprot.writeFieldBegin(MESSAGES_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.messages.size()));
          for (LogEntry _iter3 : this.messages)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("Log_args(");
      boolean first = true;

      sb.append("messages:");
      if (this.messages == null) {
        sb.append("null");
      } else {
        sb.append(this.messages);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check that fields of type enum have valid values
    }

  }

  public static class Log_result implements TBase, java.io.Serializable, Cloneable, Comparable<Log_result>   {
    private static final TStruct STRUCT_DESC = new TStruct("Log_result");
    private static final TField SUCCESS_FIELD_DESC = new TField("success", TType.I32, (short)0);

    /**
     * 
     * @see ResultCode
     */
    public int success;
    public static final int SUCCESS = 0;

    // isset id assignments
    private static final int __SUCCESS_ISSET_ID = 0;
    private BitSet __isset_bit_vector = new BitSet(1);

    public static final Map<Integer, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new HashMap<Integer, FieldMetaData>() {{
      put(SUCCESS, new FieldMetaData("success", TFieldRequirementType.DEFAULT, 
          new FieldValueMetaData(TType.I32)));
    }});

    static {
      FieldMetaData.addStructMetaDataMap(Log_result.class, metaDataMap);
    }

    public Log_result() {
    }

    public Log_result(
      int success)
    {
      this();
      this.success = success;
      setSuccessIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public Log_result(Log_result other) {
      __isset_bit_vector.clear();
      __isset_bit_vector.or(other.__isset_bit_vector);
      this.success = other.success;
    }

    public Log_result deepCopy() {
      return new Log_result(this);
    }

    @Deprecated
    public Log_result clone() {
      return new Log_result(this);
    }

    /**
     * 
     * @see ResultCode
     */
    public int getSuccess() {
      return this.success;
    }

    /**
     * 
     * @see ResultCode
     */
    public Log_result setSuccess(int success) {
      this.success = success;
      setSuccessIsSet(true);
      return this;
    }

    public void unsetSuccess() {
      __isset_bit_vector.clear(__SUCCESS_ISSET_ID);
    }

    // Returns true if field success is set (has been asigned a value) and false otherwise
    public boolean isSetSuccess() {
      return __isset_bit_vector.get(__SUCCESS_ISSET_ID);
    }

    public void setSuccessIsSet(boolean value) {
      __isset_bit_vector.set(__SUCCESS_ISSET_ID, value);
    }

    public void setFieldValue(int fieldID, Object value) {
      switch (fieldID) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Integer)value);
        }
        break;

      default:
        throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
      }
    }

    public Object getFieldValue(int fieldID) {
      switch (fieldID) {
      case SUCCESS:
        return getSuccess();

      default:
        throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
      }
    }

    // Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise
    public boolean isSet(int fieldID) {
      switch (fieldID) {
      case SUCCESS:
        return isSetSuccess();
      default:
        throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
      }
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof Log_result)
        return this.equals((Log_result)that);
      return false;
    }

    public boolean equals(Log_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true;
      boolean that_present_success = true;
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (this.success != that.success)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(Log_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      Log_result typedOther = (Log_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      lastComparison = TBaseHelper.compareTo(success, typedOther.success);
      if (lastComparison != 0) {
        return lastComparison;
      }
      return 0;
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id)
        {
          case SUCCESS:
            if (field.type == TType.I32) {
              this.success = iprot.readI32();
              setSuccessIsSet(true);
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          default:
            TProtocolUtil.skip(iprot, field.type);
            break;
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();


      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      oprot.writeStructBegin(STRUCT_DESC);

      if (this.isSetSuccess()) {
        oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        oprot.writeI32(this.success);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("Log_result(");
      boolean first = true;

      sb.append("success:");
      String success_name = ResultCode.VALUES_TO_NAMES.get(this.success);
      if (success_name != null) {
        sb.append(success_name);
        sb.append(" (");
      }
      sb.append(this.success);
      if (success_name != null) {
        sb.append(")");
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check that fields of type enum have valid values
      if (isSetSuccess() && !ResultCode.VALID_VALUES.contains(success)){
        throw new TProtocolException("The field 'success' has been assigned the invalid value " + success);
      }
    }

  }

}
