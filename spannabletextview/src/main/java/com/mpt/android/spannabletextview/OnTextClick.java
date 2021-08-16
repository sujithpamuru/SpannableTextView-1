package com.mpt.android.spannabletextview;

import ohos.agp.components.Component;

/**
 * Listener for onClick.
 */

public interface OnTextClick {
    /**
     * To perform onClick action.
     *
     * @param component component
     *
     * @param slice slice
     */

    void onTextClick(Component component, SpannableStyles slice);
}