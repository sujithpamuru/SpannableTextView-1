package com.mpt.android.spannabletextview;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.agp.text.Font;
import ohos.agp.text.RichTextBuilder;
import ohos.agp.text.TextForm;
import ohos.agp.utils.Color;
import ohos.app.Context;
import java.util.ArrayList;
import java.util.List;

/**
 * SpannableTextView.java  is for extra power to #TextView.
 */

public class SpannableTextView extends Text {
    /**
     * To store the data of slice.
     */

    private List<SpannableStyles> sliceList;

    private void init() {
        sliceList = new ArrayList<>();
    }
    /**
     * To specify the context of an object in SpannableTextView.
     *
     * @param context context
     */

    public SpannableTextView(Context context) {
        super(context);
        init();
    }
    /**
     * To specify the context and attributeset  of an object in SpannableTextView.
     *
     * @param context context
     *
     * @param attrSet attrSet
     */

    public SpannableTextView(Context context, AttrSet attrSet) {
        super(context, attrSet);
        init();
    }
    /**
     * To define the context ,attributeset and style.
     *
     * @param context context
     *
     * @param attrSet attrSet
     *
     * @param defStyleAttr defStyleAttr
     */

    public SpannableTextView(Context context, AttrSet attrSet, int defStyleAttr) {
        super(context, attrSet, String.valueOf(defStyleAttr));
        init();
    }

    /**
     * Use this method to add a {@link SpannableStyles} to a SuperTextView.
     * Each {@link SpannableStyles } is added sequentially, so the
     * order you call this method matters.
     *
     * @param slice the Slice
     */
    public void addSlice(SpannableStyles slice) {
        sliceList.add(slice);
    }

    /**
     * Adds a Slice at this specific location. The underlying data structure is a
     * {@link List}, so expect the same type of behaviour.
     *
     * @param slice    the Slice to add.
     * @param location the index at which to add.
     */
    public void addSlice(SpannableStyles slice, int location) {
        sliceList.add(location, slice);
    }

    /**
     * Replaces the Slice at the specified location with this new Slice.
     *
     * @param location location
     *
     * @param newSlice newSlice
     */

    public void replaceSliceAt(int location, SpannableStyles newSlice) {
        sliceList.set(location, newSlice);
    }

    /**
     * Removes the Slice at this specified location.
     *
     * @param location location
     */

    public void removeSlice(int location) {
        sliceList.remove(location);
    }

    /**
     * Get a specific {@link SpannableStyles} in position index.
     *
     * @param location location
     */

    public SpannableStyles getSlice(int location) {
        if (location >= 0 && location < sliceList.size()) {
            return sliceList.get(location);
        }
        return null;
    }

    /**
     * Call this method when you're done adding {@link SpannableStyles}s.
     */

    public void display() {
        // generate the final string based on the pieces.
        final RichTextBuilder richTextBuilder =  new RichTextBuilder();
        for (SpannableStyles slice : sliceList) {
            applySpannableTo(slice, richTextBuilder);
        }
        // set the styled text.
        setRichText(richTextBuilder.build());
    }

    private RichTextBuilder applySpannableTo(final SpannableStyles slice, RichTextBuilder richTextBuilder) {

        // Currently there is no Support for SubscriptSpan.
        // But, Subscript is handled through DependentLayout.
        // This will be implemented in next upcoming versions.
        if (slice.isSubscript()) {
            richTextBuilder = setSpan(new TextForm().setSubscript(true), richTextBuilder);
        }

        // Currently there is no Support for SuperscriptSpan.
        // But, Subscript is handled through DependentLayout.
        // This will be implemented in next upcoming versions.
        if (slice.isSuperscript()) {
            richTextBuilder = setSpan(new TextForm().setSuperscript(true), richTextBuilder);
        }

        // strike
        if (slice.isStrike()) {
            richTextBuilder = setSpan(new TextForm().setScaleX(1.5f).setStrikethrough(true), richTextBuilder);
        }

        // underline
        if (slice.isUnderline()) {
            richTextBuilder = setSpan(new TextForm().setUnderline(true), richTextBuilder);
        }

        // Currently there is no Support for ClickableSpan.
        // But, onClick is handled through OnClickListener.
        // This will be implemented in next upcoming versions.
        if (slice.getOnTextClick() != null) {
            richTextBuilder = setSpan(new TextForm().setScaleX(1.5f), richTextBuilder);
        }

        // Image resource.
        // Currently there is no Support for ImageSpan.
        // But, Image resource was handled as follows.
        // This will be implemented in next upcoming versions.
        if (slice.getImageResource() != 1) {
            final Image image = new Image(getContext());
            image.setPixelMap(slice.getImageResource());
        }

        // RoundedbackgroundSpan.
        // Currently there is no Support for RoundedbackgroundSpan.
        // RoundedbackgroundSpan is handled through DependentLayout.
        // This will be implemented in next upcoming versions.
        if (slice.isRounded()) {
            richTextBuilder = setSpan(new TextForm().setScaleX(1.5f), richTextBuilder);
        }

        // textstyle.
        if (slice.getStyle() != Font.REGULAR) {
            final Font.Builder fontBuilder = new Font.Builder(String.valueOf(slice.getStyle()));
            fontBuilder.setWeight(slice.getStyle());
            setSpan(new TextForm().setTextFont(fontBuilder.build()), richTextBuilder);
        }

        // absolute text size.
        if (slice.getTextSize() != SpannableStyles.DEFAULT_ABSOLUTE_TEXT_SIZE) {
            setSpan(new TextForm().setTextSize(slice.getTextSize()), richTextBuilder);
        }

        // relative text size.
        if (slice.getTextSizeRelative() != SpannableStyles.DEFAULT_RELATIVE_TEXT_SIZE) {
            setSpan(new TextForm().setRelativeTextSize(slice.getTextSizeRelative()), richTextBuilder);
        }

        // text color.
        if (slice.getTextColor() != Color.BLACK.getValue()) {
            setSpan(new TextForm().setTextColor(slice.getTextColor()), richTextBuilder);
        }

        // BackgroundColorSpan.
        // Currently there is no Support for BackgroundColorSpan.
        // BackgroundColorSpan is handled through DependentLayout.
        // This will be implemented in next upcoming versions.
        if (slice.getBackgroundColor() != -1) {
            richTextBuilder = setSpan(new TextForm().setTextBackgroundColor(Color.BLACK.getValue()), richTextBuilder);
        }

        richTextBuilder.addText(slice.getText());
        richTextBuilder.revertForm();
        return richTextBuilder;
    }

    /**
     * Resets the styling of this view and sets it's content to an empty String.
     */
    public void reset() {
        sliceList = new ArrayList<>();
        setText("");
    }

    /**
     * Change text color of all pieces of textview.
     *
     * @param textColor textColor
     */
    public void changeTextColor(int textColor) {
        for (SpannableStyles slice : sliceList) {
            slice.setTextColor(textColor);
        }
        display();
    }

    /**
     * To set the all spans.
     *
     * @param what what
     *
     * @param builder builder
     */
    public RichTextBuilder setSpan(Object what, RichTextBuilder builder) {
        builder.mergeForm((TextForm) what);
        return builder;
    }
}