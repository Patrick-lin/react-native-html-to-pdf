package android.print;

import com.facebook.react.bridge.ReadableMap;
import android.print.PrintAttributes.MediaSize;

public class PdfOptions {
  private boolean mShouldEncode;
  private MediaSize mMediaSize = MediaSize.NA_GOVT_LETTER;

  public boolean getShouldEncode() {
    return mShouldEncode;
  }

  public MediaSize getMediaSize() {
    return mMediaSize;
  }

  public PdfOptions(final ReadableMap options) {
    mShouldEncode = options.hasKey("base64") && options.getBoolean("base64") == true;
    if (options.hasKey("page")) {
      setPage(options.getMap("page"));
    }
  }

  private void setPage(final ReadableMap page) {
    if (page.hasKey("format")) {
      mMediaSize = getFormat(page.getString("format"));
    }
  }

  private MediaSize getFormat(final String format) {
    switch (format) {
      case "A0":
        return MediaSize.ISO_A0;
      case "A1":
        return MediaSize.ISO_A1;
      case "A2":
        return MediaSize.ISO_A2;
      case "A3":
        return MediaSize.ISO_A3;
      case "A4":
        return MediaSize.ISO_A4;
      case "A5":
        return MediaSize.ISO_A5;
      case "A6":
        return MediaSize.ISO_A6;
      case "A7":
        return MediaSize.ISO_A7;
      default:
    }
    return MediaSize.NA_GOVT_LETTER;
  }
}
