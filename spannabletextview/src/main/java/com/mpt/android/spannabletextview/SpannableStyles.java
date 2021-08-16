package com.mpt.android.spannabletextview;

import ohos.agp.text.Font;
import ohos.agp.utils.Color;

/**
 * For different Spans.
 */

public class SpannableStyles {
    /**
     * To Specify the text.
     */

    private String text;
    /**
     * To Specify the textColor.
     */

    private int textColor;
    /**
     * To Specify the textSize.
     */

    private final int textSize;
    /**
     * To Specify the backgroundColor.
     */

    private final int backgroundColor;
    /**
     * To Specify the textSizeRelative.
     */

    private final float textSizeRelative;
    /**
     * To Specify the style.
     */

    private final int style;
    /**
     * To Specify the underline.
     */

    private final boolean underline;
    /**
     * To Specify the superscript.
     */

    private final boolean superscript;
    /**
     * To Specify the strike.
     */

    private final boolean strike;
    /**
     * To Specify the subscript.
     */

    private final boolean subscript;
    /**
     * To Specify the sliceId.
     */

    private final int sliceId;
    /**
     * To Specify the imageResource.
     */

    private final int imageResource;
    /**
     * OnTextClick Listener.
     */

    private final OnTextClick onTextClick;
    /**
     * To Specicy the shape.
     */

    private final boolean isRounded;
    /**
     * To Specify the cornerRadius.
     */

    private int cornerRadius;

    /**
     * To specify the default Absolute text size.
     */

    public static final int DEFAULT_ABSOLUTE_TEXT_SIZE = 0;

    /**
     * To specify the default Relative text size.
     */

    public static final float DEFAULT_RELATIVE_TEXT_SIZE = 1;
    /**
     * To specify the text properties for spans.
     *
     * @param builder builder
     */

    public SpannableStyles(Builder builder) {
        this.text = builder.text;
        this.textSize = builder.textSize;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.textSizeRelative = builder.textSizeRelative;
        this.style = builder.style;
        this.underline = builder.underline;
        this.superscript = builder.superscript;
        this.subscript = builder.subscript;
        this.strike = builder.strike;
        this.onTextClick = builder.onTextClick;
        this.sliceId = builder.sliceId;
        this.imageResource = builder.imageResource;
        this.isRounded = builder.isRounded;
        this.cornerRadius = builder.cornerRadius;
    }
    /**
     * To applay the rounded background shapes.
     */

    public boolean isRounded() {
        return isRounded;
    }

    /**
     * To get the backGround corner radius for text.
     */

    public int getCornerRadius() {
        return cornerRadius;
    }

    /**
     * Builder for different Spans.
     */

    public static class Builder {
        /**
         * To Specify the text.
         */

        private final String text;
        /**
         * To Specify the imageResource.
         */

        private int imageResource;
        /**
         * To specify the default Absolute text size.
         */

        private int textSize = DEFAULT_ABSOLUTE_TEXT_SIZE;
        /**
         * To Specify the textColor.
         */

        private int textColor = Color.BLACK.getValue();
        /**
         * To Specify the backgroundColor.
         */

        private int backgroundColor = -1;
        /**
         * To specify the default Relative text size.
         */

        private float textSizeRelative = DEFAULT_RELATIVE_TEXT_SIZE;
        /**
         * To specify the style.
         */

        private int style = Font.REGULAR;
        /**
         * To specify the underline.
         */

        private boolean underline = false;
        /**
         * To specify the strike.
         */

        private boolean strike = false;
        /**
         * To specify the superScript.
         */

        private boolean superscript = false;
        /**
         * To specify the subScript.
         */

        private boolean subscript = false;
        /**
         * onClickListener.
         */

        private OnTextClick onTextClick;
        /**
         * To specify the sliceID.
         */

        private int sliceId;
        /**
         * To specify the shape.
         */

        private boolean isRounded;
        /**
         * To specify the cornerRadius.
         */

        private int cornerRadius;

        /**
         * Creates a new Builder for this Piece.
         *
         * @param text the text of this Piece.
         */

        public Builder(String text) {
            this.text = text;
        }

        /**
         * Sets the absolute text size.
         *
         * @param sliceId text sliceId.
         * @return a Builder.
         */
        public Builder setSliceId(int sliceId) {
            this.sliceId = sliceId;
            return this;
        }

        /**
         * Sets the sets the corner radius.
         *
         * @param cornerRadius cornerRadius
         */

        public Builder setCornerRadius(int cornerRadius) {
            this.isRounded = true;
            this.cornerRadius = cornerRadius;
            return this;
        }

        /**
         * Sets the absolute text size.
         *
         * @param imageResource text imageResource
         * @return a Builder
         */
        public Builder setImageResource(int imageResource) {
            this.imageResource = imageResource;
            return this;
        }

        /**
         * Sets the absolute text size.
         *
         * @param textSize text size in pixels.
         * @return a Builder.
         */
        public Builder textSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        /**
         * Sets the text color.
         *
         * @param textColor the color.
         * @return a Builder.
         */
        public Builder textColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        /**
         * Sets the background color.
         *
         * @param backgroundColor the color.
         * @return a Builder.
         */
        public Builder backgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        /**
         * Sets the relative text size.
         *
         * @param textSizeRelative relative text size.
         * @return a Builder.
         */
        public Builder textSizeRelative(float textSizeRelative) {
            this.textSizeRelative = textSizeRelative;
            return this;
        }

        /**
         * Sets the text click event.
         *
         * @param onTextClick text click.
         * @return a Builder.
         */
        public Builder setOnTextClick(OnTextClick onTextClick) {
            this.onTextClick = onTextClick;
            return this;
        }

        /**
         * Sets a style to this Slice.
         *
         * @param style see {@link Font}.
         * @return a Builder.
         */
        public Builder style(int style) {
            this.style = style;
            return this;
        }

        /**
         * Underlines this Piece.
         *
         * @return a Builder.
         */
        public Builder underline() {
            this.underline = true;
            return this;
        }

        /**
         * Strikes this Piece.
         *
         * @return a Builder.
         */
        public Builder strike() {
            this.strike = true;
            return this;
        }

        /**
         * Sets this Piece as a superscript.
         *
         * @return a Builder.
         */
        public Builder superscript() {
            this.superscript = true;
            return this;
        }

        /**
         * Sets this Piece as a subscript.
         *
         * @return a Builder.
         */
        public Builder subscript() {
            this.subscript = true;
            return this;
        }

        /**
         * Creates a with the customized.
         * parameters.
         *
         * @return a Slice.
         */
        public SpannableStyles build() {
            return new SpannableStyles(this);
        }
    }


    /**
     * Sets the text color of this Piece.
     *
     * @param textColor textColor
     */

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    /**
     * Sets the text of this Slice.
     *
     * @param text text
     */

    public void setText(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public float getTextSizeRelative() {
        return textSizeRelative;
    }

    public int getStyle() {
        return style;
    }

    public boolean isUnderline() {
        return underline;
    }

    public boolean isSuperscript() {
        return superscript;
    }

    public boolean isStrike() {
        return strike;
    }

    public boolean isSubscript() {
        return subscript;
    }

    public OnTextClick getOnTextClick() {
        return onTextClick;
    }

    public int getSliceId() {
        return sliceId;
    }

    public int getImageResource() {
        return imageResource;
    }
}