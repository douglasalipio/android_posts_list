package com.babylon.mesquita.interview.data.remote

import androidx.room.Entity
import androidx.room.TypeConverters
import com.babylon.mesquita.interview.data.local.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "author")
data class AuthorResponse(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("username")
    @Expose
    var username: String,
    @SerializedName("email")
    @Expose
    var email: String,
    @TypeConverters(AddressConvert::class)
    @SerializedName("address")
    @Expose
    var address: Address,
    @SerializedName("phone")
    @Expose
    var phone: String,
    @SerializedName("website")
    @Expose
    var website: String,
    @TypeConverters(CompanyConvert::class)
    @SerializedName("company")
    @Expose
    var company: Company,
    var urlAvatar: String = RANDOM_IMAGE
)

@Entity(tableName = "comment")
data class CommentResponse(
    @SerializedName("postId")
    @Expose
    var postId: Int,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("email")
    @Expose
    var email: String,
    @SerializedName("body")
    @Expose
    var body: String
)

@Entity(tableName = "post")
data class PostResponse(
    @SerializedName("userId")
    @Expose
    var authorId: Int,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("body")
    @Expose
    var body: String,
    var avatarUrl: String
)

@Entity(tableName = "avatar")
data class AvatarResponse(
    @SerializedName("results")
    @Expose
    @TypeConverters(ResultConvert::class)
    var results: List<Result>
)

@Entity
data class Company(
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("catchPhrase")
    @Expose
    var catchPhrase: String,
    @SerializedName("bs")
    @Expose
    var bs: String
)

@Entity
data class Address(
    @SerializedName("street")
    @Expose
    var street: String,
    @SerializedName("suite")
    @Expose
    var suite: String,
    @SerializedName("city")
    @Expose
    var city: String,
    @SerializedName("zipcode")
    @Expose
    var zipcode: String,
    @TypeConverters(GeoConvert::class)
    @SerializedName("geo")
    @Expose
    var geocode: Geo
)

@Entity
data class Geo(
    @SerializedName("lat")
    @Expose
    var lat: String,
    @SerializedName("lng")
    @Expose
    var lng: String
)

@Entity
data class Picture(
    @SerializedName("large")
    @Expose
    var large: String,
    @SerializedName("medium")
    @Expose
    var medium: String,
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String
)

@Entity
data class Result(
    @TypeConverters(PictureConvert::class)
    @SerializedName("picture")
    @Expose
    var picture: Picture
)