package project.beryl.com.newfirebaseapplication.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import project.beryl.com.newfirebaseapplication.R;

public class BuzzTextView extends TextView {
    private int typefaceCode;
    public BuzzTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            // Get Custom Attribute Name and value
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs,
                    R.styleable.BuzzFonts);
            typefaceCode = styledAttrs.getInt(R.styleable.BuzzFonts_fontType, -1);
            // Typeface typeface = TypefaceCache.get(context.getAssets(), typefaceCode);
            //  setTypeface(typeface);

            styledAttrs.recycle();
            if (isInEditMode()) {
                return;
            }
        }
    }

    public BuzzTextView(Context context) {
        super(context);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text != null) {
            text = Html.fromHtml(text.toString());
        }
        super.setText(text, type);
    }
}
