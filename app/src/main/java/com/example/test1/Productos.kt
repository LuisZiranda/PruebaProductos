package com.example.test1

import android.os.Parcel
import android.os.Parcelable

data class Productos (
    var id: Int,
    var title: String?,
    var description: String?,
    var price: Double,
    var discountPercentage: Double,
    var rating: Double,
    var stock: Int,
    var brand: String?,
    var category: String?,
    var thumbnail: String?,
    var images: List<String>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeInt(id)
        p0.writeString(title)
        p0.writeString(description)
        p0.writeDouble(price)
        p0.writeDouble(discountPercentage)
        p0.writeDouble(rating)
        p0.writeInt(stock)
        p0.writeString(brand)
        p0.writeString(category)
        p0.writeString(thumbnail)
    }

    companion object CREATOR : Parcelable.Creator<Productos> {
        override fun createFromParcel(parcel: Parcel): Productos {
            return Productos(parcel)
        }

        override fun newArray(size: Int): Array<Productos?> {
            return arrayOfNulls(size)
        }
    }
}
