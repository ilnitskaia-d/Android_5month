package com.example.lovecalculator.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

@Parcelize
@Entity(tableName = "love-table")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("fname")
    var fname:String,
    @SerializedName("sname")
    var sname:String,
    var percentage:String,
    var result:String
):Parcelable
