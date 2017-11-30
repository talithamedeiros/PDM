package com.example.talithamedeiros.meuslugares

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Lugar (
        var imagem : Bitmap?,
        var nome : String,
        var descricao : String,
        var localizacao : String?,
        var data : Date) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(Bitmap::class.java.classLoader),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readSerializable() as Date) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(imagem, 0)
        parcel.writeString(nome)
        parcel.writeString(descricao)
        parcel.writeString(localizacao)
        parcel.writeSerializable(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lugar> {
        override fun createFromParcel(parcel: Parcel): Lugar {
            return Lugar(parcel)
        }

        override fun newArray(size: Int): Array<Lugar?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return this.nome
    }

}