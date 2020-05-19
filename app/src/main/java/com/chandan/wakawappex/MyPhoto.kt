package com.chandan.wakawappex

import android.os.Parcel
import android.os.Parcelable

class MyPhoto() : Parcelable {
    var albumId : Int? = null
    var id : Int? = null
    var title : String? = null
    var thumbnailUrl : String? = null
    var url: String? = null

    constructor(parcel: Parcel) : this() {
        albumId = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
        thumbnailUrl = parcel.readString()
        url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(albumId)
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(thumbnailUrl)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyPhoto> {
        override fun createFromParcel(parcel: Parcel): MyPhoto {
            return MyPhoto(parcel)
        }

        override fun newArray(size: Int): Array<MyPhoto?> {
            return arrayOfNulls(size)
        }
    }


}

