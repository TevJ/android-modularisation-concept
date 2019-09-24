package com.techtev.coremodule.adapters

import android.util.Log
import androidx.annotation.VisibleForTesting
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.math.BigDecimal
import java.math.RoundingMode

val TAG = BigDecimalAdapter::class.java.simpleName

class BigDecimalAdapter : JsonAdapter<BigDecimal>() {
    override fun fromJson(reader: JsonReader): BigDecimal? = try {
        var number = reader.nextString()
        if (hasMoreThan3DecimalDigits(number)) {
            Log.w(TAG, "Api response value $number has more decimal digits than 2")
        }
        if (number.contains(",")) {
            number = number.replace(",", "")
            Log.w(TAG, "Api response value $number contains ,")
        }
        // we are not expecting numbers with more than 2 decimal digits.
        // If so we even out the differences by using HALF_UP which is common in financial applications.
        BigDecimal(number).setScale(2, RoundingMode.HALF_UP)
    } catch (e: Exception) {
        Log.e(
            TAG, "Could not parse value to BigDecimal",
            Exception("Could not parse value to BigDecimal", e)
        )
        null
    }

    override fun toJson(writer: JsonWriter, value: BigDecimal?) {
        value?.let { writer.value(it.toPlainString()) }
    }

    @VisibleForTesting
    fun hasMoreThan3DecimalDigits(number: String) =
        number.lastIndexOf(".").let { pos -> pos > -1 && pos < number.length - 3 }
}