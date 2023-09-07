package com.example.zootopiapage

import android.os.Parcel
import android.os.Parcelable

data class ZootopiaInfo(
    val profileImageResourceId: Int,
    val name: String,
    val call: String,
    val email: String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(), // profileImageResourceId를 읽어옵니다.
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(profileImageResourceId) // profileImageResourceId를 쓰도록 수정합니다.
        parcel.writeString(name)
        parcel.writeString(call)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ZootopiaInfo> {
        override fun createFromParcel(parcel: Parcel): ZootopiaInfo {
            return ZootopiaInfo(parcel)
        }

        override fun newArray(size: Int): Array<ZootopiaInfo?> {
            return arrayOfNulls(size)
        }
    }
}
