package com.android_easing

import android.util.TypedValue
import android.view.View


fun View.pxToDP(px: Float): Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
}