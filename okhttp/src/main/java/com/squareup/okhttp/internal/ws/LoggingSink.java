package com.squareup.okhttp.internal.ws;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

public class LoggingSink extends ForwardingSink {
  public LoggingSink(Sink delegate) {
    super(delegate);
  }

  @Override public void write(Buffer source, long byteCount) throws IOException {
    System.out.println("WRITE " + source.clone().readByteString(byteCount).hex());
    super.write(source, byteCount);
  }
}
