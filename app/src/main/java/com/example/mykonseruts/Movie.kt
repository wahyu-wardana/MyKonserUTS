package com.example.mykonseruts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var imageMovie: Int,
    var titleMovie: String,
    var descMovie: String
) : Parcelable
