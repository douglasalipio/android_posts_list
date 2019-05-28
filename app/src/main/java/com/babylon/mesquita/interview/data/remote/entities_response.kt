package com.babylon.mesquita.interview.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthorDTO(
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
    @SerializedName("address")
    @Expose
    var address: Address,
    @SerializedName("phone")
    @Expose
    var phone: String,
    @SerializedName("website")
    @Expose
    var website: String,
    @SerializedName("company")
    @Expose
    var company: Company
)

data class CommentDTO(
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

data class PostDTO(
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

data class AvatarDTO(
    @SerializedName("results")
    @Expose
    var results: List<Result>
)

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
    @SerializedName("geo")
    @Expose
    var geocode: Geo
)

data class Geo(
    @SerializedName("lat")
    @Expose
    var lat: String,
    @SerializedName("lng")
    @Expose
    var lng: String
)

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

data class Result(
    @SerializedName("picture")
    @Expose
    var picture: Picture
)

data class ZipDTO(
    val postDTO: List<PostDTO>,
    val commentsDTO: List<CommentDTO>,
    val authorDTO: List<AuthorDTO>
)
