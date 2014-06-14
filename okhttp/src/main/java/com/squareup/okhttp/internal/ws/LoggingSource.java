package com.squareup.okhttp.internal.ws;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

public class LoggingSource extends ForwardingSource {
  public LoggingSource(Source delegate) {
    super(delegate);
  }

  @Override public long read(Buffer sink, long byteCount) throws IOException {
    long read = super.read(sink, byteCount);
    System.out.println("READ " + sink.clone().readByteString(read).hex());
    return read;
  }
}
